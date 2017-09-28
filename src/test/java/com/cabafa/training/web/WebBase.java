package com.cabafa.training.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class WebBase {
	
	WebDriver driver;
	
	public void launchBrowser(String browser) {
		
		if (browser.equals("firefox")) {
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
		}
		if (browser.equals("chrome")) {
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
		}
		if(browser.equals("iexplorer")) {
			InternetExplorerDriverManager.getInstance().setup();
			driver = new InternetExplorerDriver();
		}
		if (browser.equals("edge")) {
			EdgeDriverManager.getInstance().setup();
			driver = new EdgeDriver();
		}	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

}
