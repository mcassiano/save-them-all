package me.cassiano.savethepokemons.viewmodel;

import android.view.View;

import java.util.List;

import me.cassiano.savethepokemons.ResultActivity;
import me.cassiano.savethepokemons.SelectDestinationActivity;
import me.cassiano.savethepokemons.base.IViewModel;
import me.cassiano.savethepokemons.model.City;
import me.cassiano.savethepokemons.model.Problem;

/**
 * Created by matheus on 01/12/16.
 */

public class ItemCityViewModel implements IViewModel {

    private final City mCity;
    private final City mOrigin;

    public ItemCityViewModel(City city, City origin) {
        mCity = city;
        mOrigin = origin;
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
        City destination = mCity;
        City origin = mOrigin;

        if (destination != null && origin != null) {

            List<City> cities = City.getCities();
            cities.remove(origin);
            cities.remove(destination);

            int size = origin.getRestrictionCoefficients().size();

            origin.getRestrictionCoefficients().set(size - 1, 1);
            destination.getRestrictionCoefficients().set(size - 1, -1);

            cities.add(origin);
            cities.add(destination);

            Problem problem = Problem.getDefaultProblem(cities);
            ResultActivity.start(view.getContext(), problem);

        }
    }
}
