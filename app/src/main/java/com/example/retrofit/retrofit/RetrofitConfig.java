package com.example.retrofit.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit config;
    private String URL = "https://pokeapi.co/api/v2/";

    public RetrofitConfig() {
        this.config = new Retrofit.Builder()
                                  .baseUrl(this.URL)
                                  .addConverterFactory(JacksonConverterFactory.create())
                                  .build();
    }

    public PokemonAPI getPokemonAPI() {
        return config.create(PokemonAPI.class);
    }
}
