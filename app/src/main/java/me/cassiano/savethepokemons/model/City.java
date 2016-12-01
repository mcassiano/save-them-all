package me.cassiano.savethepokemons.model;

import android.support.annotation.DrawableRes;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

import java.util.ArrayList;
import java.util.Arrays;
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

    private List<Integer> restrictionCoefficients;


    @ParcelConstructor
    public City(String name, int picture, List<Integer> restrictionCoefficients) {
        this.name = name;
        this.picture = picture;
        this.restrictionCoefficients = restrictionCoefficients;
    }

    public static List<City> getCities() {

        List<City> cities = new ArrayList<>();

        List<Integer> pewter = Arrays.asList(-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0);
        List<Integer> viridian = Arrays.asList(1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> pallet = Arrays.asList(0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> cinnibar = Arrays.asList(0, 0, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> fuschia = Arrays.asList(0, 0, 0, 1, -1, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0);
        List<Integer> celadon = Arrays.asList(0, 0, 0, 0, 1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> saffron = Arrays.asList(0, 0, 0, 0, 0, 1, 0, 1, 0, 0, -1, 0, 1, 0, 0);
        List<Integer> cerulean = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -1, -1, 0);
        List<Integer> vermilion = Arrays.asList(0, 0, 0, 0, 0, 0, 1, -1, -1, 0, 0, 1, -1, -1, 0);
        List<Integer> lavender = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, -1);

        cities.add(new City("Celadon", R.drawable.celadon, celadon));
        cities.add(new City("Cerulean", R.drawable.cerulean, cerulean));
        cities.add(new City("Cinnabar", R.drawable.cinnabar, cinnibar));
        cities.add(new City("Fuschia", R.drawable.fuchsia, fuschia));
        cities.add(new City("Lavender", R.drawable.lavender, lavender));
        cities.add(new City("Pallet", R.drawable.pallet, pallet));
        cities.add(new City("Pewter", R.drawable.pewter, pewter));
        cities.add(new City("Saffron", R.drawable.saffron, saffron));
        cities.add(new City("Vermilion", R.drawable.vermilion, vermilion));
        cities.add(new City("Viridian", R.drawable.viridian, viridian));

        return cities;
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

    public List<Integer> getRestrictionCoefficients() {
        return restrictionCoefficients;
    }

}
