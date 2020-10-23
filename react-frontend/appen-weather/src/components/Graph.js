import React, { Component } from "react";
import Chart from "react-apexcharts";
import PropTypes from 'prop-types';

/**
 * Component for rendering the 24-hour graph for the day
 * 
 * @component
 */
class Graph extends Component {
    constructor(props) {
      super(props);
  
      this.state = {
        options: {
          chart: {
            id: "basic-bar"
          },
          xaxis: {
            categories: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23]
          }
        },
        series: [
          {
            name: "series-1",
            data: []
          }
        ]
      };
    }
    componentDidMount() {
        var hours = []
        var h;
        for (h in this.props.hourlyData) {
            hours.push(this.props.hourlyData[h].temp);
          }
        var newState = []
        var newData = { name: "series-1", data: hours}
        newState.push(newData)
        this.setState({ series: newState})
    }

    render() {
      return (
        <div className="app">
          <div className="row">
            <div className="mixed-chart">
              <Chart
                options={this.state.options}
                series={this.state.series}
                type="line"
                width="500"
              />
            </div>
          </div>
        </div>
      );
    }
  }
  
Graph.propTypes = {
  /**
   * A list of weather data for all hours in a day
   */
  hourlyData: PropTypes.array.isRequired
}

export default Graph;