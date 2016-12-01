package me.cassiano.savethepokemons.viewmodel;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import me.cassiano.itemadapter.ItemAdapter;
import me.cassiano.savethepokemons.base.IViewModel;
import me.cassiano.savethepokemons.item.DestinationCityItem;
import me.cassiano.savethepokemons.model.City;

/**
 * Created by matheus on 01/12/16.
 */

public class SelectDestinationScreenViewModel implements IViewModel {

    private final ItemAdapter mAdapter;

    public SelectDestinationScreenViewModel(City origin) {
        mAdapter = new ItemAdapter();

        List<City> cities = City.getCities();
        cities.remove(origin);

        for (City city : cities)
            mAdapter.addItem(new DestinationCityItem(city, origin));
    }

    @Override
    public void destroy() {

    }

    public RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }
}
