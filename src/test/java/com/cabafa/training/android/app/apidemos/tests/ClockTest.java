package com.cabafa.training.android.app.apidemos.tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cabafa.training.android.app.apidemos.repo.MainView;
import com.cabafa.training.android.app.apidemos.repo.MainViewsDateWidgetsInlineView;
import com.cabafa.training.android.app.apidemos.repo.MainViewsDateWidgetsView;
import com.cabafa.training.android.app.apidemos.repo.MainViewsView;

public class ClockTest extends AndroidBase{
	
	@BeforeClass
	public void launchApp() throws MalformedURLException {
		startApp("io.appium.android.apis", "io.appium.android.apis.ApiDemos");
	}
	
	@Test
	public void navigateViews() {
		MainView main = new MainView(driver);
		main.Views().click();
	}

	@Test(dependsOnMethods= {"navigateViews"})
	public void navigateDateWidgets() {
		MainViewsView views = new MainViewsView(driver);
		views.DateWidgets().click();
	}

	@Test(dependsOnMethods= {"navigateDateWidgets"})
	public void navigateInLine() {
		MainViewsDateWidgetsView dateWidgets = new MainViewsDateWidgetsView(driver);
		dateWidgets.Inline().click();
	}

	@Test(dependsOnMethods= {"navigateInLine"})
	public void setHour() {
		
		String hour = "4";
		String min = "25";
		String ampm = "am";
		
		MainViewsDateWidgetsInlineView inline = new MainViewsDateWidgetsInlineView(driver);
		inline.setHour(hour, min, ampm);
		assertEquals(inline.getHour(), hour+":"+min+ampm);
	}
}
