package com.pal.profileviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class AllWeekFragment extends Fragment {

    private FragmentActivity mContext;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_all_week, container, false);
        //BarChart showing
        BarChart chart = (BarChart) view.findViewById(R.id.barchart_all);

        ArrayList NoOfEmp = new ArrayList();

        NoOfEmp.add(new BarEntry(112f, 0));
        NoOfEmp.add(new BarEntry(205f, 1));
        NoOfEmp.add(new BarEntry(223f, 2));
        NoOfEmp.add(new BarEntry(260f, 3));
        NoOfEmp.add(new BarEntry(149f, 4));
        NoOfEmp.add(new BarEntry(96f, 5));
        NoOfEmp.add(new BarEntry(298f, 6));

        ArrayList year = new ArrayList();

        year.add("S");
        year.add("S");
        year.add("M");
        year.add("T");
        year.add("W");
        year.add("T");
        year.add("F");

        BarDataSet barDataSet = new BarDataSet(NoOfEmp, "Health Overview");
        chart.animateY(4000);
        BarData data = new BarData(year, barDataSet);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();
    }
}