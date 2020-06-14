package com.example.companiesbasic.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.companiesbasic.CompaniesViewModel;
import com.example.companiesbasic.R;
import com.example.companiesbasic.adapters.CompaniesAdapter;

import io.reactivex.rxjava3.disposables.Disposable;

public class CompaniesFragment extends Fragment {

    private RecyclerView recyclerCompanies;

    private CompaniesAdapter companiesAdapter;

    private CompaniesViewModel companiesViewModel;

    private @io.reactivex.rxjava3.annotations.NonNull Disposable disposable = Disposable.disposed();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        companiesViewModel = new CompaniesViewModel();
        View view = inflater.inflate(R.layout.companies_fragment, container, false);
        initRecyclerCompanies(view);
        disposable = companiesViewModel.getCompanies()
                .subscribe(companies -> companiesAdapter.setCompanies(companies));
        return view;
    }

    private void initRecyclerCompanies(View view) {
        recyclerCompanies = view.findViewById(R.id.recycler_companies);
        Context context = getContext();
        companiesAdapter = new CompaniesAdapter(context);
        recyclerCompanies.setHasFixedSize(true);
        recyclerCompanies.setLayoutManager(new LinearLayoutManager(context));
        recyclerCompanies.setAdapter(companiesAdapter);
    }


    @Override
    public void onDestroyView() {
        disposable.dispose();
        super.onDestroyView();
    }
}
