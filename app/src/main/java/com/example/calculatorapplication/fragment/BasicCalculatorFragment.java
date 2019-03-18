package com.example.calculatorapplication.fragment;
/**
 * @author Swati.Khobragade
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

import com.example.calculatorapplication.Controller.BasicOperationCalculation;
import com.example.calculatorapplication.R;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link BasicCalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BasicCalculatorFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Button mAddBtn;
    private Button mSubBtn;
    private Button mMultBtn;
    private Button mDivBtn;
    private EditText mFirstNumberEditText;
    private EditText mSecondNumberEditText;
    private TextView mResultTextView;
    public RelativeLayout mRelativeLayoutBasic;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BasicCalculatorFragment.
     */
    public static BasicCalculatorFragment newInstance() {
        BasicCalculatorFragment fragment = new BasicCalculatorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        Log.d("fragment1", fragment + "");
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_basic_calculator, container, false);
        initViews();
        registerListeners();
        return view;

    }

    /**
     * Initialize the Views
     */
    private void initViews() {
        mAddBtn = view.findViewById(R.id.btnAdd);
        mSubBtn = view.findViewById(R.id.btnSub);
        mMultBtn = view.findViewById(R.id.btnMult);
        mDivBtn = view.findViewById(R.id.btnDiv);
        mFirstNumberEditText = view.findViewById(R.id.etBasicNum1);
        mSecondNumberEditText = view.findViewById(R.id.etBasicNum2);
        mResultTextView = view.findViewById(R.id.etResultBasic);
        mRelativeLayoutBasic = view.findViewById(R.id.mainLayoutBasic);
        Log.d("mRelativeLayoutBasic", "" + mRelativeLayoutBasic);
    }

    /**
     * Register Listeners
     */
    private void registerListeners() {
        mAddBtn.setOnClickListener(this);
        mSubBtn.setOnClickListener(this);
        mMultBtn.setOnClickListener(this);
        mDivBtn.setOnClickListener(this);
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd:
                performOperation("add");
                break;
            case R.id.btnSub:
                performOperation("sub");
                break;
            case R.id.btnMult:
                performOperation("mult");
                break;
            case R.id.btnDiv:
                performOperation("div");
                break;
        }
    }

    /**
     * Validate Empty Fields
     * @param firstNum
     * @param secondNum
     * @return
     */
    private boolean validateFields(String firstNum, String secondNum) {
        if (TextUtils.isEmpty(firstNum)) {
            Toast.makeText(getActivity(), "Please Enter Firstr Number", LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(secondNum)) {
            Toast.makeText(getActivity(), "Please Enter Second Number", LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * Perform Arithmetic Operation based on String passed
     * @param operation
     */
    private void performOperation(String operation) {
        String firstNum = mFirstNumberEditText.getText().toString().trim();
        String secondNum = mSecondNumberEditText.getText().toString().trim();
        if (validateFields(firstNum, secondNum)) {
            BasicOperationCalculation basicOperationCalculation = new BasicOperationCalculation();
            double result = basicOperationCalculation.calculateBasicOperation(Double.parseDouble(firstNum), Double.parseDouble(secondNum), operation);
            mResultTextView.setText("" + result);
        }
    }

    /**
     * Set Background color to outer frame
     * @param args
     */
    public void putArguments(Bundle args) {
        String colorVal = args.getString("selectedColor");
        Log.d("colorVal", "" + colorVal);
        mRelativeLayoutBasic.setBackgroundColor(Color.parseColor(colorVal));
    }

}
