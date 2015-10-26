package com.neel.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TipActivity extends Activity {

    int tip = 15, people = 1;
    double basicBill, calcTip, finalBill, calcTipPP, finalBillPP;
    Button incTip, decTip, incPeople, decPeople;
    TextView tipDisplay, peopleDisplay, billHead, tipHead, showTip, showBill,
            showTip5, showTip10, showTip15, showTotal5, showTotal10,
            showTotal15;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);
        variables();
        updateStuff();
    }

    public void updateResult() {
        try {
            basicBill = Double.parseDouble(input.getText().toString());
        } catch (Exception e) {
            basicBill = 0;
        }
        if (basicBill != 0) {
            calcTip = basicBill * (tip / 100.0);
            finalBill = basicBill + calcTip;
            calcTipPP = calcTip / people;
            finalBillPP = finalBill / people;
            calcTipPP = Math.round(calcTipPP * 100) / 100.0;
            finalBillPP = Math.round(finalBillPP * 100) / 100.0;
            showTip.setText(String.valueOf(calcTipPP));
            showBill.setText(String.valueOf(finalBillPP));
            calcTip = basicBill * (5 / 100.0);
            finalBill = basicBill + calcTip;
            finalBill = Math.round(finalBill * 100) / 100.0;
            calcTip = Math.round(calcTip * 100) / 100.0;
            showTip5.setText(String.valueOf(calcTip));
            showTotal5.setText(String.valueOf(finalBill));
            calcTip = basicBill * (10 / 100.0);
            finalBill = basicBill + calcTip;
            finalBill = Math.round(finalBill * 100) / 100.0;
            calcTip = Math.round(calcTip * 100) / 100.0;
            showTip10.setText(String.valueOf(calcTip));
            showTotal10.setText(String.valueOf(finalBill));
            calcTip = basicBill * (15 / 100.0);
            finalBill = basicBill + calcTip;
            finalBill = Math.round(finalBill * 100) / 100.0;
            calcTip = Math.round(calcTip * 100) / 100.0;
            showTip15.setText(String.valueOf(calcTip));
            showTotal15.setText(String.valueOf(finalBill));
        }
    }

    public void updateStuff() {
        if (tip == 1) {
            decTip.setClickable(false);
        } else if (tip == 100) {
            incTip.setClickable(false);
        } else {
            decTip.setClickable(true);
            incTip.setClickable(true);
        }
        if (people == 1) {
            decPeople.setClickable(false);
            billHead.setText(getResources().getString(R.string.totalText));
            tipHead.setText(getResources().getString(R.string.tipText));
        } else {
            decPeople.setClickable(true);
            billHead.setText("Total Bill (Per Person):");
            tipHead.setText("Tip (Per Person):");
        }
        tipDisplay.setText("Tip Percentage: " + tip + "%");
        peopleDisplay.setText("Number Of People: " + people);
    }

    public void variables() {
        incTip = (Button) findViewById(R.id.tipIncButton);
        decTip = (Button) findViewById(R.id.tipDecButton);
        incPeople = (Button) findViewById(R.id.peopleIncButton);
        decPeople = (Button) findViewById(R.id.peopleDecButton);
        tipDisplay = (TextView) findViewById(R.id.tipPercent);
        peopleDisplay = (TextView) findViewById(R.id.numberPeople);
        billHead = (TextView) findViewById(R.id.billHeader);
        tipHead = (TextView) findViewById(R.id.tipHeader);
        input = (EditText) findViewById(R.id.editText1);
        showTip = (TextView) findViewById(R.id.finalTip);
        showBill = (TextView) findViewById(R.id.finalBill);
        showTip5 = (TextView) findViewById(R.id.textTip5);
        showTip10 = (TextView) findViewById(R.id.textTip10);
        showTip15 = (TextView) findViewById(R.id.textTip15);
        showTotal5 = (TextView) findViewById(R.id.textTotal5);
        showTotal10 = (TextView) findViewById(R.id.textTotal10);
        showTotal15 = (TextView) findViewById(R.id.textTotal15);

        // Listeners
        incTip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tip++;
                updateStuff();
                updateResult();
            }
        });
        decTip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tip--;
                updateStuff();
                updateResult();
            }
        });
        incPeople.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                people++;
                updateStuff();
                updateResult();
            }
        });
        decPeople.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                people--;
                updateStuff();
                updateResult();
            }
        });
        input.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                try {
                    basicBill = Double.parseDouble(input.getText().toString());
                    updateResult();
                } catch (Exception e) {
                    showTip.setText(getResources().getString(
                            R.string.defaultText));
                    showBill.setText(getResources().getString(
                            R.string.defaultText));
                    showTip5.setText(getResources().getString(
                            R.string.defaultText));
                    showTip10.setText(getResources().getString(
                            R.string.defaultText));
                    showTip15.setText(getResources().getString(
                            R.string.defaultText));
                    showTotal5.setText(getResources().getString(R.string.defaultText));
                    showTotal10.setText(getResources().getString(R.string.defaultText));
                    showTotal15.setText(getResources().getString(R.string.defaultText));
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                try {
                    basicBill = Double.parseDouble(input.getText().toString());
                    updateResult();
                } catch (Exception e) {
                    showTip.setText(getResources().getString(
                            R.string.defaultText));
                    showBill.setText(getResources().getString(
                            R.string.defaultText));
                    showTip5.setText(getResources().getString(
                            R.string.defaultText));
                    showTip10.setText(getResources().getString(
                            R.string.defaultText));
                    showTip15.setText(getResources().getString(
                            R.string.defaultText));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
