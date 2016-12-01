package me.cassiano.savethepokemons.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by matheus on 01/12/16.
 */

public class Solution {

    @SerializedName("status")
    private String status;
    @SerializedName("values")
    private List<Integer> values;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    public boolean isThereAPath() {
        return !(values.get(0) == 0);
    }

    public String getMaxFlow() {
        return String.valueOf(values.get(0));
    }

    public String getAB() {
        return String.valueOf(values.get(1));
    }

    public String getBC() {
        return String.valueOf(values.get(2));
    }

    public String getCD() {
        return String.valueOf(values.get(3));
    }

    public String getDI() {
        return String.valueOf(values.get(4));
    }

    public String getIF() {
        return String.valueOf(values.get(5));
    }

    public String getFG() {
        return String.valueOf(values.get(6));
    }

    public String getFH() {
        return String.valueOf(values.get(7));
    }

    public String getHG() {
        return String.valueOf(values.get(8));
    }

    public String getHJ() {
        return String.valueOf(values.get(9));
    }

    public String getIJ() {
        return String.valueOf(values.get(10));
    }

    public String getGJ() {
        return String.valueOf(values.get(11));
    }

    public String getAE() {
        return String.valueOf(values.get(12));
    }

    public String getEG() {
        return String.valueOf(values.get(13));
    }

    public String getEJ() {
        return String.valueOf(values.get(14));
    }
}
