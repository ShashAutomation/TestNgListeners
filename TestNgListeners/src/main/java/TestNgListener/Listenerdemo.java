package TestNgListener;


import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listenerdemo implements ITestListener  {
	public void onTestStart(ITestResult result) {  
		System.out.println("Testcases started and its details are : "+result.getName());
		}  
		  
	 
		public void onTestSuccess(ITestResult result) {  
		
		System.out.println("Success of test cases and its details are : "+result.getName());  
		}  
	 
		public void onTestFailure(ITestResult result) {  
		
		System.out.println("Failure of test cases and its details are : "+result.getName());  
		}  
		  
	 
		public void onTestSkipped(ITestResult result) {  

		System.out.println("Skip of test cases and its details are : "+result.getName());  
		}  
		  
	  
}
