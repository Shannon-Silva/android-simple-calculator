package com.example.codefestcalculator;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import java.text.DecimalFormat;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity{

    //declare buttons in the caluclator
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,
            btn9, btnAdd, btnSubstract, btnDivide, btnMultiply, btnC, btnEqual,
            btnDecimal, btnBrac1, btnBrac2, btnDel;

    //declare text views used in the calulator
    TextView display;
    TextView result;

    //declare and assign operators used in the calculator application
    String s;
    private static final char ADDITION = '+';
    private static final char SUBSTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '+';
    private char OPERATION;

    float val1, val2;

    //once the application is run this method is being run
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //actionbar formatting to include the title and logo
        String title="CODEFEST CALCULATOR";
        ActionBar ab = getSupportActionBar();
        if (ab != null)
        {
            ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon));
            ab.setIcon(R.drawable.icon);
            ab.setTitle(title);
        }

        //assigning the buttons from the design interface to the
        // button variables in the java activity class
        display = (TextView)findViewById(R.id.edit);
        result = (TextView)findViewById(R.id.result);

        btn0 = (Button)findViewById(R.id.zero);
        btn1 = (Button)findViewById(R.id.one);
        btn2 = (Button)findViewById(R.id.two);
        btn3 = (Button)findViewById(R.id.three);
        btn4 = (Button)findViewById(R.id.four);
        btn5 = (Button)findViewById(R.id.five);
        btn6 = (Button)findViewById(R.id.six);
        btn7 = (Button)findViewById(R.id.seven);
        btn8 = (Button)findViewById(R.id.eight);
        btn9 = (Button)findViewById(R.id.nine);

        btnDel = (Button)findViewById(R.id.del);
        btnC = (Button)findViewById(R.id.clear);
        btnAdd =  (Button)findViewById(R.id.plus);
        btnSubstract = (Button)findViewById(R.id.subs);
        btnDivide = (Button)findViewById(R.id.div);
        btnMultiply = (Button)findViewById(R.id.multi);
        btnDecimal = (Button)findViewById((R.id.deci));
        btnEqual = (Button)findViewById((R.id.equal));
        btnBrac1 = (Button) findViewById(R.id.brac1);
        btnBrac2 = (Button) findViewById(R.id.brac2);

        //define onclick functions for each button

        //clear button resets the values and the displays
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(null);
                result.setText(null);
                val1=0.0f;
                val2=0.0f;
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText((display.getText() + "."));
            }
        });

        btnBrac1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText((display.getText() + "("));
            }
        });

        btnBrac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText((display.getText() + ")"));
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "9");
            }
        });

        //add function
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                OPERATION = ADDITION;
                //result.setText(df.format(val1) + "+");
                result.setText(val1 + "+");
                display.setText(null);
            }
        });

        //substract function
        btnSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                OPERATION = SUBSTRACTION;
                result.setText(val1 + "-");
                display.setText(null);
            }
        });

        //multipy function
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                OPERATION = MULTIPLICATION;
                result.setText(val1 + "x");
                display.setText(null);
            }
        });

        //divide function
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                OPERATION = DIVISION;
                result.setText(val1 + "/");
                display.setText(null);
            }
        });

        //equal function
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                display.setText(result.getText().toString()+ Float.toString(val2));
                result.setText("" + val1);
                val1 = 0.0f;
                //val2 = 0.0f;
                OPERATION = '0';
            }
        });
    }

    //calculate function which contains the calculator logic
    private void calculate(){
        if(!Float.isNaN(val1)){
            val2=Float.parseFloat(display.getText().toString());
            display.setText(null);

            if(OPERATION == ADDITION){
                val1 = this.val1 + val2;
            } else if(OPERATION == SUBSTRACTION){
                val1 = this.val1 - val2;
            } else if(OPERATION == MULTIPLICATION){
                val1 = this.val1 * val2;
            } else if(OPERATION == DIVISION){
                val1 = this.val1 / val2;
            } else {
                try {
                    val1 = Float.parseFloat(display.getText().toString());
                } catch (Exception exception){}
            }
        }
    }
}
