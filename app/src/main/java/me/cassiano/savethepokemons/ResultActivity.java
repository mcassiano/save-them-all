package me.cassiano.savethepokemons;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.parceler.Parcels;

import me.cassiano.savethepokemons.databinding.ActivityResultBinding;
import me.cassiano.savethepokemons.model.Problem;
import me.cassiano.savethepokemons.viewmodel.ResultScreenViewModel;

/**
 * Created by matheus on 01/12/16.
 */

public class ResultActivity extends AppCompatActivity {

    private static final String EXTRA_PROBLEM = "EXTRA_PROBLEM";
    private ActivityResultBinding mBinding;

    public static void start(Context context, Problem problem) {
        Intent intent = new Intent(context, ResultActivity.class);
        intent.putExtra(EXTRA_PROBLEM, Parcels.wrap(problem));
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_result);
        Problem problem = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_PROBLEM));

        mBinding.setViewModel(new ResultScreenViewModel(problem));
    }

    @Override
    protected void onDestroy() {
        mBinding.getViewModel().destroy();
        super.onDestroy();
    }
}
