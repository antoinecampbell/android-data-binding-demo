package com.antoinecampbell.databindingdemo.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antoinecampbell.databindingdemo.R;
import com.antoinecampbell.databindingdemo.databinding.FragmentSimpleAgeBindingBinding;
import com.antoinecampbell.databindingdemo.model.SimpleAgeBindingUser;

public class SimpleAgeBindingFragment extends Fragment {

    SimpleAgeBindingUser user;

    public static SimpleAgeBindingFragment newInstance() {
        return new SimpleAgeBindingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSimpleAgeBindingBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_simple_age_binding, container, false);

        user = new SimpleAgeBindingUser();
        user.setFirstName(getString(R.string.app_name));
        user.setAge(40);
        binding.setUser(user);

        return binding.getRoot();
    }
}
