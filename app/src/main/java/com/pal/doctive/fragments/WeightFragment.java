package com.pal.doctive.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pal.doctive.R;
import com.pal.doctive.activities.SurveyActivity;
import com.pal.doctive.models.Answers;


public class WeightFragment extends Fragment {
    private View view, weightPlus, weightMinus;
    private FragmentActivity mContext;
    private TextView next;
    private EditText inputWeight;
    private ImageView back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_weight, container, false);
        //Find viw by ID
        inputWeight = (EditText) view.findViewById(R.id.input_weight);
        next = (TextView) view.findViewById(R.id.weight_nxt);
        back = (ImageView) view.findViewById(R.id.back_from_weight);
        weightPlus = (View) view.findViewById(R.id.weight_plus);
        weightMinus = (View) view.findViewById(R.id.weight_minus);

        weightPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(mContext);
                String presentHeight = inputWeight.getText().toString().trim();
                double d = Double.parseDouble(presentHeight);
                double sum = d + 0.1;
                //double decimal format
                String strDouble = String.format("%.1f", sum);
                inputWeight.setText(strDouble + "");

            }
        });

        weightMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(mContext);
                String presentHeight = inputWeight.getText().toString().trim();
                double d = Double.parseDouble(presentHeight);
                double sum = d - 0.1;
                if (sum < 1) {
                    Toast.makeText(mContext, "Please enter a valid value!", Toast.LENGTH_SHORT).show();
                }
                //double decimal format
                String strDouble = String.format("%.1f", sum);
                inputWeight.setText(strDouble + "");

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(mContext);
                Answers.getInstance().put_answer("weight", inputWeight.getText().toString().trim() + "");
                ((SurveyActivity) mContext).go_to_next();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(mContext);
                Answers.getInstance().put_answer("weight", "");
                ((SurveyActivity) mContext).go_to_back();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();
    }

    //SoftKeyBoard hide/close
    public static void hideKeyboard(Activity mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = mContext.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(mContext);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}