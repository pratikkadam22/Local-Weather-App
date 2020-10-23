import React from 'react';
import PropTypes from 'prop-types';

/**
 * Component to toggle the radio button of unit (Celsius or Fahrenheit)
 * 
 * @component 
 */
const DegreeToggle = ({degreeType, updateForecastDegree}) => {
  return (
    <React.Fragment>
    <div className="form-check form-check-inline">
        <input
        className="form-check-input"
        type="radio"
        name="degree-type"
        id="celsius"
        value="celsius"
        checked={degreeType === "celsius"}
        onChange={updateForecastDegree}
        />
        <label className="form-check-label" htmlFor="celsius">Celsius</label>
      </div>
      <div className="form-check form-check-inline">
        <input
        className="form-check-input"
        type="radio"
        name="degree-type"
        id="fahrenheit"
        value="fahrenheit"
        checked={degreeType === "fahrenheit"}
        onChange={updateForecastDegree}
        />
        <label className="form-check-label" htmlFor="farenheit">Farenheit</label>
      </div>
    </React.Fragment>
  )
}

DegreeToggle.propTypes = {
  /**
   * The unit of measurement(celsius or fahrenheit)
   */
  degreeType: PropTypes.string.isRequired,
  /**
   * The function that updates the type of degree (celsius or fahrenheit)
   */
  updateForecastDegree: PropTypes.func.isRequired
}
export default DegreeToggle;