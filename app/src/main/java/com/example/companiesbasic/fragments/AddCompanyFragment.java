package com.example.companiesbasic.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

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
        Editable nameEditable = nameEditText.getText();
        Editable addressEditable = addressEditText.getText();
        boolean isInvalid = false;
        if (TextUtils.isEmpty(nameEditable)) {
            nameEditText.setError("name is required");
            isInvalid = true;
        }
        if (TextUtils.isEmpty(addressEditable)) {
            addressEditText.setError("address required");
            isInvalid = true;
        }
        if (!isInvalid) {
            String address = addressEditable.toString();
            String companyName = nameEditable.toString();
            hideKeyboard(getActivity());
            companiesViewModel.onItemAdd(new Company(companyName, address));
        }

    }


    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void findViews(View view) {
        nameEditText = view.findViewById(R.id.company_name_edit_text);
        addressEditText = view.findViewById(R.id.address_edit_text);
        submitButton = view.findViewById(R.id.submit_button);
    }
}
