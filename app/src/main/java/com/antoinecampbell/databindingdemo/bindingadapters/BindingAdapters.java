package com.antoinecampbell.databindingdemo.bindingadapters;

import android.databinding.BindingAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.antoinecampbell.databindingdemo.model.SimpleBindingTwoWayUser;

@SuppressWarnings("unused")
public class BindingAdapters {

    @BindingAdapter("addTextChangedListener")
    public static void nameChanged(EditText editText, final SimpleBindingTwoWayUser user) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!user.getName().equals(s.toString())) {
                    user.setName(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
