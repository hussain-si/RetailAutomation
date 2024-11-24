package listeners;

import annotations.TestAnnotation;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import org.testng.*;

public class ListernersClass implements ITestListener, ISuiteListener {

	@Step("{0}")
	public void logStep(String message) {
		System.out.println(message); // Optional: Log to console
	}

	@Override
	public void onStart(ISuite suite) {
		logStep("Test Suite Started: " + suite.getName());
	}

	@Override
	public void onFinish(ISuite suite) {
		logStep("Test Suite Finished: " + suite.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		logStep("Starting test: " + result.getMethod().getMethodName());
		String description = result.getMethod().getDescription();
		Allure.description(description);
		try {
			String[] authors = result.getMethod().getConstructorOrMethod().getMethod()
					.getAnnotation(TestAnnotation.class).author();
			for (String author : authors) {
				logStep("Author: " + author);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logStep("Test Passed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logStep("Test Failed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logStep("Test Skipped: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logStep("Test Partially Passed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {
		logStep("Test Context Started: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		logStep("Test Context Finished: " + context.getName());
	}
}
