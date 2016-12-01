package me.cassiano.savethepokemons;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.parceler.Parcels;

import me.cassiano.savethepokemons.databinding.ActivitySelectDestinationBinding;
import me.cassiano.savethepokemons.model.City;
import me.cassiano.savethepokemons.viewmodel.SelectDestinationScreenViewModel;

/**
 * Created by matheus on 01/12/16.
 */

public class SelectDestinationActivity extends AppCompatActivity {

    private static final String EXTRA_CITY = "EXTRA_CITY";

    private ActivitySelectDestinationBinding mBinding;

    public static void start(Context context, City origin) {
        Intent intent = new Intent(context, SelectDestinationActivity.class);
        intent.putExtra(EXTRA_CITY, Parcels.wrap(origin));

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_select_destination);

        City origin = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_CITY));
        mBinding.setViewModel(new SelectDestinationScreenViewModel(origin));
    }

    @Override
    protected void onDestroy() {
        mBinding.getViewModel().destroy();
        super.onDestroy();
    }
}
