import React from 'react';
import PropTypes from 'prop-types';
var moment = require('moment')

/**
 * Component for displaying a card for weather of a single day.
 * 
 * @component
 */
const DayCard = (props) => {
    const {reading, degreeType, updateDay, index} = props;
    let newDate = new Date();
    var degreeIndex = 1;
    if(degreeType === "celsius"){
        degreeIndex = 0;
    }
    const weekday = reading[degreeIndex].current.curr_time * 1000
    newDate.setTime(weekday)
  
    const imgURL = `owf owf-${reading[degreeIndex].current.weatherDescription[0].id} owf-5x`
  
    return (
      <div className="col-sm-3" onClick={() => updateDay(index)}>
        <div className="card">
          <h3 className="card-title">{moment(newDate).format('dddd')}</h3>
          <p className="text-muted">{moment(newDate).format('MMMM Do, h:mm a')}</p>
          <i className={imgURL}></i>
          {
              degreeIndex === 1
              ? <h2>{Math.round(reading[degreeIndex].current.temp)} °F</h2>
              : <h2>{Math.round(reading[degreeIndex].current.temp)} °C</h2>
          }
          <div className="card-body">
            <p className="card-text">{reading[degreeIndex].current.weatherDescription[0].description}</p>
          </div>
        </div>
      </div>
    )
  }
  
DayCard.propTypes = {
  /**
   * The weather readings of the specific day
   */
  reading: PropTypes.array.isRequired,
  /**
   * The unit of measurement(celsius or fahrenheit)
   */
  degreeType: PropTypes.string.isRequired,
  /**
   * The function that updates the index of the day
   */
  updateDay: PropTypes.func.isRequired,
  /**
   * The index of the day
   */
  index: PropTypes.number.isRequired
}

export default DayCard;
