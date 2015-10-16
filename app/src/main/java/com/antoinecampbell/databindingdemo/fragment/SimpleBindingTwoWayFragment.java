package com.antoinecampbell.databindingdemo.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antoinecampbell.databindingdemo.R;
import com.antoinecampbell.databindingdemo.databinding.FragmentSimpleBindingTwoWayBinding;
import com.antoinecampbell.databindingdemo.model.SimpleBindingTwoWayUser;

public class SimpleBindingTwoWayFragment extends Fragment {

    SimpleBindingTwoWayUser user;

    public static SimpleBindingTwoWayFragment newInstance() {
        return new SimpleBindingTwoWayFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSimpleBindingTwoWayBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_simple_binding_two_way, container, false);

        user = new SimpleBindingTwoWayUser();
        binding.setUser(user);
        user.setName(getString(R.string.app_name));

        // Set EditText to user first name, notice the EditText was retrieved from the binding,
        // since it has an id set in the XML layout
        binding.edittext.setText(user.getName());

        return binding.getRoot();
    }
}
