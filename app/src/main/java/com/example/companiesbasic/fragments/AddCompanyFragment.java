package com.example.companiesbasic.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import com.example.companiesbasic.CompaniesViewModel;
import com.example.companiesbasic.R;
import com.example.companiesbasic.model.Company;

public class AddCompanyFragment extends Fragment {

    private AppCompatEditText nameEditText;

    private AppCompatEditText addressEditText;

    private AppCompatButton submitButton;

    private CompaniesViewModel companiesViewModel;

    public AddCompanyFragment(CompaniesViewModel companiesViewModel) {
        this.companiesViewModel = companiesViewModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_company_fragment, container, false);
        findViews(view);
        submitButton.setOnClickListener(v -> onItemAdd());
        return view;
    }

    private void onItemAdd() {
        String companyName = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        companiesViewModel.onItemAdd(new Company(companyName, address));
    }

    private void findViews(View view) {
        nameEditText = view.findViewById(R.id.company_name_edit_text);
        addressEditText = view.findViewById(R.id.address_edit_text);
        submitButton = view.findViewById(R.id.submit_button);
    }
}
