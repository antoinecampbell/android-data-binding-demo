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
import com.antoinecampbell.databindingdemo.model.SimpleUser;

public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerView;

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_recycler_binding, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        int count = 50;
        final SimpleUser[] users = new SimpleUser[count];
        for (int i = 0; i < users.length; i++) {
            users[i] = new SimpleUser(getString(R.string.app_name) + i);
        }

        RecyclerView.Adapter<BindingViewHolder> adapter = new RecyclerView.Adapter<BindingViewHolder>() {
            @Override
            public BindingViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                ViewDataBinding binding = DataBindingUtil
                        .inflate(inflater, R.layout.listitem_recycler, parent, false);

                return new BindingViewHolder(binding.getRoot());
            }

            @Override
            public void onBindViewHolder(BindingViewHolder holder, int position) {
                SimpleUser user = users[position];
                holder.getBinding().setVariable(BR.user, user);
                holder.getBinding().executePendingBindings();
            }

            @Override
            public int getItemCount() {
                return users.length;
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
