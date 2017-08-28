package com.cabafa.training.android.app.apidemos.repo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainView {

	AppiumDriver<MobileElement> driver;

	public MainView(AppiumDriver<MobileElement> driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

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

	public MobileElement Accessibility() {
		return Accessibility;
	}

	public MobileElement Animation() {
		return Animation;
	}

	public MobileElement App() {
		return App;
	}

	public MobileElement Content() {
		return Content;
	}

	public MobileElement Graphics() {
		return Graphics;
	}

	public MobileElement Media() {
		return Media;
	}

	public MobileElement NFC() {
		return NFC;
	}

	public MobileElement OS() {
		return OS;
	}

	public MobileElement Preference() {
		return Preference;
	}

	public MobileElement Text() {
		return Text;
	}

	public MobileElement Views() {
		return Views;
	}
}
