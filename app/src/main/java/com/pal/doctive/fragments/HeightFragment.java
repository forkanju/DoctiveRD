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

import com.google.android.material.textfield.TextInputLayout;
import com.pal.doctive.R;
import com.pal.doctive.activities.SurveyActivity;
import com.pal.doctive.models.Answers;


public class HeightFragment extends Fragment {

    private FragmentActivity mContext;
    private TextView next;
    private View view, heightPlus, heightMinus;
    private EditText inputHeight;
//    private TextInputLayout heightTextInputLayout;
    private ImageView back;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_height, container, false);
        next = (TextView) view.findViewById(R.id.height_nxt);
        back = (ImageView) view.findViewById(R.id.back_from_height);

        heightPlus = (View) view.findViewById(R.id.height_plus);
        heightMinus = (View) view.findViewById(R.id.height_minus);
        //heightTextInputLayout = (TextInputLayout) view.findViewById(R.id.height_textInputLayout);

        inputHeight = (EditText) view.findViewById(R.id.input_height);

        heightPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(mContext);
                String presentHeight = inputHeight.getText().toString().trim();
                int i = Integer.parseInt(presentHeight);
                int sum = i + 1;
                inputHeight.setText(sum + "");
            }
        });

        heightMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(mContext);
                String presentHeight = inputHeight.getText().toString().trim();
                int i = Integer.parseInt(presentHeight);
                int sum = i - 1;

                if (sum < 1) {
                    if (sum < 1) {
                        Toast.makeText(mContext, "Please enter a valid value!", Toast.LENGTH_SHORT).show();
                    }
                }
                inputHeight.setText(sum + "");

            }
        });

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                hideKeyboard(mContext);
                Answers.getInstance().put_answer("height", inputHeight.getText().toString().trim() + "");
                ((SurveyActivity) mContext).go_to_next();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(mContext);
                Answers.getInstance().put_answer("height", "");
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