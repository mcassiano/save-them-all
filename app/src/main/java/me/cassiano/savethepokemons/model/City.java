package me.cassiano.savethepokemons.model;

import android.support.annotation.DrawableRes;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

import me.cassiano.savethepokemons.R;

/**
 * Created by matheus on 01/12/16.
 */

@Parcel(Parcel.Serialization.BEAN)
public class City {


    @SerializedName("name")
    private String name;
    @SerializedName("picture")
    @DrawableRes
    private int picture;

    public City() {
    }

    public City(String name, int picture) {
        this.name = name;
        this.picture = picture;
    }

    public static List<City> getCities() {

        List<City> cities = new ArrayList<>();

        cities.add(new City("Celadon", R.drawable.celadon));
        cities.add(new City("Cerulean", R.drawable.cerulean));
        cities.add(new City("Fuchsia", R.drawable.fuchsia));
        cities.add(new City("Lavender", R.drawable.lavender));
        cities.add(new City("Pewter", R.drawable.pewter));
        cities.add(new City("Saffron", R.drawable.saffron));
        cities.add(new City("Vermilion", R.drawable.vermilion));
        cities.add(new City("Viridian", R.drawable.viridian));

        return cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        return name.equals(city.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
