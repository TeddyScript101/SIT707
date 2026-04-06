package sit707_week5;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Main entry of application.
 */
public class Main 
{
    public static void main( String[] args )
    {
        WeatherController wController = WeatherController.getInstance();
        
        System.out.println("Temperature min: " + wController.getTemperatureMinFromCache());
        System.out.println("Temperature max: " + wController.getTemperatureMaxFromCache());
        System.out.println("Temperature avg: " + wController.getTemperatureAverageFromCache());
        System.out.println("Temperature at first hour: " + wController.getTemperatureForHour(1));
        
        // --- Fixed Clock Implementation ---
        // Capture the time once so both 'persistTime' and 'now' refer to the exact same moment.
        Date currentTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("H:m:s");
        String now = sdf.format(currentTime);

        // Pass the captured currentTime to the controller
        String persistTime = wController.persistTemperature(10, 23.2, currentTime);
        
        System.out.println("Persist time: " + persistTime + ", now: " + now);
        
        // Verification logic (similar to your unit test)
        if (persistTime.equals(now)) {
            System.out.println("Success: Persist time matches current time.");
        } else {
            System.out.println("Failure: Time mismatch detected.");
        }
        
        wController.close();
    }
}