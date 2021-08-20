package com.example.akikulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.TransitionManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Context context;

    String history,currentResult;
    TextView textView1,textView2;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,button20;
    String number = null;
    Double f = 0.0;
    Double l = 0.0;

    String status=null;
    Boolean operator = false;

    DecimalFormat myFormat = new DecimalFormat("######.######");

    Boolean dot=true;

    Boolean btnAc = true;

    Boolean btnEql = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.tv1);
        textView2 = findViewById(R.id.tv2);

        button1 = findViewById(R.id.b1);
        button2 = findViewById(R.id.b2);
        button3 = findViewById(R.id.b3);
        button4 = findViewById(R.id.b4);
        button5 = findViewById(R.id.b5);
        button6 = findViewById(R.id.b6);
        button7 = findViewById(R.id.b7);
        button8 = findViewById(R.id.b8);
        button9 = findViewById(R.id.b9);
        button10 = findViewById(R.id.b10);
        button11 = findViewById(R.id.b11);
        button12 = findViewById(R.id.b12);
        button13 = findViewById(R.id.b13);
        button14 = findViewById(R.id.b14);
        button15 = findViewById(R.id.b15);
        button16 = findViewById(R.id.b16);
        button17 = findViewById(R.id.b17);
        button18 = findViewById(R.id.b18);
        button19 = findViewById(R.id.b19);
        button20 = findViewById(R.id.b20);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               number = null;
               status = null;
               textView2.setText("0");
               textView1.setText("");
               f=0.0;
               l=0.0;
               dot = true;
               btnAc = true;
                button1.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btnAc){
                    textView2.setText("0");
                }
                else {
                    number = number.substring(0,number.length()-1);
                    if(number.length()==0){
                        button2.setClickable(false);
                    }else if(number.contains(".")){
                        dot = false;
                    }else {
                        dot = true;
                    }


                    textView2.setText(number);
                }
                button2.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textView1.getText().toString();
                currentResult = textView2.getText().toString();
                textView1.setText(history + currentResult+ "÷");
                if(operator){
                    if(status == "substraction"){
                        minus();
                    }
                    else if(status == "muptiplication"){
                        multiply();
                    }
                    else if(status == "sum"){
                        plus();
                    }
                    else {
                        divide();
                    }
                }
                status = "division";
                operator = false;
                number = null;
                dot = true;
                button3.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textView1.getText().toString();
                currentResult = textView2.getText().toString();
                textView1.setText(history + currentResult+ "×");

                if(operator){
                    if(status == "substraction"){
                       minus();
                    }
                    else if(status == "division"){
                        divide();
                    }
                    else if(status == "sum"){
                        plus();
                    }
                    else {
                        multiply();
                    }
                }
                status = "muptiplication";
                operator = false;
                number = null;
                dot = true;
                button4.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("7");
                button5.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("8");
                button6.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("9");
                button7.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textView1.getText().toString();
                currentResult = textView2.getText().toString();
                textView1.setText(history + currentResult+ "-");
                if(operator){
                    if(status == "muptiplication"){
                        multiply();
                    }
                    else if(status == "division"){
                        divide();
                    }
                    else if(status == "sum"){
                        plus();
                    }
                    else {
                        minus();
                    }
                }
                status = "substraction";
                operator = false;
                number = null;
                dot = true;

                button8.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("4");
                button9.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("5");
                button10.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("6");
                button11.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textView1.getText().toString();
                currentResult = textView2.getText().toString();
                textView1.setText(history + currentResult+ "+");

                if(operator){
                    if(status == "muptiplication"){
                        multiply();
                    }
                    else if(status == "division"){
                        divide();
                    }
                    else if(status == "substraction"){
                        minus();
                    }

                    else {
                        plus();
                    }
                }
                status = "sum";
                operator = false;
                number = null;
                dot = true;
                button12.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("1");
                button13.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("2");
                button14.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("3");
                button15.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "LOL", Toast.LENGTH_SHORT).show();
                button16.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button17.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));




            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("0");
                button18.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(dot){
                    if(number == null){
                        number = "0.0";
                    }
                    else {
                        number = number +".";
                    }

                }


                textView2.setText(number);
                dot = false;
                button19.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(operator){
                    if(status == "sum"){
                        plus();
                    }
                    else if(status=="substraction"){
                        minus();
                    }
                    else if (status=="muptiplication"){
                        multiply();
                    }else if(status == "division"){
                        divide();


                    }

                    else{
                        f = Double.parseDouble(textView2.getText().toString());
                    }
                }
                operator = false;
                btnEql = true;
                button20.startAnimation(AnimationUtils.loadAnimation(MainActivity.this ,R.anim.scale_up));

            }
        });



    }
    public void numberClick(String view){

        if(number == null){
            number = view;
        }
        else if(btnEql){
            f = 0.0;
            l = 0.0;
            number = view;

        }
        else{
            number = number + view;
        }

        textView2.setText(number);
        operator = true;
        btnAc = false;
        button2.setClickable(true);
        btnEql = false;




    }
    public void plus(){
        l = Double.parseDouble(textView2.getText().toString());
        f = f +l;
        textView2.setText(myFormat.format(f));
    }
    public void minus(){
       if(f == 0){
           f = Double.parseDouble(textView2.getText().toString());

       }
       else {
           l = Double.parseDouble(textView2.getText().toString());
           f = f-l;
       }
        textView2.setText(myFormat.format(f));

    }
    public void multiply(){
        if(f==0){
            f = 1.0;
            l = Double.parseDouble(textView2.getText().toString());
            f = f*l;

        }
        else{
            l = Double.parseDouble(textView2.getText().toString());
            f = f*l;

        }
        textView2.setText(myFormat.format(f));
    }
    public void divide(){
        if(f==0){
            l = Double.parseDouble(textView2.getText().toString());
            f = l/1;

        }
        else {
            l = Double.parseDouble(textView2.getText().toString());
            f =f/l;
        }
        textView2.setText(myFormat.format(f));

    }

}