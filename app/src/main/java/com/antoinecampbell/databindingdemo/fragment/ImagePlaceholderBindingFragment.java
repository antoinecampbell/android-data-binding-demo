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
import com.antoinecampbell.databindingdemo.databinding.FragmentImagePlaceholderBindingBinding;
import com.antoinecampbell.databindingdemo.model.ImageBindingUser;

public class ImagePlaceholderBindingFragment extends Fragment {

    ImageBindingUser user;

    public static ImagePlaceholderBindingFragment newInstance() {
        return new ImagePlaceholderBindingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentImagePlaceholderBindingBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_image_placeholder_binding, container, false);

        user = new ImageBindingUser();
        user.setFirstName(getString(R.string.app_name));
        user.setImageUrl(null);
        binding.setUser(user);

        return binding.getRoot();
    }
}
