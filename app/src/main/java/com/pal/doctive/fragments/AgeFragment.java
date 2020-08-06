package com.pal.doctive.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.pal.doctive.R;
import com.pal.doctive.activities.SurveyActivity;
import com.pal.doctive.models.Answers;

public class AgeFragment extends Fragment {

    private FragmentActivity mContext;
    private View view, agePlus, ageMinus;
    private TextView next;
    private EditText inputAge;
    private ImageView back;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_age, container, false);
        next = (TextView) view.findViewById(R.id.age_nxt);
        inputAge = (EditText) view.findViewById(R.id.input_age);
        back = (ImageView) view.findViewById(R.id.back_from_age);

        agePlus = (View) view.findViewById(R.id.age_plus);
        ageMinus = (View) view.findViewById(R.id.age_minus);


        agePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(mContext);
                String presentAge = inputAge.getText().toString().trim();
                int i = Integer.parseInt(presentAge);
                final int sum = i + 1;
                inputAge.setText(sum + "");

            }
        });

        ageMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(mContext);
                String presentInput = inputAge.getText().toString().trim();
                int i = Integer.parseInt(presentInput);
                final int sum = i - 1;
                if (sum < 1) {
                    Toast.makeText(mContext, "Please enter a valid value!", Toast.LENGTH_SHORT).show();
                }
                inputAge.setText(sum + "");

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(mContext);
                Answers.getInstance().put_answer("age", inputAge.getText().toString().trim() + "");
                ((SurveyActivity) mContext).go_to_next();
                //event_survey_completed(Answers.getInstance())
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(mContext);
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
