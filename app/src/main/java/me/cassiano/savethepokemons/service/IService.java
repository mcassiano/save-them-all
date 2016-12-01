package me.cassiano.savethepokemons.service;

import me.cassiano.savethepokemons.model.Problem;
import me.cassiano.savethepokemons.model.Solution;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by matheus on 01/12/16.
 */

public interface IService {

    @POST("xp")
    Observable<Solution> runSimplex(@Body Problem problem);

}
