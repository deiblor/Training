package com.cabafa.training.android.app.apidemos.repo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public interface MainRep {
	
	PageObject po = new PageObject();
	PageFactory.initElements(new AppiumFieldDecorator(driver),po)

	@AndroidFindBy(id = "Accessibility")
	MobileElement Accessibility;

	@AndroidFindBy(id = "Animation")
	MobileElement Animation;

	@AndroidFindBy(id = "App")
	MobileElement App;

	@AndroidFindBy(id = "Content")
	MobileElement Content;

	@AndroidFindBy(id = "Graphics")
	MobileElement Graphics;

	@AndroidFindBy(id = "Media")
	MobileElement Media;

	@AndroidFindBy(id = "NFC")
	MobileElement NFC;

	@AndroidFindBy(id = "OS")
	MobileElement OS;

	@AndroidFindBy(id = "Preference")
	MobileElement Preference;

	@AndroidFindBy(id = "Text")
	MobileElement Text;

	@AndroidFindBy(id = "Views")
	MobileElement Views;

}
