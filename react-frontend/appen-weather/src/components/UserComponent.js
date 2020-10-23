import React, { Component } from 'react'
import axios from 'axios'
import DayCard from './DayCard'
import GetCity from '../services/GetCity'
import DegreeToggle from './DegreeToggle'
import Graph from './Graph'
import GraphTitle from './GraphTitle'

const USERS_REST_API_URL = "http://localhost:8080/api/getWeather"

/**
 * Component for rendering the main page
 * 
 * @component
 */
class UserComponent extends Component {
    constructor(props) {
        super(props)
        this.updateDay = this.updateDay.bind(this)
    }
    state = {
        latitude: '',
        longitude: '',
        time: '',
        city: '',
        isSubmitted: false,
        weatherData: [],
        degreeType: "fahrenheit",
        currentDay: 0
    }

    /**
     * This is a lifecycle method that is executed once after the first render
     */
    componentDidMount (){
        let self = this;
        navigator.geolocation.getCurrentPosition(function(position) {
            self.setState({ latitude: position.coords.latitude.toString(),
                longitude: position.coords.longitude.toString() });
            self.setState({ time: Math.round((new Date()).getTime() / 1000).toString(),
                        city: GetCity.getCity(self.state.latitude, self.state.longitude)});
        })
    }

    /**
     * Updates the degree type in state (celsius or fahrenheit)
     */
    updateForecastDegree = (event) => {
        console.log(event.target.value)
        this.setState({
          degreeType: event.target.value
        }, () => console.log(this.state.degreeType));
        this.drawGraph();
      }

    onSubmit = (e) => {
        let self = this;
        e.preventDefault();
        navigator.geolocation.getCurrentPosition(function(position) {
            self.setState({ latitude: position.coords.latitude.toString(),
                longitude: position.coords.longitude.toString() });
            self.setState({ time: Math.round((new Date()).getTime() / 1000).toString()});
        })
        axios.post(USERS_REST_API_URL, {'latitude':this.state.latitude,
                                        'longitude':this.state.longitude,
                                        'time':this.state.time}).then(response => {
            if (response.data != null) {
                this.setState({ weatherData: response.data})
                this.setState({isSubmitted: true})
            }
        });
    }

    degreeToggleButtons = () => {
        if(this.state.isSubmitted){
            return <DegreeToggle key={this.state.currentDay} degreeType={this.state.degreeType} updateForecastDegree={this.updateForecastDegree}/>
        }
        return (<div></div>)
    }

    graphTitle = () => {
        if(this.state.isSubmitted){

            return <GraphTitle key={this.state.time} time={this.state.time - (86400*this.state.currentDay)} />
        }
        return (<div></div>)
    }

    drawGraph = () => {
        if(this.state.isSubmitted){
            var degreeIndex = 1;
            if (this.state.degreeType === "celsius"){
                degreeIndex = 0;
            }
            var h;
            for (h in this.state.weatherData){
                if (parseInt(h) === this.state.currentDay){
                    return <div className="d-flex justify-content-center"><Graph key={h} hourlyData={this.state.weatherData[h][degreeIndex].hourly}/></div>
                }
            }
        }
        return (<div></div>)
    }

    updateDay(dayIndex) {
        this.setState({ currentDay: dayIndex})
        this.graphTitle();
        this.drawGraph();
    }
    formatDayCards = () => {
        if(this.state.isSubmitted){
            return this.state.weatherData.map((reading, index) =>
                <DayCard reading={reading} key={index} index={index} degreeType={this.state.degreeType} updateDay={this.updateDay}/>)
        }
        return (<div></div>)
    }

    render() {
        return (
            <div><br />
                <h1 className = "text-center display-4">Local Weather Data App</h1>
                <form onSubmit={this.onSubmit}>
                <input 
                    type="submit"
                    value="Click Here to get the Weather Report!"
                    className="btn btn-primary btn-lg active"
                    style={{flex: '3'}} />
            </form><br />
            <div className="container">
            <h1 className="display-3 jumbotron">4-Day Forecast</h1>
            <h5 className="display-5 text-muted">{this.state.city}</h5>
            <div>{this.degreeToggleButtons()}</div><br />
                <div className="row justify-content-center">
                {this.formatDayCards()}
                </div><br />
                {this.graphTitle()}
                {this.drawGraph()}
            </div>
            </div>
        )
    }
}

export default UserComponent;