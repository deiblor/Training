package com.cabafa.training.android.app.apidemos.repo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainViewsDateWidgetsView {
	
	AppiumDriver<MobileElement> driver;

	public MainViewsDateWidgetsView(AppiumDriver<MobileElement> driver) {
		
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);	}

	@AndroidFindBy(id = "2. Inline")
	MobileElement Inline;

	public MobileElement Inline() {
		return Inline;
	}

}
