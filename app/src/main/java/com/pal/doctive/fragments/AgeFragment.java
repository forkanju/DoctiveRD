package com.pal.doctive.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.pal.doctive.R;
import com.pal.doctive.activities.SurveyActivity;
import com.pal.doctive.models.Answers;


public class AgeFragment extends Fragment {

    private FragmentActivity mContext;
    private View view;
    private TextView next;
    private EditText inputAge;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_age, container, false);
        next = (TextView) view.findViewById(R.id.age_nxt);

        inputAge = (EditText) view.findViewById(R.id.input_age);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answers.getInstance().put_answer("age", inputAge.getText().toString().trim() + "");
                ((SurveyActivity) mContext).go_to_next();
                //event_survey_completed(Answers.getInstance())
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();
    }
}
