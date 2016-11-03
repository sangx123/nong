package com.taixia.nong.app.di;

import com.taixia.nong.app.BaseConfig;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author:    sangxiang
 * Version    V 1.0
 * Date:      2016/9/19
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2016/9/19         sangxiang           1.0             1.0
 * Why & What is modified:
 */
@Module
public class ApiModel {
    @Singleton
    @Provides
    Retrofit providerRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BaseConfig.ApiConfig.API_ROOU_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getClient())
                .build();
    }
    private static OkHttpClient getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (BaseConfig.DEBUG)
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        else
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();
    }
}
