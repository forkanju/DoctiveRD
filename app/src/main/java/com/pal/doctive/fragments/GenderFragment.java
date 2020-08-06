package com.pal.doctive.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.pal.doctive.R;
import com.pal.doctive.activities.SurveyActivity;
import com.pal.doctive.models.Answers;

public class GenderFragment extends Fragment {

    private FragmentActivity mContext;
    private View view;
    private Button btn_male, btn_female;
    private ImageView back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_gender, container, false);
        btn_male = (Button) view.findViewById(R.id.btn_male);
        btn_female = (Button) view.findViewById(R.id.btn_female);
        back = (ImageView) view.findViewById(R.id.back_from_gender);
        //Male button click
        btn_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answers.getInstance().put_answer("gender", "male");
                ((SurveyActivity) mContext).go_to_next();
            }
        });

        //Female button click
        btn_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answers.getInstance().put_answer("gender", "female");
                ((SurveyActivity) mContext).go_to_next();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answers.getInstance().put_answer("gender", "");
                ((SurveyActivity) mContext).go_back_to_start_activity();

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
