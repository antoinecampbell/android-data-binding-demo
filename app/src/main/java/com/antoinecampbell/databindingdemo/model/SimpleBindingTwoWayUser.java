package com.antoinecampbell.databindingdemo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.antoinecampbell.databindingdemo.BR;

public class SimpleBindingTwoWayUser extends BaseObservable {


    private String name;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }


}
