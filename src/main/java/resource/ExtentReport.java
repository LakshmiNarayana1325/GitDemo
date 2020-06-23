package resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	static ExtentReports extent;
	public static ExtentReports getextentreporterobject()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		//extentSparkreporter, extentReport
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomatiom");
		reporter.config().setDocumentTitle("googleTest");
		extent=new ExtentReports();
		extent.attachReporter(reporter);//to get the information about extentsparkreporter object attach it to the extent object
		extent.setSystemInfo("Tester", "Lakshmi");
		return extent;
	}

}
