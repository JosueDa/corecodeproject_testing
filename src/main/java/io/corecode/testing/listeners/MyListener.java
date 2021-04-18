package io.corecode.testing.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ISuiteListener, ITestListener {
    @Override
    public void onStart(ISuite suite) {
        System.out.println("Testing api for corecode qa project");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("All test have been executed");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test "+result.getName()+" completed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test "+result.getName()+" failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test "+result.getName()+" was skipped");
    }
}