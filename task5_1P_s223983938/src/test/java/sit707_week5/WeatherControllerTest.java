package sit707_week5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static double[] localTemperatures;
    private static int nHours;

    @BeforeClass
    public static void setUpClass() {
        // Arrange: Initialize the controller once for all tests to ensure 'Fast' property
        wController = WeatherController.getInstance();
        nHours = wController.getTotalHours();
        localTemperatures = new double[nHours];
        
        // Cache values locally to avoid repeated slow 'getTemperatureForHour' calls
        for (int i = 0; i < nHours; i++) {
            localTemperatures[i] = wController.getTemperatureForHour(i + 1);
        }
    }

    @AfterClass
    public static void tearDownClass() {
        // Cleanup: Close the controller only after all tests are finished
        if (wController != null) {
            wController.close();
        }
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "223983938"; 
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
 
        String studentName = "Teddy"; 
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");
        
       
        double expectedMin = 1000;
        for (double temp : localTemperatures) {
            if (expectedMin > temp) {
                expectedMin = temp;
            }
        }
       
        double actualMin = wController.getTemperatureMinFromCache();
           
        Assert.assertEquals(expectedMin, actualMin, 0.01);
    }
    
    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");
        
   
        double expectedMax = -1;
        for (double temp : localTemperatures) {
            if (expectedMax < temp) {
                expectedMax = temp;
            }
        }
      
        double actualMax = wController.getTemperatureMaxFromCache();
        
        Assert.assertEquals(expectedMax, actualMax, 0.01);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");
        
        double sumTemp = 0;
        for (double temp : localTemperatures) {
            sumTemp += temp;
        }
        double expectedAvg = sumTemp / nHours;
   
        double actualAvg = wController.getTemperatureAverageFromCache();
       
        Assert.assertEquals(expectedAvg, actualAvg, 0.01);
    }
    
    @Test
    public void testTemperaturePersist() {
        // Left commented out as per Pass Task requirements [cite: 136]
        /*
        System.out.println("+++ testTemperaturePersist +++");
        wController = WeatherController.getInstance();
        ...
        */
    }
}