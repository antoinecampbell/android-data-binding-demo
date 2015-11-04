package com.antoinecampbell.databindingdemo.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antoinecampbell.databindingdemo.R;
import com.antoinecampbell.databindingdemo.databinding.FragmentImageBindingBinding;
import com.antoinecampbell.databindingdemo.model.ImageBindingUser;

public class ImageBindingFragment extends Fragment {

    ImageBindingUser user;

    public static ImageBindingFragment newInstance() {
        return new ImageBindingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentImageBindingBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_image_binding, container, false);

        user = new ImageBindingUser();
        user.setFirstName(getString(R.string.app_name));
        user.setImageUrl("http://fillmurray.com/400/400");
        binding.setUser(user);

        return binding.getRoot();
    }
}
