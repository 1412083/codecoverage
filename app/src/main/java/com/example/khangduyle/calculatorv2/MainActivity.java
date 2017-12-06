package com.example.khangduyle.calculatorv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnAdd;
    Button btnSub;
    Button btnMul;
    Button btnDiv;
    Button btnClear;
    Button btn0;
    Button btnEqual;
    Button btnSlash;
    TextView textViewNum2;
    TextView textViewNum1;
    TextView textViewResult;
    TextView textViewOp;
    TextView textViewNotification;
    String result;
    String operator;
    String tmp;
    PhanSo num1;
    PhanSo num2;
    PhanSo res;
    TinhPhanSo tinhPhanSo;
    int round;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initControlListener();
    }

    private void initControlListener() {
        btn0.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        onNumberButtonClick("0");
                                    }
                                }
        );

        btn1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        onNumberButtonClick("1");
                                    }
                                }
        );
        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        onNumberButtonClick("2");
                                    }
                                }
        );
        btn3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        onNumberButtonClick("3");
                                    }
                                }
        );

        btn4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        onNumberButtonClick("4");
                                    }
                                }
        );

        btn5.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        onNumberButtonClick("5");
                                    }
                                }
        );

        btn6.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        onNumberButtonClick("6");
                                    }
                                }
        );

        btn7.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        onNumberButtonClick("7");
                                    }
                                }
        );

        btn8.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        onNumberButtonClick("8");
                                    }
                                }
        );

        btn9.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        onNumberButtonClick("9");
                                    }
                                }
        );
        btnSlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClick("/");
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        clearAll();
                                    }
                                }
            );

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddButtonClick("+");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddButtonClick("-");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddButtonClick("x");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddButtonClick(":");
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onEqualButtonClick("+");
            }
        });
    }

    private void onEqualButtonClick(String s) {
        if (checkError()){
            return;
        }
        result=textViewResult.getText().toString();
        textViewNum2.setText(result);
        String finalResult ="";

        if (tmp=="") {
            if (res.setPhanSo(result)){
                finalResult = res.getString();
            } else {
                textViewNotification.setText("Error");
            }
        }
        else{
            if (num1.setPhanSo(tmp) && num2.setPhanSo(result)){
                if (operator=="+") res=tinhPhanSo.Cong(num1,num2);
                if (operator=="-") res=tinhPhanSo.Tru(num1,num2);
                if (operator=="x") res=tinhPhanSo.Nhan(num1,num2);
                if (operator==":") res=tinhPhanSo.Chia(num1,num2);
                if (res.checkPhanSo()){
                    finalResult = res.getString();
                } else {
                    textViewNotification.setText("Error");
                }
            } else {
                textViewNotification.setText("Error");
            }
        }
        tmp="";
        result="";
        textViewResult.setText(finalResult);
    }

    private void onAddButtonClick(String oper) {
        if (checkError()){
            return;
        }
        tmp=textViewResult.getText().toString();
        if (tmp==""){

        } else {
            textViewNum1.setText(tmp);
            textViewOp.setText(oper);
            onClearButtonClick();
            operator=oper;
        }

    }

    private void onClearButtonClick() {
        textViewResult.setText("");
        textViewNum2.setText("");
    }

    private void clearAll(){
        textViewResult.setText("");
        textViewNum2.setText("");
        textViewOp.setText("");
        textViewNum1.setText("");
        textViewNotification.setText("");
    }

    private boolean checkError(){
        String error = textViewNotification.getText().toString();
        if (error =="Error"){
            return true;
        }
        return false;
    }

    private void onNumberButtonClick(String s) {
        if (checkError()){
            return;
        }
        result=textViewResult.getText().toString();
        result=result+ s;
        textViewResult.setText(result);
    }

    private void initControls() {
        tmp="";
        btn1= (Button)findViewById(R.id.button_1);
        btn2= (Button)findViewById(R.id.button_2);
        btn3= (Button)findViewById(R.id.button_3);
        btn4= (Button)findViewById(R.id.button_4);
        btn5= (Button)findViewById(R.id.button_5);
        btn6= (Button)findViewById(R.id.button_6);
        btn7= (Button)findViewById(R.id.button_7);
        btn8= (Button)findViewById(R.id.button_8);
        btn9= (Button)findViewById(R.id.button_9);
        btn0= (Button)findViewById(R.id.button_0);
        btnAdd= (Button)findViewById(R.id.button_add);
        btnSub= (Button)findViewById(R.id.button_sub);
        btnMul= (Button)findViewById(R.id.button_mul);
        btnDiv= (Button)findViewById(R.id.button_div);
        btnClear= (Button)findViewById(R.id.button_clear);
        btnEqual= (Button)findViewById(R.id.button_equal);
        btnSlash= (Button)findViewById(R.id.button_slash);
        textViewResult= (TextView)findViewById(R.id.text_view_result);
        textViewNum1 = (TextView)findViewById(R.id.text_view_num1);
        textViewNum2 = (TextView)findViewById(R.id.text_view_num2);
        textViewOp = (TextView)findViewById(R.id.text_view_op);
        textViewNotification = (TextView)findViewById(R.id.text_view_notification);
        textViewNotification.setText("");
        num1= new PhanSo(0,1);
        num2= new PhanSo(0,1);
        round =0;
        tinhPhanSo = new TinhPhanSo();
    }
}
