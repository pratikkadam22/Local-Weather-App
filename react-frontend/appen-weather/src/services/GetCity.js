
/**
 * Class for retrieving the city from the given coordinates
 */
class GetCity {

    /**
     * Function to retrieve city, state and country of the location specified by latitude and longitude
     * @param  {string} latitude  The latitude coordinates
     * @param  {string} longitude The longitude coordinates
     * @return {string}           City, State, Country of the specified location
     */
    getCity(latitude, longitude) {
        var xhReq = new XMLHttpRequest();
        var url = "https://us1.locationiq.com/v1/reverse.php?key=pk.7fac93c8830180317f175b81ab04ff63&lat=" + 
        latitude + "&lon=" + longitude + "&format=json";
        xhReq.open("GET", url, false);
        xhReq.send(null);
        var jsonObject = JSON.parse(xhReq.responseText);
        return jsonObject.address.city + ", " + jsonObject.address.state + ", " + jsonObject.address.country
    }
}

export default new GetCity();