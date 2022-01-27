package mendoza;

import java.util.ArrayList;

public class WeatherForecast {
    //Make sure that when you deserialize your JSON,
    // it creates a WeatherForecast object that contains a list of WeatherForecastItems.
    ArrayList<WeatherForecastItem> list;
    City city;

    public void setList(ArrayList<WeatherForecastItem> list) {
        this.list = list;
    }

    public ArrayList<WeatherForecastItem> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    //Displays WeatherForecastItems data for this WeatherForecast object
    public void displayForecast() {
        System.out.printf("Forecast for %s:%n", this.getCity().getName());
        System.out.println("Date/Time            Temperature     Description         Wind Speed");

        /*************************************************************************
        Have the program give the user a forecast for their specified city.
         It should display a list of the following for each 3 hours period:
            Time
            Temperature
            A description of the weather conditions (e.g., "clear sky")
            Wind speed
         *************************************************************************/
        this.list.forEach((w) -> System.out.printf("%-25s%-12.2f%-22s%.2f%n",w.getDt_txt(),
                w.getMeasurements().get("temp"), w.getWeather().get(0).getDescription(), w.getWind().get("speed")));
        System.out.println("===================================");
    }
}
