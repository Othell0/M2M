package com.cs.mm.retrofit;

import com.cs.mm.model.GanHuo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by exbbefl on 6/12/2016.
 */
public interface GankService {
    @GET("api/data/{type}/{count}/{page}")
    Observable<GanHuo> getGanHuo(
            @Path("type") String type,
            @Path("count") int count,
            @Path("page") int page
    );
}
