package com.example.khangduyle.calculatorv2;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private UiDevice mDevice;

    @Before
    public void setUp() {
        // Initialize UiDevice instance

        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        // Start from the home screen
        mDevice.pressHome();

        mDevice.wait(Until.hasObject(By.pkg(getLauncherPackageName()).depth(0)), 1000);
    }

    @Test
    public void checkSettings() throws UiObjectNotFoundException {
        // Simulate a short press on the HOME button.
        mDevice.pressHome();

        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps"));

        // Simulate a click to bring up the All Apps screen.
        allAppsButton.clickAndWaitForNewWindow();
        UiObject appsTab = mDevice.findObject(new UiSelector().text("CalculatorV2"));

        // Simulate a click to enter the Apps tab.
        appsTab.click();

        mDevice.wait(Until.hasObject(By.text("5")), 3000);
        //create objects, which we will for emulating user behaviour
        UiObject2 two = mDevice.findObject(By.text("2"));
        UiObject2 three = mDevice.findObject(By.text("3"));
        UiObject2 plus = mDevice.findObject(By.text("+"));
        UiObject2 equal = mDevice.findObject(By.text("="));

        //sequence of emulating actions
        two.click();
        plus.click();
        three.click();
        equal.click();

        //get results
        UiObject result = new UiObject(new UiSelector()
                .className("android.widget.TextView").instance(1));
        //verify result
        assertEquals("5", result.getText());

    }

    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }
}
