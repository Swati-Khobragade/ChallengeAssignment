package com.example.calculatorapplication.fragment;
/*
@author Swati.Khobragade
 */

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculatorapplication.Controller.ScientificOperationCalculation;
import com.example.calculatorapplication.R;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ScientificCalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScientificCalculatorFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Button mLogBtn;
    private Button mLogNBtn;
    private EditText mNumberEditText;
    private TextView mResultTextView;
    private RelativeLayout mRelativeLayoutScientific;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ScientificCalculatorFragment.
     */
    public static ScientificCalculatorFragment newInstance() {
        ScientificCalculatorFragment fragment = new ScientificCalculatorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_scientific_calculator, container, false);
        initViews();
        registerListeners();
        return view;
    }

    /**
     * Register Listeners
     */
    private void registerListeners() {
        mLogBtn.setOnClickListener(this);
        mLogNBtn.setOnClickListener(this);
    }

    /**
     * Initialize the Views
     */
    private void initViews() {
        mLogBtn = view.findViewById(R.id.btnLog);
        mLogNBtn = view.findViewById(R.id.btnLogN);
        mNumberEditText = view.findViewById(R.id.etNum);
        mResultTextView = view.findViewById(R.id.etResulScientific);
        mRelativeLayoutScientific = view.findViewById(R.id.mainLayoutScientific);
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLog:
                performOperation("log");
                break;
            case R.id.btnLogN:
                performOperation("logN");
                break;
        }
    }

    /**
     * Perform Perform Operation based on Passed String
     * @param operation
     */
    private void performOperation(String operation) {
        String numberValue = mNumberEditText.getText().toString().trim();
        if (validateFields(numberValue)) {
            ScientificOperationCalculation scientificOperationCalculation = new ScientificOperationCalculation();
            double result = scientificOperationCalculation.calculateScientificOperation(Double.parseDouble(numberValue), operation);
            mResultTextView.setText("" + result);
        }
    }

    /**
     * Validate Fields
     * @param number
     * @return
     */
    private boolean validateFields(String number) {
        if (TextUtils.isEmpty(number)) {
            Toast.makeText(getActivity(), "Please Enter Number", LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * Set Backgroud color to outer frame
     * @param bundle
     */
    public void putArguments(Bundle bundle) {
        String colorVal = bundle.getString("selectedColor");
        Log.d("colorVal", "" + colorVal);
        mRelativeLayoutScientific.setBackgroundColor(Color.parseColor(colorVal));
    }
}

