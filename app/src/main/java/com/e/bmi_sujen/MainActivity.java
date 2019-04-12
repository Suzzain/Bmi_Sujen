package com.e.bmi_sujen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText etHeight, etWeight;
TextView tvBmir;
Button btnResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        tvBmir = findViewById(R.id.tvBmir);
        btnResult = findViewById(R.id.btnResult);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double height, weight, bmi;
                height = Double.parseDouble(etHeight.getText().toString());
                weight = Double.parseDouble(etWeight.getText().toString());

                BmiCalc bmicalc = new BmiCalc(height, weight);
                bmi = bmicalc.Bmi();
                tvBmir.setText(Double.toString(bmi));

                Toast.makeText(MainActivity.this, bmicalc.Category(), Toast.LENGTH_LONG).show();

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(btnResult.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
            }
        });
    }
}
