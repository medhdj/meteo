package com.medhdj.data.repository.datasource.remote;

import com.medhdj.data.BuildConfig;
import com.medhdj.data.entity.ForecastEntity;

import java.io.IOException;

import io.reactivex.Observable;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by medhdj on 22/01/2018.
 */

public interface RestApi {

    String OPEN_WEATHER_URL = "http://api.openweathermap.org/data/2.5/";

    @GET("weather")
    Observable<ForecastEntity> forcastByCoordinates(@Query("lat") double lat, @Query("lon") double lon);

    final class Factory {
        private Factory() {
        }


        public static RestApi createService() {
            OkHttpClient.Builder httpClientBuilder =
                    new OkHttpClient.Builder();
            httpClientBuilder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    HttpUrl originalHttpUrl = original.url();

                    HttpUrl url = originalHttpUrl.newBuilder()
                            .addQueryParameter("appid", BuildConfig.OPEN_WEATHER_MAP_API_KEY)
                            .addQueryParameter("units", "metric")
                            .addQueryParameter("lang", "fr")
                            .build();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            .url(url);

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });

            httpClientBuilder.addInterceptor(new HttpLoggingInterceptor()
                    .setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY :
                            HttpLoggingInterceptor.Level.NONE));

            Retrofit retrofit = new Retrofit.Builder()
                    .client(httpClientBuilder.build())
                    .baseUrl(RestApi.OPEN_WEATHER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            return retrofit.create(RestApi.class);
        }
    }
}
