package com.example.companiesbasic.model;

import java.util.ArrayList;
import java.util.List;

public class CompaniesHolder {

    private final List<Company> companies = new ArrayList<>();

    public CompaniesHolder() {
        companies.add(new Company("Check Point","Tel Aviv"));
        companies.add(new Company("Google","Tel Aviv"));
        companies.add(new Company("SuperUp","Ashdod"));
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
