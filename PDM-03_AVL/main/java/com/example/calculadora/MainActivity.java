package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etNumber1, etNumber2;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        tvResult = findViewById(R.id.tvRes);


    }

    public void onButtonClick(View view) {
        double num1 = Double.parseDouble(etNumber1.getText().toString());
        double num2 = Double.parseDouble(etNumber2.getText().toString());

        double result = 0;

        switch (view.getId()) {
            case R.id.button:
                result = num1 + num2;
                break;
            case R.id.button2:
                result = num1 - num2;
                break;
            case R.id.button3:
                result = num1 * num2;
                break;
            case R.id.button4:
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    tvResult.setText("No se puede dividir por cero.");
                    return;
                }
                break;
        }

        tvResult.setText("Resultado: " + result);
    }
}