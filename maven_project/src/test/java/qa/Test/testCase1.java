package qa.Test;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.baseTest;
import utils.ElementFetch;
import pageEvents.HomePageEvents;




public class testCase1 extends baseTest {
	ElementFetch element = new ElementFetch();
	HomePageEvents homepage = new HomePageEvents();
	
  @Test(priority = 0)
  public void sample() {
	  homepage.clickTheBigPageWithManyElements();
	  
	 Assert.assertTrue(homepage.clickElementButton(),"test assert");
	 logger.log(Status.INFO, "Click the Element button");
	 Assert.assertTrue(homepage.typeTextBoxElement(),"test failed");
	 logger.log(Status.INFO, "Enter data on the textfield");
	 
  }
  @Test(priority = 1)
  public void sample2() {
	  
	  Assert.assertTrue(homepage.typeTextBoxEmailElement(),"test failed");
	  logger.log(Status.INFO, "Enter email on the textfield");
	  
	  
	  
  }
}
