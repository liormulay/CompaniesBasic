package com.example.companiesbasic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.companiesbasic.R;
import com.example.companiesbasic.model.Company;
import com.example.companiesbasic.view_holders.CompanyViewHolder;

import java.util.List;

public class CompaniesAdapter extends RecyclerView.Adapter<CompanyViewHolder> {

    private Context context;

    private List<Company> companies;

    public CompaniesAdapter(Context context) {
        this.context = context;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @NonNull
    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CompanyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_company, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyViewHolder holder, int position) {
        Company company = companies.get(position);
        holder.bindData(company);
    }

    @Override
    public int getItemCount() {
        return companies == null ? 0 : companies.size();
    }
}
