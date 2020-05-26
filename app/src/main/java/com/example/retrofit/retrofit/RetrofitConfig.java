package com.example.retrofit.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/*
* Configuramos o retrofir como uma classe.
* */
public class RetrofitConfig {

    //Precisamos de um objeto retrofit, sendo final para não poder instanciar
    private final Retrofit config;
    //URL da api
    private String URL = "https://pokeapi.co/api/v2/";

    //'Construimos' no retrofit, passando a url e um objeto conversor
    public RetrofitConfig() {
        this.config = new Retrofit.Builder()
                                  .baseUrl(this.URL)
                                  .addConverterFactory(JacksonConverterFactory.create())
                                  .build();
    }

    //'Construimos' nosso objeto de API retrofit com a interface criada
    public PokemonAPI getPokemonAPI() {
        return config.create(PokemonAPI.class);
    }
}
