package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.ExtentReport;
import resource.base;

public class Listeners extends base implements ITestListener{
	
	ExtentReports extent=ExtentReport.getextentreporterobject();
	ExtentTest test;
	ThreadLocal<ExtentTest> newextent=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result1) {
		// TODO Auto-generated method stub
		test=extent.createTest(result1.getMethod().getMethodName()); 
		newextent.set(test);
	}

	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
				extent.flush(); //to stop taking test report
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		newextent.get().fail(result.getThrowable());
		WebDriver driver=null;
		String testcasename=result.getMethod().getMethodName();
		System.out.println(testcasename);
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{
			
		}
		//screenshot
		try {
			newextent.get().addScreenCaptureFromPath(screenshot(testcasename,driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		newextent.get().log(Status.PASS, "Test got passed");
	}

}
