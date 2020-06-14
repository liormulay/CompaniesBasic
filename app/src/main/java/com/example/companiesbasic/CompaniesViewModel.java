package com.example.companiesbasic;

import androidx.lifecycle.ViewModel;

import com.example.companiesbasic.model.CompaniesHolder;
import com.example.companiesbasic.model.Company;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class CompaniesViewModel extends ViewModel {

    private CompaniesHolder companiesHolder = new CompaniesHolder();

    private BehaviorSubject<List<Company>> companiesBehaviorSubject = BehaviorSubject.create();

    private BehaviorSubject<Integer> currentItem = BehaviorSubject.create();

    private BehaviorSubject<Company> addItemBehaviorSubject = BehaviorSubject.create();

    public CompaniesViewModel() {
        companiesBehaviorSubject.onNext(companiesHolder.getCompanies());
    }

    public Observable<List<Company>> getCompanies() {
        return companiesBehaviorSubject.hide();
    }

    public Observable<Integer> getCurrentItem(){
        return currentItem.hide();
    }

    public Observable<Company> getAddItem(){
        return addItemBehaviorSubject.hide();
    }

    public void onItemAddChoose() {
        currentItem.onNext(1);
    }

    public void onItemAdd(Company company) {
        addItemBehaviorSubject.onNext(company);
        currentItem.onNext(0);
    }
}
