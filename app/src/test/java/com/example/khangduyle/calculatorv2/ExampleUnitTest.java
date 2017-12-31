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
    readCSV csv;
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void init(){
        String fname = "file.csv";
        csv = new readCSV();
        questionList = csv.readCsv(fname);
    }

    @Test
    public void chuci_isCorrect() throws Exception {
        for (int i=0;i<11;i++){
            String[] a =questionList.get(i);
            TamGiac tg = initTamGiac(a[0],a[1],a[2],a[3],a[4],a[5]);
            try{
                assertEquals(Double.parseDouble(a[6]), tg.ChuVi(),0.0001);
            } catch (Throwable t){
                collector.addError(t);
            }
        }
    }

    private TamGiac initTamGiac(String ax, String ay, String bx, String by, String cx, String cy) {
        TamGiac tria = new TamGiac();
        Diem A = new Diem();
        Diem B = new Diem();
        Diem C = new Diem();
        double Ax = Double.parseDouble(ax);
        double Ay = Double.parseDouble(ay);
        double Bx = Double.parseDouble(bx);
        double By = Double.parseDouble(by);
        double Cx = Double.parseDouble(cx);
        double Cy = Double.parseDouble(cy);
        A.setX(Ax);
        A.setY(Ay);
        B.setX(Bx);
        B.setY(By);
        C.setX(Cx);
        C.setY(Cy);
        tria.setA(A);
        tria.setB(B);
        tria.setC(C);
        TamGiac tg = new TamGiac(A,B,C);
        tg.getA();
        tg.getB();
        tg.getC();
        A.getX();
        A.getY();
        A.ToString();
        Diem ty = new Diem("4,5");
        return tria;
    }

    @Test
    public void loaitamgiac_isCorrect() throws Exception {
        for (int i=11;i<24;i++){
            String[] a =questionList.get(i);
            TamGiac tg = initTamGiac(a[0],a[1],a[2],a[3],a[4],a[5]);
            try{
                assertEquals(a[6], tg.LoaiTamGiac());
            } catch (Throwable t){
                collector.addError(t);
            }
        }

    }


}