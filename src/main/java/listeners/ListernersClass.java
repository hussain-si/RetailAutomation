package listeners;

import annotations.TestAnnotation;
import enums.TestCategory;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


/**
 * @author rahul.radhakrishnan
 *
 */
public class ListernersClass implements ITestListener, ISuiteListener
{

	@Override
	public void onStart(ISuite suite)
	{
		// Initialize Allure report before suite starts
		try {
			// No need for specific initialization code in Allure
			// It automatically handles the report generation and output directory
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite)
	{
		// No need for explicit flush for Allure, it's done automatically
	}

	@Override
	public void onTestStart(ITestResult result)
	{
		// Create test in Allure
		String methodName = result.getMethod().getMethodName();
		String description = result.getMethod().getDescription();
		Allure.description(description);
		Allure.link("Test Method", methodName);
		try {
			// Add custom information from annotations
			String[] authors = result.getMethod().getConstructorOrMethod().getMethod()
					.getAnnotation(TestAnnotation.class).author();
			for (String author : authors) {
				Allure.parameter("Author", author);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		// Log success status in Allure
		Allure.step(result.getMethod().getMethodName() + " is passed !", Status.PASSED);
		//logStep("Test Passed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		// Log failure status in Allure
		Allure.step(result.getMethod().getMethodName() + " is failed !", Status.FAILED);
		// Optionally, capture screenshot or other data if required
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		// Log skipped status in Allure
		Allure.step(result.getMethod().getMethodName() + " is Skipped!", Status.SKIPPED);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		// You can log partial success or other custom actions
	}

	@Override
	public void onStart(ITestContext context)
	{
		// Initialize context-level data if necessary
	}

	@Override
	public void onFinish(ITestContext context)
	{
		// Handle any final actions after the test context completes
	}
}
