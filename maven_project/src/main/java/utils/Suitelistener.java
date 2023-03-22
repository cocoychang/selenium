package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.baseTest;

public class Suitelistener implements ITestListener, IAnnotationTransformer {
	public void onTestSuccess(ITestResult result) {
	    String filename = System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+result.getMethod().getMethodName();
	    File f1le = ((TakesScreenshot)baseTest.driver).getScreenshotAs(OutputType.FILE);
	    
	    try {
			FileUtils.copyFile(f1le, new File(filename+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	  }

}
