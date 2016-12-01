package me.cassiano.savethepokemons;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by matheus on 01/12/16.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable
                .just(1)
                .delay(1, TimeUnit.SECONDS)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Intent intent = new Intent(SplashActivity.this,
                                SelectOriginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }
}
