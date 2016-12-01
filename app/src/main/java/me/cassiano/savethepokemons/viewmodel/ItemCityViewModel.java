package me.cassiano.savethepokemons.viewmodel;

import android.view.View;

import me.cassiano.savethepokemons.SelectDestinationActivity;
import me.cassiano.savethepokemons.base.IViewModel;
import me.cassiano.savethepokemons.model.City;

/**
 * Created by matheus on 01/12/16.
 */

public class ItemCityViewModel implements IViewModel {

    private final City mCity;

    public ItemCityViewModel(City city) {
        mCity = city;
    }

    @Override
    public void destroy() {

    }

    public City getCity() {
        return mCity;
    }

    public void onOriginCitySelected(View view) {
        SelectDestinationActivity.start(view.getContext(), mCity);
    }

    public void onDestinationCitySelected(View view) {

    }
}
