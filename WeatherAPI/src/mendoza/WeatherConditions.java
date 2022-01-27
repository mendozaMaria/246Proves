package mendoza;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

//**WeatherConditions class that can hold information that is retrieving back.**

public class WeatherConditions {
    Integer id;
    String name;
    // it maps a key of type String to a value of type float. Map Data Structure
    @SerializedName("main")
    Map<String, Float> measurements;

    public WeatherConditions(){
        this.id = 0;
        this.name = "";
        this.measurements = null;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeasurements(Map<String, Float> measurements) {
        this.measurements = measurements;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Float> getMeasurements() {
        return measurements;
    }

    //Prints the Weather Data of this object

    public void displayWeather(){
        System.out.printf("ID: %d%n", this.id );
        System.out.printf("Name: %s%n", this.name );
        this.measurements.forEach((k, v) -> System.out.printf("%s: %.2f%n", k, v));
    }

}
