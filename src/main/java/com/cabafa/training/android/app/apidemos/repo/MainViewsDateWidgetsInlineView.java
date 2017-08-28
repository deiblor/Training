package com.cabafa.training.android.app.apidemos.repo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainViewsDateWidgetsInlineView {

	AppiumDriver<MobileElement> driver;

	public MainViewsDateWidgetsInlineView(AppiumDriver<MobileElement> driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	@AndroidFindBy(id = "android:id/hours")
	MobileElement hour;

	@AndroidFindBy(id = "android:id/minutes")
	MobileElement minutes;

	@AndroidFindBy(id = "android:id/am_label")
	MobileElement am;

	@AndroidFindBy(id = "android:id/pm_label")
	MobileElement pm;

	@AndroidFindBy(id = "1")
	MobileElement h1;

	@AndroidFindBy(id = "2")
	MobileElement h2;

	@AndroidFindBy(id = "3")
	MobileElement h3;

	@AndroidFindBy(id = "4")
	MobileElement h4;

	@AndroidFindBy(id = "5")
	MobileElement h5;

	@AndroidFindBy(id = "6")
	MobileElement h6;

	@AndroidFindBy(id = "7")
	MobileElement h7;

	@AndroidFindBy(id = "8")
	MobileElement h8;

	@AndroidFindBy(id = "9")
	MobileElement h9;

	@AndroidFindBy(id = "10")
	MobileElement h10;

	@AndroidFindBy(id = "11")
	MobileElement h11;

	@AndroidFindBy(id = "12")
	MobileElement h12;

	@AndroidFindBy(id = "0")
	MobileElement m00;

	@AndroidFindBy(id = "5")
	MobileElement m05;

	@AndroidFindBy(id = "10")
	MobileElement m10;

	@AndroidFindBy(id = "15")
	MobileElement m15;

	@AndroidFindBy(id = "20")
	MobileElement m20;

	@AndroidFindBy(id = "25")
	MobileElement m25;

	@AndroidFindBy(id = "30")
	MobileElement m30;

	@AndroidFindBy(id = "35")
	MobileElement m35;

	@AndroidFindBy(id = "40")
	MobileElement m40;

	@AndroidFindBy(id = "45")
	MobileElement m45;

	@AndroidFindBy(id = "50")
	MobileElement m50;

	@AndroidFindBy(id = "55")
	MobileElement m55;

	public void setHour(String hour, String minute, String ampm) {

		driver.findElement(By.id(hour)).click();
		driver.findElement(By.id(minute)).click();

		if (ampm.equals("am")) {
			am.click();
		} else if (ampm.equals("pm")) {
			pm.click();
		}
	}

	public String getHour() {

		String time = null;

		if (am.getAttribute("checked").equals("true")) {
			time = hour.getText()+":"+minutes.getText()+"am";
		} else if (pm.getAttribute("checked").equals("true")) {
			time = hour.getText()+":"+minutes.getText()+"pm";
		}
		return time;
	}
}
