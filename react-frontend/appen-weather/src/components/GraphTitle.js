import React from 'react';
import PropTypes from 'prop-types';
var moment = require('moment')

/**
 * Component for rendering the Day and Date as the title of the graph
 * 
 * @component
 */
const GraphTitle = (props) => {
    const { time } = props;
    let newDate = new Date();
    const weekday = time * 1000
    newDate.setTime(weekday)
    return (<div>
        <h4 className="alert alert-success">Click on a day above to get its respective 24-hour graph</h4><br />
        <h3>
            {moment(newDate).format('dddd')}, {moment(newDate).format('MMMM Do')}
        </h3>
        </div>
    )
}

GraphTitle.propTypes = {
    /**
     * Time which is parsed and used as the title for the graph
     */
    time: PropTypes.number.isRequired
}

export default GraphTitle;