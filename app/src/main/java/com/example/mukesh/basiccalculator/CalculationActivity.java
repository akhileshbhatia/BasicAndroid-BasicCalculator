package com.example.mukesh.basiccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class CalculationActivity extends AppCompatActivity {
    public static String operation = "";

    public void operationBtnClicked(View view){
        switch (view.getId()){
            case R.id.plusBtn:
                operation = "plus";
                break;
            case R.id.minusBtn:
                operation = "minus";
                break;
            case R.id.multiplyBtn:
                operation = "multiply";
                break;
            case R.id.divideBtn:
                operation = "divide";
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        final Button calculateBtn = findViewById(R.id.calculateBtn);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView resultText = (TextView)findViewById(R.id.resultText);

                EditText firstNumTemp = (EditText)findViewById(R.id.firstNumText);
                String firstNumString = firstNumTemp.getText().toString();

                EditText secondNumTemp = (EditText)findViewById(R.id.secondNumText);
                String secondNumString = secondNumTemp.getText().toString();

                if(firstNumString.isEmpty() && secondNumString.isEmpty()){
                    resultText.setText("Please enter values in both textboxes");
                }
                else{
                    float firstNum = Float.parseFloat(firstNumString);
                    float secondNum = Float.parseFloat(secondNumString);

                    switch (operation){
                        case "":
                            resultText.setText("Please select an operation to perform");
                            break;
                        case "plus":
                            resultText.setText(String.valueOf(firstNum+secondNum));
                            operation="";
                            break;
                        case "minus":
                            resultText.setText(String.valueOf(firstNum - secondNum));
                            operation="";
                            break;
                        case "multiply":
                            resultText.setText(String.valueOf(firstNum*secondNum));
                            operation="";
                            break;
                        case "divide":
                            if(secondNum == 0)
                                resultText.setText("The divisor cannot be zero");
                            else{
                                resultText.setText(String.valueOf(firstNum/secondNum));
                                operation="";
                            }
                            break;
                    }
                }

            }
        });
    }

}
