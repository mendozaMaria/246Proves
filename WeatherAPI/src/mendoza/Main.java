package mendoza;

import java.util.ArrayList;
import java.util.Scanner;

import static mendoza.PrintWeatherDetails.*;

public class Main {

    //Setting up some constants to be used in the methods here
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String city;
        String choice;
        ArrayList<String> cities = new ArrayList<>();

        //Add to your program the ability to prompt the user for a city name and use it,
        System.out.println("KNOW THE WEATHER");
        System.out.print("Enter 'one' to know the weather of one City or 'two' for more than one city: ");
        choice = sc.nextLine();

        //Verify that you can use your code to request data for different cities
        boolean askCity = true;

        //If user chooses to know the weather about one city
        if (choice.equals("one")) {
            while (askCity) {
                System.out.print("Enter the name of the city('quit' to quit): ");
                city = sc.nextLine();
                if (city.equals("quit")) {
                    askCity = false;
                } else {
                    printCityWeather(city);
                }
            }
            ////If user chooses to know the weather about more than one city
        } else if (choice.equals("two")) {
            System.out.println("Once you write 'quit' the results will be shown");
            while (askCity) {
                System.out.print("Enter the name of one of the cities('quit' to quit): ");
                city = sc.nextLine();
                if (city.equals("quit")){
                    askCity = false;
                } else {
                    cities.add(city);
                }
            }
            printCityComparison(cities);
        }
    }
}
