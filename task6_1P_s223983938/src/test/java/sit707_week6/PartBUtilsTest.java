package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class PartBUtilsTest {
	
	@Test
	public void testConstructor() {
	    // Covers the default constructor for PartBUtils
	    new PartBUtils();
	}

	@Test
	public void testSimpleLoopZero() {
	    // Explicitly ensures the loop condition is tested when immediately false
	    Assert.assertEquals(0, PartBUtils.simpleLoopSum(0));
	}

    @Test
    public void testSimpleLoopSum() {
   
        Assert.assertEquals(15, PartBUtils.simpleLoopSum(5)); 
        
        Assert.assertEquals(0, PartBUtils.simpleLoopSum(0));
    }

    @Test
    public void testLoopWithConditional() {

        Assert.assertEquals(2, PartBUtils.loopWithConditional(4)); 
 
        Assert.assertEquals(0, PartBUtils.loopWithConditional(1)); 

        Assert.assertEquals(0, PartBUtils.loopWithConditional(-1));
    }
}