package com.gigi.tempapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnCalculate,btnSend;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //users cannot see the activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = findViewById(R.id.button);


    }

    protected float convertCelciusToFahrenheit(Float value) {
        Float ans = (value - 32) * 5 / 9;
        return ans;
    }

    protected float convertFahrenheitToCelcius(Float value) {
        Float ans = (value * 9 / 5) + 32;
        return ans;
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }

    private void calculateAnswer() {

        RadioGroup rg = findViewById(R.id.radioGroup);

        int i = rg.getCheckedRadioButtonId();
        EditText et = findViewById(R.id.editTextNumberDecimal);
        TextView tv = findViewById(R.id.textView);
        String s=et.getText().toString();
        Boolean error=Boolean.FALSE;

        if (s.equals("")) {
            Toast.makeText(this, "Please add a value", Toast.LENGTH_LONG).show();
        } else {

            Float d=0.0f;
            try {

                d = Float.parseFloat(s);
            }
            catch(NumberFormatException e)
            {
                Toast.makeText(this, "Invalid entry", Toast.LENGTH_LONG).show();
                error=Boolean.TRUE;

            }
            if(!error) {
                if (i == R.id.radioButton) {
                    Float ans = convertCelciusToFahrenheit(d);
                    tv.setText(ans + "");
                } else {
                    Float ans = convertFahrenheitToCelcius(d);
                    tv.setText(ans + "");

                }
            }

        }


    }

}
