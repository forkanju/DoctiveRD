package com.pal.doctive.activities;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.pal.doctive.R;

import java.util.ArrayList;

public class CoachReadyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_ready);

        BarChart chart = findViewById(R.id.barchart);

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

        //..............................For Pie Chart................................//

        PieChart pieChart = findViewById(R.id.piechart);


        ArrayList noOfEmp = new ArrayList();

        noOfEmp.add(new Entry(22.24f, 0));
        noOfEmp.add(new Entry(10.9f, 0));
        noOfEmp.add(new Entry(40f, 0));

        PieDataSet dataSet = new PieDataSet(noOfEmp, "Health Overview");

        ArrayList bmi = new ArrayList();

        bmi.add("Normal");
        bmi.add("OverWeight");
        bmi.add("UnderWeight");

        PieData pieData = new PieData(bmi, dataSet);
        pieChart.setData(pieData);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.animateXY(5000, 5000);

        //..............................For Line Chart................................//

        LineChart lineChart = findViewById(R.id.line_chart);


        ArrayList noOfLine = new ArrayList();

        noOfLine.add(new Entry(220.24f, 5));
        noOfLine.add(new Entry(100.9f, 2));
        noOfLine.add(new Entry(90f, 8));
        noOfLine.add(new Entry(305f, 15));

        LineDataSet lineDataSet = new LineDataSet(noOfLine, "Health Overview");

        ArrayList line = new ArrayList();

        line.add("Normal");
        line.add("OverWeight");
        line.add("UnderWeight");
        line.add("Line");

        LineData lineData = new LineData(line, lineDataSet);
        lineChart.setData(lineData);
        lineChart.setBorderColor(Color.blue(2));
        lineChart.animateXY(5000, 5000);

        lineChart.getAxisRight().setEnabled(false);
        lineChart.setDrawMarkerViews(true);


    }
}