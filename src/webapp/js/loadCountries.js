/**
 * Created by S2D on 7/7/15.
 */

$('document').ready(function(){
    $.getJSON('js/countries.json', function(data){
        var sortedCountries = _.sortBy(data, sortAlphabetically);
        function sortAlphabetically(country){
            return country;
        }

        _.each(sortedCountries, appendCountry);
        function appendCountry(country){
            var option = "<option value=" + country + ">" + country + "</option>";
            $('#signup_country').append(option);
        }
    });
});