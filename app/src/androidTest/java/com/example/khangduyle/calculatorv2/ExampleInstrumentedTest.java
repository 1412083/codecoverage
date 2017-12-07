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

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    List<String[]> questionList;
    ArrayList<UiObject2> button;
    readCSV csv;
    private UiDevice mDevice;
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setUp() {
        // Initialize UiDevice instance
        String fname = "file.csv";

        csv = new readCSV();
        questionList = csv.readCsv(fname);

        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        // Start from the home screen
        //mDevice.pressHome();

        mDevice.wait(Until.hasObject(By.pkg(getLauncherPackageName()).depth(0)), 1000);

    }

    private void init() {
        if (button!=null) {
            button.clear();
        }
        button =new ArrayList<>();
        for (int i=0;i<10;i++){
            button.add(mDevice.findObject(By.text(Integer.toString(i))));
        }

        button.add(mDevice.findObject(By.text("+"))); //10
        button.add(mDevice.findObject(By.text("-")));  //11
        button.add(mDevice.findObject(By.text("*")));   //12
        button.add(mDevice.findObject(By.text(":")));   //13
        button.add(mDevice.findObject(By.text("/")));   //14
        button.add(mDevice.findObject(By.text("CLEAR")));  //15
        button.add(mDevice.findObject(By.text("=")));  //16

    }

    private void clickButton(String str){
        if (str.equals("+")){
            button.get(10).click();
        } else   if (str.equals("-")){
            button.get(11).click();
        }else   if (str.equals("*")){
            button.get(12).click();
        }else   if (str.equals(":")){
            button.get(13).click();
        }else   if (str.equals("/")){
            button.get(14).click();
        } else   if (str.equals("CLEAR")){
            button.get(15).click();
        }else   if (str.equals("=")){
            button.get(16).click();
        } else {
            char s = str.charAt(0);
            int num = s- 48;
            if (num>=0 && num<=9){
                button.get(num).click();
            }
        }

    }

    private void splitStringAndClick(String s){
        int i=0;
        int n= s.length();
        String str = "";
        while (i<n){
            str = Character.toString(s.charAt(i));
            clickButton(str);
            i++;
        }
    }

    @Test
    public void unitTestSubOperator() throws UiObjectNotFoundException {
        // Simulate a short press on the HOME button.
        mDevice.pressHome();
        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps"));
        // Simulate a click to bring up the All Apps screen.
        allAppsButton.clickAndWaitForNewWindow();
        UiObject appsTab = mDevice.findObject(new UiSelector().text("CalculatorV2"));
        //Simulate a click to enter the Apps tab.
        appsTab.click();
        mDevice.wait(Until.hasObject(By.text("5")), 3000);
        init();
        for (int i=0;i<questionList.size();i++){
            String[] a =questionList.get(i);
            String clear = "CLEAR";
            String num1 = a[0];
            String op = "-";
            String num2 = a[1];
            String equal = "=";
            clickButton(clear);
            splitStringAndClick(num1);
            splitStringAndClick(op);
            splitStringAndClick(num2);
            splitStringAndClick(equal);

            //get results
            UiObject result = new UiObject(new UiSelector()
                    .className("android.widget.TextView").instance(4));

            //verify result
            try{
                assertEquals(a[2], result.getText());
            } catch (Throwable t){
                collector.addError(t);
            }
        }
    }

    @Test
    public void unitTestPlusOperator() throws UiObjectNotFoundException {
        // Simulate a short press on the HOME button.
        mDevice.pressHome();
        UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps"));
        // Simulate a click to bring up the All Apps screen.
        allAppsButton.clickAndWaitForNewWindow();
        UiObject appsTab = mDevice.findObject(new UiSelector().text("CalculatorV2"));
        //Simulate a click to enter the Apps tab.
        appsTab.click();
        mDevice.wait(Until.hasObject(By.text("5")), 3000);
        init();
        for (int i=0;i<questionList.size();i++){
            String[] a =questionList.get(i);
            String clear = "CLEAR";
            String num1 = a[0];
            String op = "+";
            String num2 = a[1];
            String equal = "=";
            clickButton(clear);
            splitStringAndClick(num1);
            splitStringAndClick(op);
            splitStringAndClick(num2);
            splitStringAndClick(equal);

            //get results
            UiObject result = new UiObject(new UiSelector()
                    .className("android.widget.TextView").instance(4));

            //verify result
            try{
                assertEquals(a[2], result.getText());
            } catch (Throwable t){
                collector.addError(t);
            }
        }
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
