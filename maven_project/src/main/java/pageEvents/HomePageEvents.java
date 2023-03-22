package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.baseTest;
import pageObjects.HomePageElements;
import utils.ElementFetch;
//import utils.highLight;

public class HomePageEvents extends baseTest {
	
	ElementFetch element = new ElementFetch();
	
	public void clickTheBigPageWithManyElements() {

		element.getWebElement("XPATH", HomePageElements.elementsTab).click();
	}
	
	public boolean clickElementButton() {
		try {
		
		WebElement btn = driver.findElement(By.xpath("//a[@class='et_pb_button et_pb_button_0 et_pb_bg_layout_light']"));
		//highLight.highlightElement(driver, btn);
		btn.click();
		return true;
	}catch(Exception e){
		System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean typeTextBoxElement() {
		try {
		
		WebElement textBox = driver.findElement(By.xpath("//*[@id='et_pb_contact_name_0']"));
		//highLight.highlightElement(driver, btn);
		textBox.sendKeys("kulangot sa noo");
		return true;
	}catch(Exception e){
		System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean typeTextBoxEmailElement() {
		try {
		
		WebElement textBox = driver.findElement(By.xpath("//*[@id='et_pb_contact_email_0']"));
		//highLight.highlightElement(driver, btn);
		textBox.sendKeys("testEmail@sample.com");
		return true;
	}catch(Exception e){
		System.out.println(e.getMessage());
		}
		return false;
	}	
	

}
