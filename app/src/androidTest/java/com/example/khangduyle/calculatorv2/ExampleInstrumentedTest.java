package com.example.khangduyle.calculatorv2;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.app.PendingIntent.getActivity;
import static android.content.ContentValues.TAG;


import static android.support.test.InstrumentationRegistry.getArguments;
import static android.support.test.InstrumentationRegistry.getContext;
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
        for (int i=7;i<14;i++){
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
            UiObject result;
            //get results
            if (a[2].equals("Error")){
                result = new UiObject(new UiSelector()
                        .className("android.widget.TextView").instance(5));
            }
            else {
                result = new UiObject(new UiSelector()
                        .className("android.widget.TextView").instance(4));
            }


            //verify result
            try{
                assertEquals(a[2], result.getText());
            } catch (Throwable t){
                collector.addError(t);
            }
        }
        /*mDevice.pressBack();

        UiObject appsTab1 = mDevice.findObject(new UiSelector().text("Calculator"));
        appsTab1.click();
        mDevice.wait(Until.hasObject(By.text("5")), 3000);
        init();
        splitStringAndClick("1234");
        splitStringAndClick("+");
        splitStringAndClick("1234");
        splitStringAndClick("=");*/
        mDevice.click(547,1642);
    }

    private void savePic(View view){
        Bitmap bm = Bitmap.createBitmap(view.getWidth(),
                view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bm);
        view.draw(canvas);
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/req_images");
        myDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-" + n + ".jpg";
        File file = new File(myDir, fname);
        Log.i(TAG, "" + file);
        if (file.exists())
            file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Activity getActivity(Context context) {
        if (context == null) return null;
        if (context instanceof Activity) return (Activity) context;
        if (context instanceof ContextWrapper) return getActivity(((ContextWrapper)context).getBaseContext());
        return null;
    }

    //@Test
    public void unitTestReal() throws UiObjectNotFoundException, InterruptedException {
        mDevice.pressHome();
        //920,1370
        //547,1642
        mDevice.click(920,1370);
        long time=5000;
        sleep(time);
        //mDevice.click(162,1222);

        mDevice.wait(Until.hasObject(By.text("iconsCameras")), 10000);
        UiObject2 camera = mDevice.findObject(By.text("iconsCameras"));
        camera.click();
        mDevice.wait(Until.hasObject(By.text("globe")), 10000);
        UiObject2 globe = mDevice.findObject(By.text("globe"));
        globe.click();
        mDevice.wait(Until.hasObject(By.text("Nguyễn Hữu Thọ - Nguyễn Thị Thập 2")),10000);
        UiObject2 location1 = mDevice.findObject(By.text("Nguyễn Hữu Thọ - Nguyễn Thị Thập 2"));
        location1.click();
        mDevice.wait(Until.hasObject(By.clazz("android.widget.Image")), 10000);
        UiObject2 img = mDevice.findObject(By.clazz("android.widget.Image"));
        img.getVisibleBounds();
        Bitmap result = Bitmap.createBitmap(img.getVisibleBounds().height(), img.getVisibleBounds().width(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(result);

    //        savePic(v);

        /*UiObject allAppsButton = mDevice.findObject(new UiSelector().description("Apps"));
        // Simulate a click to bring up the All Apps screen.
        allAppsButton.clickAndWaitForNewWindow();
        UiObject appsTab = mDevice.findObject(new UiSelector().text("TTGT TpHCM"));
        //Simulate a click to enter the Apps tab.
        appsTab.clickAndWaitForNewWindow();
        mDevice.wait(Until.hasObject(By.desc("iconsCameras")), 10000);
        UiObject2 camera = mDevice.findObject(By.desc("iconsCameras"));
        camera.click();
        mDevice.wait(Until.hasObject(By.desc("globeXung quanh")), 5000);
        UiObject2 globe = mDevice.findObject(By.desc("globeXung quanh"));
        globe.click();*/
        /*init();
        for (int i=0;i<5;i++){
            splitStringAndClick("1234");
            splitStringAndClick("+");
            splitStringAndClick("1234");
            splitStringAndClick("=");
        }*/

        //mDevice.click(418,1531);
        //sleep(100);
        //mDevice.click(418,1531);
       // mDevice.click(418,1531);

        //428,1497
        //408,1530
        //162,1222
        //630,1729
        //645,1745
        //418,1531
        //416,916

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
        for (int i=0;i<7;i++){
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
            UiObject result;
            //ahihi
            if (a[2].equals("Error")){
                result = new UiObject(new UiSelector()
                        .className("android.widget.TextView").instance(5));
            }
            else {
                result = new UiObject(new UiSelector()
                        .className("android.widget.TextView").instance(4));
            }

            //verify result
            try{
                assertEquals(a[2], result.getText());
            } catch (Throwable t){
                collector.addError(t);
            }
        }
    }

    @Test
    public void unitTestMulOperator() throws UiObjectNotFoundException {
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
        for (int i=14;i<21;i++){
            String[] a =questionList.get(i);
            String clear = "CLEAR";
            String num1 = a[0];
            String op = "*";
            String num2 = a[1];
            String equal = "=";
            clickButton(clear);
            splitStringAndClick(num1);
            splitStringAndClick(op);
            splitStringAndClick(num2);
            splitStringAndClick(equal);
            UiObject result;
            //ahihi
            if (a[2].equals("Error")){
                result = new UiObject(new UiSelector()
                        .className("android.widget.TextView").instance(5));
            }
            else {
                result = new UiObject(new UiSelector()
                        .className("android.widget.TextView").instance(4));
            }

            //verify result
            try{
                assertEquals(a[2], result.getText());
            } catch (Throwable t){
                collector.addError(t);
            }
        }
    }

    @Test
    public void unitTestDivisionOperator() throws UiObjectNotFoundException {
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
        for (int i=21;i<28;i++){
            String[] a =questionList.get(i);
            String clear = "CLEAR";
            String num1 = a[0];
            String op = ":";
            String num2 = a[1];
            String equal = "=";
            clickButton(clear);
            splitStringAndClick(num1);
            splitStringAndClick(op);
            splitStringAndClick(num2);
            splitStringAndClick(equal);
            UiObject result;
            //ahihi
            if (a[2].equals("Error")){
                result = new UiObject(new UiSelector()
                        .className("android.widget.TextView").instance(5));
            }
            else {
                result = new UiObject(new UiSelector()
                        .className("android.widget.TextView").instance(4));
            }

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
        PackageManager pm = getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }
}
