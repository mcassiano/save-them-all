package me.cassiano.savethepokemons.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import java.util.concurrent.TimeUnit;

import me.cassiano.savethepokemons.App;
import me.cassiano.savethepokemons.base.IViewModel;
import me.cassiano.savethepokemons.model.Problem;
import me.cassiano.savethepokemons.model.Solution;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by matheus on 01/12/16.
 */

public class ResultScreenViewModel implements IViewModel {

    private final ObservableBoolean mIsLoading = new ObservableBoolean();
    private final Problem mProblem;
    private final ObservableField<Solution> mSolution = new ObservableField<>();

    private Subscription mSubscription;

    public ResultScreenViewModel(Problem problem) {
        mProblem = problem;
        loadSolution();
    }

    @Override
    public void destroy() {

        if (mSubscription != null)
            mSubscription.unsubscribe();

    }

    public ObservableBoolean isLoading() {
        return mIsLoading;
    }

    public ObservableField<Solution> getSolution() {
        return mSolution;
    }

    private void loadSolution() {

        if (mSubscription != null)
            mSubscription.unsubscribe();

        mIsLoading.set(true);

        mSubscription = App
                .getService()
                .runSimplex(mProblem)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver());

    }

    private Observer<Solution> getObserver() {
        return new Observer<Solution>() {
            @Override
            public void onCompleted() {
                mIsLoading.set(false);
            }

            @Override
            public void onError(Throwable e) {
                mIsLoading.set(false);
            }

            @Override
            public void onNext(Solution solution) {
                mSolution.set(solution);
            }
        };
    }
}
