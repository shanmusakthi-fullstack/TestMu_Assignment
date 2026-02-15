package com.lambdatest;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;

public class TestNGTodo1 {

	public static void main(String[] args) {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("dev");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "Your LambdaTest Username");
		ltOptions.put("accessKey", "Your LambdaTest Access Key");
		ltOptions.put("project", "Untitled");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-testNG");
		browserOptions.setCapability("LT:Options", ltOptions);

	}

}
