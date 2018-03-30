package com.example.csk.csk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity=1;

    public void submit(View view) {
        int m = 10;
        display(quantity);
        setPrice(quantity * m);
    }

    public void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" +number);
    }

    public void setPrice(int number) {
        TextView quantity = (TextView) findViewById(R.id.price_text_view);
        quantity.setText(NumberFormat.getCurrencyInstance().format(number));
    }
public void increment(View view)
{
    quantity=quantity+1;
    display(quantity);
    }
public void decrement(View view)
{          if (quantity!=0)
{
            quantity = quantity - 1;
            display(quantity);
        }}
}

