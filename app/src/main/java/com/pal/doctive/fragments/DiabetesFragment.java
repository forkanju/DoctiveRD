package com.pal.doctive.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pal.doctive.R;
import com.pal.doctive.activities.SurveyActivity;
import com.pal.doctive.models.Answers;


public class DiabetesFragment extends Fragment {

    private View view;
    private FragmentActivity mContext;
    private Button noDiabetes, yesDiabetes;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_diabetes, container, false);

        noDiabetes = (Button) view.findViewById(R.id.diabetes_no);
        yesDiabetes = (Button) view.findViewById(R.id.diabetes_yes);
        //no diabetes button clicked
        noDiabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answers.getInstance().put_answer("diabetes", "no");
                ((SurveyActivity)mContext).go_to_next();
            }
        });
        //yes diabetes button clicked
        yesDiabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answers.getInstance().put_answer("diabetes", "yes");
                ((SurveyActivity)mContext).go_to_next();
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