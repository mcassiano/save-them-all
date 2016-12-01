package me.cassiano.savethepokemons.item;

import me.cassiano.itemadapter.Item;
import me.cassiano.savethepokemons.R;
import me.cassiano.savethepokemons.databinding.ItemCityBinding;
import me.cassiano.savethepokemons.model.City;
import me.cassiano.savethepokemons.viewmodel.ItemCityViewModel;

/**
 * Created by matheus on 01/12/16.
 */

public class CityItem implements Item<ItemCityBinding> {

    private final ItemCityViewModel mViewModel;

    public CityItem(City city) {
        mViewModel = new ItemCityViewModel(city);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.item_city;
    }

    @Override
    public void bind(ItemCityBinding itemCityBinding) {
        itemCityBinding.setViewModel(mViewModel);
    }

    @Override
    public void destroy() {

    }
}
