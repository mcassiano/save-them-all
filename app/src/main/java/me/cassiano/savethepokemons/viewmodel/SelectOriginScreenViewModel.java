package me.cassiano.savethepokemons.viewmodel;

import android.support.v7.widget.RecyclerView;

import me.cassiano.itemadapter.ItemAdapter;
import me.cassiano.savethepokemons.base.IViewModel;
import me.cassiano.savethepokemons.item.CityItem;
import me.cassiano.savethepokemons.model.City;

/**
 * Created by matheus on 01/12/16.
 */

public class SelectOriginScreenViewModel implements IViewModel {

    private final ItemAdapter mAdapter;

    public SelectOriginScreenViewModel() {
        mAdapter = new ItemAdapter();

        for (City city : City.getCities())
            mAdapter.addItem(new CityItem(city));
    }

    @Override
    public void destroy() {
    }

    public RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }
}
