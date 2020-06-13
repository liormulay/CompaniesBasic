package com.example.companiesbasic.view_holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.companiesbasic.R;
import com.example.companiesbasic.model.Company;

public class CompanyViewHolder extends RecyclerView.ViewHolder {

    private AppCompatTextView companyNameTextView;
    private AppCompatTextView addressTextView;

    public CompanyViewHolder(@NonNull View itemView) {
        super(itemView);
        companyNameTextView = itemView.findViewById(R.id.company_name_text_view);
        addressTextView = itemView.findViewById(R.id.address_text_view);
    }

    public void bindData(Company company){
        companyNameTextView.setText(company.getName());
        addressTextView.setText(company.getAddress());
    }
}
