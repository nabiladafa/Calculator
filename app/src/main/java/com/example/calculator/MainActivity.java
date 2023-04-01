package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import org.mozilla.javascript.Scriptable;



public class MainActivity extends AppCompatActivity {

    ImageView btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0;
    ImageView btn_dot,btn_equal,btn_ac,btn_percen,btn_plus,btn_min,btn_x;

    TextView InputTxt,outPuttxt;

    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outPuttxt=findViewById(R.id.outPuttxt);
        InputTxt=findViewById(R.id.InputTxt);

        btn_0=findViewById(R.id.btn_0);
        btn_1=findViewById(R.id.btn_1);
        btn_2=findViewById(R.id.btn_2);
        btn_3=findViewById(R.id.btn_3);
        btn_4=findViewById(R.id.btn_4);
        btn_5=findViewById(R.id.btn_5);
        btn_6=findViewById(R.id.btn_6);
        btn_7=findViewById(R.id.btn_7);
        btn_8=findViewById(R.id.btn_8);
        btn_9=findViewById(R.id.btn_9);

        btn_dot=findViewById(R.id.btn_dot);
        btn_equal=findViewById(R.id.btn_equal);
        btn_ac=findViewById(R.id.btn_ac);
        btn_percen=findViewById(R.id.btn_percen);
        btn_plus=findViewById(R.id.btn_plus);
        btn_min=findViewById(R.id.btn_min);
        btn_x=findViewById(R.id.btn_x);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=InputTxt.getText().toString();
                InputTxt.setText(data+"0");
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=InputTxt.getText().toString();
                InputTxt.setText(data+"1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=InputTxt.getText().toString();
                InputTxt.setText(data+"2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=InputTxt.getText().toString();
                InputTxt.setText(data+"3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=InputTxt.getText().toString();
                InputTxt.setText(data+"4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=InputTxt.getText().toString();
                InputTxt.setText(data+"5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=InputTxt.getText().toString();
                InputTxt.setText(data+"6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=InputTxt.getText().toString();
                InputTxt.setText(data+"7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=InputTxt.getText().toString();
                InputTxt.setText(data+"8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=InputTxt.getText().toString();
                InputTxt.setText(data+"9");
            }
        });
        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputTxt.setText("");
                outPuttxt.setText("");
            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=InputTxt.getText().toString();
                InputTxt.setText(data+".");
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=InputTxt.getText().toString();
                InputTxt.setText(data+"+");
            }
        });
        btn_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=InputTxt.getText().toString();
                InputTxt.setText(data+"-");
            }
        });
        btn_percen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=InputTxt.getText().toString();
                InputTxt.setText(data+"%");
            }
        });
        btn_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=InputTxt.getText().toString();
                InputTxt.setText(data+"x");
            }
        });
        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = InputTxt.getText().toString();
                data = data.replaceAll("x","*");
                data = data.replaceAll("%","/100");
                data = data.replaceAll("\\+","\\+");


                Context rhino = Context.enter();
                try {
                    rhino.setOptimizationLevel(-1);

                    Scriptable scriptable = rhino.initStandardObjects();
                    String finalResult = rhino.evaluateString(scriptable, data, "Javascript", 1, null).toString();
                    outPuttxt.setText(finalResult);
                } finally {
                    Context.exit();
                }
            }
        });

    }
}