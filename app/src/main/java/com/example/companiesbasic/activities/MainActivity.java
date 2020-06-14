package com.example.companiesbasic.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.companiesbasic.CompaniesViewModel;
import com.example.companiesbasic.R;
import com.example.companiesbasic.adapters.CompaniesPagesAdapter;
import com.example.companiesbasic.fragments.AddCompanyFragment;
import com.example.companiesbasic.fragments.CompaniesFragment;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class MainActivity extends AppCompatActivity {

    private CompaniesPagesAdapter companiesPagesAdapter;

    private ViewPager viewPager;

    private CompaniesFragment companiesFragment;

    private AddCompanyFragment addCompanyFragment;

    private CompaniesViewModel companiesViewModel = new CompaniesViewModel();

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        companiesFragment = new CompaniesFragment(companiesViewModel);
        addCompanyFragment = new AddCompanyFragment(companiesViewModel);
        companiesPagesAdapter = new CompaniesPagesAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager = findViewById(R.id.container);
        setUpViewPager();
        compositeDisposable.add(companiesViewModel.getCurrentItem()
                .subscribe(currentItem -> viewPager.setCurrentItem(currentItem)));
    }

    private void setUpViewPager() {
        companiesPagesAdapter.addFragment(companiesFragment, "Companies fragment");
        companiesPagesAdapter.addFragment(addCompanyFragment, "Add Company fragment");
        viewPager.setAdapter(companiesPagesAdapter);
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}