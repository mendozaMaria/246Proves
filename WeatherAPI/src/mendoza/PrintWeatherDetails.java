package mendoza;

//STRETCH CHALLENGE
import java.util.ArrayList;

import static mendoza.WeatherAPICalls.*;

public class PrintWeatherDetails {

    //Prints the current weather conditions and the 5-day forecast

    public static void printCityWeather(String city) {

        WeatherConditions weather = getWeatherConditions(city);
        if (weather != null) {
            weather.displayWeather();
        }
        WeatherForecast weatherForecast = getCityForecast(city);
        if (weatherForecast != null) {
            weatherForecast.displayForecast();
        }

    }

    /**
     * Sort the cities by maximum temperature and display the results.
     * Then, perform a separate sort, this time by maximum wind, speed and display the results.
     */
    public static void printCityComparison(ArrayList<String> cities) {
        ArrayList<WeatherForecast> citiesWeather = new ArrayList<>();

        cities.forEach((city) -> citiesWeather.add(getCityForecast(city)));

        ArrayList<WeatherForecastShort> citiesSummary = new ArrayList<>();

        for (WeatherForecast cityWeather: citiesWeather) {
            String city = cityWeather.getCity().getName();

            //Sort the List by the Max Wind Speed
            cityWeather.getList().sort((c1, c2) -> c2.getMeasurements().get("temp_max").
                    compareTo(c1.getMeasurements().get("temp_max")));
            Float maxTemperature = cityWeather.getList().get(0).getMeasurements().get("temp_max");

            //Sort the List by the Max Wind Speed
            cityWeather.getList().sort((c1, c2) -> c2.getWind().get("speed").compareTo(c1.getWind().get("speed")));
            Float maxWindSpeed = cityWeather.getList().get(0).getWind().get("speed");
            citiesSummary.add(new WeatherForecastShort(city, maxTemperature, maxWindSpeed));
        }
        citiesSummary.sort((c1, c2) -> c2.getMaxTemperature().compareTo(c1.getMaxTemperature()));

        //PRINT THE SORTED INFORMATION
        System.out.println("Cities Sorted By Max Temperature:");
        System.out.println("City                Max Temperature         Max WindSpeed");
        citiesSummary.forEach((c) -> System.out.printf("%-25s%-25.2f%.2f%n", c.getCity(), c.getMaxTemperature(),
                c.getMaxWindSpeed()));
        System.out.println("===================================");

        citiesSummary.sort((c1, c2) -> c2.getMaxWindSpeed().compareTo(c1.getMaxWindSpeed()));

        System.out.println("Cities Sorted By Max Wind Speed:");
        System.out.println("City                Max Temperature         Max WindSpeed");
        citiesSummary.forEach((c) -> System.out.printf("%-25s%-25.2f%.2f%n", c.getCity(), c.getMaxTemperature(),
                c.getMaxWindSpeed()));
        System.out.println("===================================");
    }
}
