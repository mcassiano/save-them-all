package me.cassiano.savethepokemons.model;

/**
 * Created by matheus on 01/12/16.
 */

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel(Parcel.Serialization.BEAN)
public class Restriction {

    @SerializedName("coefficients")
    private List<Integer> coefficients;

    @SerializedName("type")
    private String type;

    @SerializedName("value")
    private Integer value;

    public List<Integer> getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(List<Integer> coefficients) {
        this.coefficients = coefficients;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}