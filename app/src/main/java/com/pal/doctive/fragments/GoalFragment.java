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

public class GoalFragment extends Fragment {

    private FragmentActivity mContext;
    private View view;
    private Button loseFat, getFitter, gainMuscle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_goal, container, false);

        loseFat = (Button) view.findViewById(R.id.lose_fat);
        getFitter = (Button) view.findViewById(R.id.get_fitter);
        gainMuscle = (Button) view.findViewById(R.id.lose_fat);

        //lose fitness button clicked
        loseFat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answers.getInstance().put_answer("goal", "lose fate");
                ((SurveyActivity) mContext).go_to_next();
            }
        });

        //get fitter button clicked
        getFitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answers.getInstance().put_answer("goal", "get fitter");
                ((SurveyActivity) mContext).go_to_next();

            }
        });

        //gain muscle button clicked
        gainMuscle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answers.getInstance().put_answer("goal", "gain muscle");
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
