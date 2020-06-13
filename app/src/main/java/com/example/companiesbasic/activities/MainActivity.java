package com.example.companiesbasic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.companiesbasic.R;
import com.example.companiesbasic.adapters.CompaniesPagesAdapter;
import com.example.companiesbasic.fragments.CompaniesFragment;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class MainActivity extends AppCompatActivity {

    private CompaniesPagesAdapter companiesPagesAdapter;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        companiesPagesAdapter = new CompaniesPagesAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager = findViewById(R.id.container);
        setUpViewPager();
    }

    private void setUpViewPager() {
        companiesPagesAdapter.addFragment(new CompaniesFragment(), "Companies fragment");
        viewPager.setAdapter(companiesPagesAdapter);
    }
}