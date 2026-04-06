package sit707_week5;

import org.junit.Assert;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherControllerTest {

    @Test
    public void testStudentIdentity() {        
        String studentId = "S223983938"; 
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {      
        String studentName = "Teddy Yee"; 
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperaturePersist() {
        System.out.println("+++ testTemperaturePersist +++");
        
        WeatherController wController = WeatherController.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("H:m:s");
        Date fixedTime = new Date(); 
        String expectedTime = sdf.format(fixedTime);
        

        String persistTime = wController.persistTemperature(10, 19.5, fixedTime);
        
        System.out.println("Expected: " + expectedTime + ", Actual: " + persistTime);

        Assert.assertEquals("The persisted time must match the provided fixed time", expectedTime, persistTime);
        
        wController.close();
    }
}