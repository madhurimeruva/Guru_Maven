package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	// When Test case get started, this method is called.
	public void onTestStart(ITestResult result) {

		System.out.println(result.getName() + " test case started");

	}
	// When Test case get passed, this method is called.
	public void onTestSuccess(ITestResult result) {

		System.out.println("The name of the test case passed is :" + result.getName());

	}
	// When Test case get failed, this method is called.
	public void onTestFailure(ITestResult result) {

		System.out.println("The name of the test case failed  is :" + result.getName());

	}
	// When Test case get skipped, this method is called.
	public void onTestSkipped(ITestResult result) {

		System.out.println("The name of the test case skipped is " + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
