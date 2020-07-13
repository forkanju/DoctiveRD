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


public class MailFragment extends Fragment {

    private View view;
    private FragmentActivity mContext;
    private Button noMail, yesMail;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mail, container, false);

        noMail = (Button) view.findViewById(R.id.mail_no);
        yesMail = (Button) view.findViewById(R.id.mail_yes);

        noMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answers.getInstance().put_answer("mailnotify", "no");
                ((SurveyActivity) mContext).event_survey_completed(Answers.getInstance());
            }
        });

        yesMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answers.getInstance().put_answer("mailnotify", "yes");
                ((SurveyActivity) mContext).event_survey_completed(Answers.getInstance());
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