package edu.harding.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity
{
    private EditText billAmountView ;
    private EditText tipPercentView;
    private TextView tipAmountView;
    private TextView totalAmountView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        billAmountView = (EditText) findViewById(R.id.billAmount);
        tipPercentView = (EditText) findViewById(R.id.percentAmount);
        tipAmountView = (TextView) findViewById(R.id.tipAmount);
        totalAmountView = (TextView) findViewById(R.id.totalAmount);
    }


    public void calculateClick (View view)
    {
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
        float billAmount = 0;
        float tipPercent = 0;

        try {
            billAmount = Float.parseFloat(billAmountView.getText().toString());
            tipPercent = Float.parseFloat(tipPercentView.getText().toString());

            float tipAmount = billAmount * tipPercent / 100;
            float totalAmount = billAmount + tipAmount;

            String tipAmountMoney = moneyFormat.format(tipAmount);
            String totalAmountMoney = moneyFormat.format(totalAmount);

            tipAmountView.setText(tipAmountMoney);
            totalAmountView.setText(totalAmountMoney);
        }
        catch (NumberFormatException x)
        {
            Toast.makeText(this,
                    "Enter numbers for bill and tip percent.",
                    Toast.LENGTH_SHORT).show();
            tipAmountView.setText("");
            totalAmountView.setText("");
        }

    }





}

