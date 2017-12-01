package com.jeench.shoplist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.jeench.shoplist.api.SearchItems;
import com.jeench.shoplist.data.Item;
import com.jeench.shoplist.data.ServiceResponse;

import java.util.Collections;
import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Radik on 01.12.2017.
 */

public class GoodsListActivityViewModel extends ViewModel {
    final private MutableLiveData<List<Item>> items = new MutableLiveData<>();
    private Disposable subscribe;

    LiveData<List<Item>> get() {
        if (items.getValue() == null || items.getValue().isEmpty()) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.jeench.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            subscribe = retrofit.create(SearchItems.class)
                    .searchItems()
                    .subscribeOn(Schedulers.single())
                    .onErrorReturn(throwable -> {
                        ServiceResponse response = new ServiceResponse();
                        response.message = Collections.emptyList();
                        return response;
                    })
                    .subscribe(response -> items.postValue(response.message));
        }

        return items;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        subscribe.dispose();
    }
}
