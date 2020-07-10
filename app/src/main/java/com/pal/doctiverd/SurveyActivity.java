package com.pal.doctiverd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.pal.doctiverd.databinding.ActivityViewsSliderBinding;

public class SurveyActivity extends AppCompatActivity {

    private ViewsSliderAdapter mAdapter;
    private TextView[] dots;
    private int[] layouts;
    private ActivityViewsSliderBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityViewsSliderBinding.inflate(getLayoutInflater());
        setContentView(((ActivityViewsSliderBinding) binding).getRoot());

        // For Hide Status/Notification Bar background color;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        init();


    }

    private void init() {
        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.layout_gender,
                R.layout.layout_goal,
                R.layout.layout_age,
                R.layout.layout_highet,
                R.layout.layout_weight,
                R.layout.layout_diabete,
                R.layout.layout_heartdiseas,
                R.layout.layout_extra};

        mAdapter = new ViewsSliderAdapter();
        binding.viewPager.setAdapter(mAdapter);
        binding.viewPager.registerOnPageChangeCallback(pageChangeCallback);


 binding.btnNext.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         // checking for last page
         // if last page home screen will be launched
         int current = getItem(+1);
         if (current < layouts.length) {
             // move to next screen
             binding.viewPager.setCurrentItem(current);
         } else {
             Toast.makeText(SurveyActivity.this,"Slide Ended", Toast.LENGTH_LONG).show();
             finish();
         }

     }
 });

        // adding bottom dots
        addBottomDots(0);
    }


    /*
     * Adds bottom dots indicator
     * */
    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        binding.layoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            //  dots[i].setTextColor(colorsInactive[currentPage]);
            binding.layoutDots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private int getItem(int i) {
        return binding.viewPager.getCurrentItem() + i;
    }

    /*
     * ViewPager page change listener
     */
    ViewPager2.OnPageChangeCallback pageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                binding.btnNext.setText("Start");
                binding.btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                binding.btnNext.setText("next");
                binding.btnSkip.setVisibility(View.VISIBLE);
            }
        }
    };

    public class ViewsSliderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        public ViewsSliderAdapter() {
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(viewType, parent, false);
            return new SliderViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemViewType(int position) {
            return layouts[position];
        }

        @Override
        public int getItemCount() {
            return layouts.length;
        }

        public class SliderViewHolder extends RecyclerView.ViewHolder {
            public TextView title, year, genre;

            public SliderViewHolder(View view) {
                super(view);
            }
        }
    }
}