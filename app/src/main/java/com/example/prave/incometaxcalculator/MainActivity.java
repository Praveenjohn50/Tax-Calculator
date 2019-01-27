package com.example.prave.incometaxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Done";
    Button mButtonIndividual;
    Button mButtonSenior;
    Button mButtonSuperSenior;
    Button mButtonCalculate;
    EditText mEditIncome;
    TextView mTextDeductinView;
    TextView mTextOutput, mPercentOutput, mRebate;
    LinearLayout mOutputLinear;
    int selection = 1;
    int income;
    Calculations calculations;
    DataObject dataObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initui();

    }

    private void initui() {
        mButtonIndividual = findViewById(R.id.ind_button);
        mButtonSenior = findViewById(R.id.senior_button);
        mButtonSuperSenior = findViewById(R.id.supers_button);
        mButtonCalculate = findViewById(R.id.calculate_button);
        mEditIncome = findViewById(R.id.edt_annual_income);
        mTextOutput = findViewById(R.id.output_view);
        mPercentOutput = findViewById(R.id.percent_view);
        mTextDeductinView = findViewById(R.id.deduction_view);
        mRebate = findViewById(R.id.rebate_view);
        mOutputLinear = findViewById(R.id.main_output);
        mButtonIndividual.setOnClickListener(this);
        mButtonSenior.setOnClickListener(this);
        mButtonSuperSenior.setOnClickListener(this);
        mButtonCalculate.setOnClickListener(this);
        calculations = new Calculations();
        mOutputLinear.setVisibility(View.INVISIBLE);
        mEditIncome.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    typeselection();
                }
                return false;
            }
        });
        mEditIncome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                mOutputLinear.setVisibility(View.INVISIBLE);
                if ((mEditIncome.getText() != null) && (!mEditIncome.getText().toString().equals(""))) {
                    typeselection();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ind_button:
                selection = 1;
                break;
            case R.id.senior_button:
                selection = 2;
                break;
            case R.id.supers_button:
                selection = 3;
                break;
            case R.id.calculate_button:
                if ((mEditIncome.getText() != null) && (!mEditIncome.getText().toString().equals(""))) {
                    typeselection();
                } else {
                    Toast.makeText(this, "Enter Amount", Toast.LENGTH_SHORT).show();
                }

                break;
        }

    }

    private void typeselection() {
        switch (selection) {
            case 0:
                Toast.makeText(this, "Please Select an Option", Toast.LENGTH_SHORT).show();
                break;
            case 1:

                income = Integer.parseInt(mEditIncome.getText().toString());
                dataObject = calculations.inidivdualcalculation(income);
                mTextOutput.setText(String.valueOf(dataObject.getTotaltax()) + " Rs");
                mPercentOutput.setText(String.valueOf(dataObject.getMedical()) + " Rs");
                mTextDeductinView.setText(String.valueOf(dataObject.getTotalpayable()) + " Rs");
                if (dataObject.isRebate()) {
                    mRebate.setTextColor(getResources().getColor(R.color.Green));
                    mRebate.setText("yes");
                } else {
                    mRebate.setTextColor(getResources().getColor(R.color.Red));

                    mRebate.setText("No");
                }

                mOutputLinear.setVisibility(View.VISIBLE);

                break;
//            case 2:
//                income = Integer.parseInt(mEditIncome.getText().toString());
//                dataObject = calculations.seniorcalculation(income);
//                mTextOutput.setText(String.valueOf(dataObject.getOutputvalue()) + " Rs");
//                mPercentOutput.setText(String.valueOf(dataObject.getPercentagev()) + "%");
//                mTextDeductinView.setText(String.valueOf(dataObject.getDeduction()) + " Rs");
//                mOutputLinear.setVisibility(View.VISIBLE);
//
//
//                break;
//            case 3:
//                income = Integer.parseInt(mEditIncome.getText().toString());
//                dataObject = calculations.superseniorcalculation(income);
//                mTextOutput.setText(String.valueOf(dataObject.getOutputvalue()) + " Rs");
//                mPercentOutput.setText(String.valueOf(dataObject.getPercentagev()) + "%");
//                mTextDeductinView.setText(String.valueOf(dataObject.getDeduction()) + " Rs");
//                mOutputLinear.setVisibility(View.VISIBLE);
//
//
//                break;
        }
    }
}
