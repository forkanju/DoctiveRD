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

public class HeartdiseasFragment extends Fragment {
    private View view;
    private FragmentActivity mContext;
    private Button noHeartdiseas, yesHeartdiseas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_heartdiseas, container, false);

        noHeartdiseas = (Button) view.findViewById(R.id.on_heartdiseas);
        yesHeartdiseas = (Button) view.findViewById(R.id.yes_heartdiseas);
        //no heart disease button clicked
        noHeartdiseas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answers.getInstance().put_answer("heartdisease", "no");
                ((SurveyActivity) mContext).go_to_next();
            }
        });

        yesHeartdiseas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answers.getInstance().put_answer("heartdisease", "yes");
                ((SurveyActivity) mContext).go_to_next();
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