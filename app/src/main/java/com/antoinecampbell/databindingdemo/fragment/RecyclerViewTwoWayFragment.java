package com.antoinecampbell.databindingdemo.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antoinecampbell.databindingdemo.BR;
import com.antoinecampbell.databindingdemo.R;
import com.antoinecampbell.databindingdemo.databinding.FragmentSimpleRecyclerBindingTwoWayBinding;
import com.antoinecampbell.databindingdemo.model.SimpleBindingTwoWayUser;

public class RecyclerViewTwoWayFragment extends Fragment {

    private RecyclerView recyclerView;
    private FragmentSimpleRecyclerBindingTwoWayBinding binding;

    public static RecyclerViewTwoWayFragment newInstance() {
        return new RecyclerViewTwoWayFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_simple_recycler_binding_two_way, container, false);
        binding.edittext.setText(getString(R.string.app_name));

        SimpleBindingTwoWayUser user = new SimpleBindingTwoWayUser();
        user.setName(getString(R.string.app_name));
        binding.setUser(user);
        recyclerView = (RecyclerView) binding.getRoot().findViewById(R.id.recyclerview);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

        final int count = 50;
        final SimpleBindingTwoWayUser user = binding.getUser();

        RecyclerView.Adapter<BindingViewHolder> adapter = new RecyclerView.Adapter<BindingViewHolder>() {
            @Override
            public BindingViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                ViewDataBinding binding = DataBindingUtil
                        .inflate(inflater, R.layout.listitem_recycler_two_way, parent, false);

                return new BindingViewHolder(binding.getRoot());
            }

            @Override
            public void onBindViewHolder(BindingViewHolder holder, int position) {
                holder.getBinding().setVariable(BR.user, user);
                holder.getBinding().executePendingBindings();
            }

            @Override
            public int getItemCount() {
                return count;
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private class BindingViewHolder extends RecyclerView.ViewHolder {

        public BindingViewHolder(View itemView) {
            super(itemView);
        }

        public ViewDataBinding getBinding() {
            return DataBindingUtil.getBinding(itemView);
        }
    }
}
