package com.jeench.shoplist.api;

import com.jeench.shoplist.data.ServiceResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Radik on 30.11.2017.
 */

public interface SearchItems {
    @GET("v1/search-items")
    Observable<ServiceResponse> searchItems();
}
