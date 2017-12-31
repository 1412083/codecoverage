package com.example.khangduyle.calculatorv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtAx;
    EditText edtAy;
    EditText edtBx;
    EditText edtBy;
    EditText edtCx;
    EditText edtCy;
    Button btnChuvi;
    Button btnLoai;
    TextView tvChuvi;
    TextView tvLoai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnChuvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TamGiac tg = initTamGiac();
                tvChuvi.setText(Double.toString(tg.ChuVi()));
            }
        });

        btnLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TamGiac tg = initTamGiac();
                tvLoai.setText(tg.LoaiTamGiac());
            }
        });
    }

    private TamGiac initTamGiac(){
        TamGiac tria = new TamGiac();
        Diem A = new Diem();
        Diem B = new Diem();
        Diem C = new Diem();
        int Ax = Integer.parseInt(edtAx.getText().toString());
        int Ay = Integer.parseInt(edtAy.getText().toString());
        int Bx = Integer.parseInt(edtBx.getText().toString());
        int By = Integer.parseInt(edtBy.getText().toString());
        int Cx = Integer.parseInt(edtCx.getText().toString());
        int Cy = Integer.parseInt(edtCy.getText().toString());
        A.setX(Ax);
        A.setY(Ay);
        B.setX(Bx);
        B.setY(By);
        C.setX(Cx);
        C.setY(Cy);
        tria.setA(A);
        tria.setB(B);
        tria.setC(C);
        return tria;
    }

    public void init(){
        edtAx = (EditText) findViewById(R.id.Ax);
        edtAy = (EditText) findViewById(R.id.Ay);
        edtBx = (EditText) findViewById(R.id.Bx);
        edtBy = (EditText) findViewById(R.id.By);
        edtCx = (EditText) findViewById(R.id.Cx);
        edtCy = (EditText) findViewById(R.id.Cy);
        btnChuvi = (Button) findViewById(R.id.chuvi);
        btnLoai = (Button) findViewById(R.id.type);
        tvChuvi = (TextView) findViewById(R.id.text_view_chuvi);
        tvLoai = (TextView) findViewById(R.id.text_view_loai);
    }


}
