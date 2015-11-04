package com.antoinecampbell.databindingdemo.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antoinecampbell.databindingdemo.R;
import com.antoinecampbell.databindingdemo.databinding.FragmentSimpleNullBindingBinding;
import com.antoinecampbell.databindingdemo.model.SimpleAgeBindingUser;

public class SimpleNullBindingFragment extends Fragment {

    SimpleAgeBindingUser user;

    public static SimpleNullBindingFragment newInstance() {
        return new SimpleNullBindingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSimpleNullBindingBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_simple_null_binding, container, false);

        user = new SimpleAgeBindingUser();
        user.setFirstName(getString(R.string.app_name));
        binding.setUser(user);

        return binding.getRoot();
    }
}
