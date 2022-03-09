package com.avisys.allinone.firestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.avisys.allinone.R;
import com.avisys.allinone.databinding.ActivityMyFirestoreBinding;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;

public class MyFirestoreActivity extends AppCompatActivity {
    private ActivityMyFirestoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_my_firestore);
        binding.fName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean isFocused) {
                if (isFocused&&binding.fName.getText().toString().isEmpty())
                    binding.textField.setBoxStrokeColor(ContextCompat.getColor(
                            MyFirestoreActivity.this,R.color.black));
                binding.fName.addTextChangedListener(new MyTextWatcher());
                binding.textField.setHintTextColor(ColorStateList.valueOf(
                        ContextCompat.getColor(MyFirestoreActivity.this,R.color.black)));
            }
        });
    }

    // inner class
    public class MyTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String fName = binding.fName.getText().toString();
            if(fName.length()>7){
                hideCustomDrawable();
            }else{
                if(fName.length()==7){
                    setCustomDrawable();
                }else{
                    if(fName.length()==0){
                        binding.textField.setBoxStrokeColor(ContextCompat.getColor(
                                MyFirestoreActivity.this,R.color.black));
                        binding.textField.setHelperText("");
                        binding.textField.setHintTextColor(ColorStateList.valueOf(
                                ContextCompat.getColor(MyFirestoreActivity.this,R.color.black)));
                    }else{
                        hideCustomDrawable();
                    }
                }
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }

        private void setCustomDrawable(){
            binding.textField.setEndIconMode(TextInputLayout.END_ICON_CUSTOM);
//            binding.textField.setEndIconTintList(new ColorStateList());
            binding.textField.setEndIconDrawable(
                    ContextCompat.getDrawable(MyFirestoreActivity.this,
                            R.drawable.checked));
            binding.textField.setHelperText("");
            binding.textField.setHintTextColor(ColorStateList.valueOf(
                    ContextCompat.getColor(MyFirestoreActivity.this,R.color.success_color)));
            binding.textField.setBoxStrokeColor(ContextCompat.getColor(MyFirestoreActivity.this
                    ,R.color.success_color));
        }

        private void hideCustomDrawable(){
            binding.textField.setBoxStrokeColor(ContextCompat.getColor(MyFirestoreActivity.this
                    ,R.color.error_color));
            binding.textField.setHintTextColor(ColorStateList.valueOf(
                    ContextCompat.getColor(MyFirestoreActivity.this,R.color.error_color)));
            binding.textField.setHelperText("Your name length must max 7 character");
            binding.textField.setEndIconMode(TextInputLayout.END_ICON_NONE);
        }
    }
}