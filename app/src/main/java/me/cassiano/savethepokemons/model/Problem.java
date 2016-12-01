package me.cassiano.savethepokemons.model;


import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Parcel(Parcel.Serialization.BEAN)
public class Problem {

    @SerializedName("function")
    private Function function;
    @SerializedName("restrictions")
    private List<Restriction> restrictions;

    public static Problem getDefaultProblem(List<City> cities) {

        Problem problem = new Problem();

        // the last 1 is saying "max the new vertex created from origin -> destination"
        List<Integer> functionCoefficients = Arrays.asList(
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);

        Function function = new Function();
        function.setOperation("MAX");
        function.setCoefficients(functionCoefficients);

        List<Integer> maxValues = Arrays.asList(250, 200, 300, 200, 300, 200, 100,
                130, 200, 150, 170, 200, 150, 120, 0);

        problem.setFunction(function);


        List<Restriction> restrictions = new ArrayList<>();

        /* setting regular path constraints */

        for (City city : cities) {
            Restriction restriction = new Restriction();
            restriction.setType("EQ");
            restriction.setValue(0);
            restriction.setCoefficients(city.getRestrictionCoefficients());

            restrictions.add(restriction);
        }


        /* setting edge weights */
        for (int i = 0; i < maxValues.size(); i++) {

            Restriction restriction = new Restriction();

            Integer[] coefficients = new Integer[maxValues.size()];
            Arrays.fill(coefficients, 0);
            coefficients[i] = 1;

            restriction.setCoefficients(Arrays.asList(coefficients));

            if (i + 1 == maxValues.size())
                restriction.setType("GT");
            else
                restriction.setType("LT");

            restriction.setValue(maxValues.get(i));

            restrictions.add(restriction);
        }

        problem.setRestrictions(restrictions);


        return problem;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public List<Restriction> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(List<Restriction> restrictions) {
        this.restrictions = restrictions;
    }

}