package me.cassiano.savethepokemons;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import me.cassiano.savethepokemons.databinding.ActivitySelectOriginBinding;
import me.cassiano.savethepokemons.viewmodel.SelectOriginScreenViewModel;

/**
 * Created by matheus on 01/12/16.
 */

public class SelectOriginActivity extends AppCompatActivity {

    private ActivitySelectOriginBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_select_origin);
        mBinding.setViewModel(new SelectOriginScreenViewModel());
    }

    @Override
    protected void onDestroy() {
        mBinding.getViewModel().destroy();
        super.onDestroy();
    }
}
