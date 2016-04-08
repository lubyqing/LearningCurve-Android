package com.arthas.learningcurve;




import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by garrett on 3/17/16.
 */
public class RetrofitBuilderFactory {

    public static Builder create() {
        return new Builder()
               .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
               .addConverterFactory(FastJsonConverterFactory.create())
               .baseUrl("http://mobapi.nong12.com");
    }
}