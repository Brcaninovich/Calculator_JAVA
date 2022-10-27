package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView solution_TV;
    TextView result_TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        solution_TV = findViewById(R.id.solution_tv);
        result_TV = findViewById(R.id.result_tv);
        solution_TV.setText("0");
        result_TV.setText("0");



    }

    public void napisi(String noviString){
        if(solution_TV.getText() == "0"){
            solution_TV.setText(noviString);
        }else
        {
            solution_TV.setText(solution_TV.getText() + noviString);
        }

    }

    public void result_onClick(View view) {
        //Toast.makeText(this, solution_TV.getText(), Toast.LENGTH_SHORT).show();
        result_TV.setText(calculator_function.rezultat("solution"));
    }

    public void ac_onClick(View view) {
        solution_TV.setText("0");
        result_TV.setText("0");
    }

    public void c_onClick(View view) {
        if(!(solution_TV.getText().toString()).isEmpty())
            solution_TV.setText(solution_TV.getText().subSequence(0, solution_TV.length()-1));
    }

    public void pow_onClick(View view) {
        napisi("^");
    }

    public void next_onClick(View view) {
    }

    public void zero_onClick(View view) {
        napisi("0");
    }

    public void dot_onClick(View view) {
        napisi(".");
    }

    public void one_onClick(View view) {
        napisi("1");
    }

    public void two_onClick(View view) {
        napisi("2");
    }

    public void three_onClick(View view) {
        napisi("3");
    }

    public void plus_onClick(View view) {
        napisi("+");
    }

    public void four_onClick(View view) {
        napisi("4");
    }

    public void five_onClick(View view) {
        napisi("5");
    }

    public void six_onClick(View view) {
        napisi("6");
    }

    public void minus_onClick(View view) {
        napisi("-");
    }

    public void seven_onClick(View view) {
        napisi("7");
    }

    public void eight_onClick(View view) {
        napisi("8");
    }

    public void nine_onClick(View view) {
        napisi("9");
    }

    public void multiply_onClick(View view) {
        napisi("*");
    }

    public void divide_onClick(View view) {
        napisi("/");
    }
}