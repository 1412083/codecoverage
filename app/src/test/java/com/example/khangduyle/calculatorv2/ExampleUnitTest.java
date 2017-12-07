package com.example.khangduyle.calculatorv2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    List<String[]> questionList;
    TinhPhanSo tinhPS;
    readCSV csv;
    PhanSo num1;
    PhanSo num2;
    PhanSo res;
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void init(){
        String fname = "file.csv";

        csv = new readCSV();
        questionList = csv.readCsv(fname);
        tinhPS= new TinhPhanSo();
        num1= new PhanSo(0,1);
        num2= new PhanSo(0,1);
    }
    @Test
    public void addition_isCorrect() throws Exception {

        for (int i=0;i<questionList.size();i++){
            String[] a =questionList.get(i);
            if (num1.setPhanSo(a[0]) && num2.setPhanSo(a[1])){
                res=tinhPS.Cong(num1,num2);
            }
            try{
                assertEquals(a[2], res.getString());
            } catch (Throwable t){
                collector.addError(t);
            }
        }
    }

    @Test
    public void subtraction_isCorrect() throws Exception {

        for (int i=0;i<questionList.size();i++){
            String[] a =questionList.get(i);
            if (num1.setPhanSo(a[0]) && num2.setPhanSo(a[1])){
                res=tinhPS.Tru(num1,num2);
            }
            try{
                assertEquals(a[2], res.getString());
            } catch (Throwable t){
                collector.addError(t);
            }
        }
    }

    @Test
    public void Multi_isCorrect() throws Exception {

        for (int i=0;i<questionList.size();i++){
            String[] a =questionList.get(i);
            if (num1.setPhanSo(a[0]) && num2.setPhanSo(a[1])){
                res=tinhPS.Nhan(num1,num2);
            }
            try{
                assertEquals(a[2], res.getString());
            } catch (Throwable t){
                collector.addError(t);
            }
        }
    }

    @Test
    public void Devision_isCorrect() throws Exception {

        for (int i=0;i<questionList.size();i++){
            String[] a =questionList.get(i);
            if (num1.setPhanSo(a[0]) && num2.setPhanSo(a[1])){
                res=tinhPS.Chia(num1,num2);
            }
            try{
                assertEquals(a[2], res.getString());
            } catch (Throwable t){
                collector.addError(t);
            }
        }
    }


}