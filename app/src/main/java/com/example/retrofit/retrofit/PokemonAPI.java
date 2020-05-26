package com.example.retrofit.retrofit;

import com.example.retrofit.model.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/*
* Criamos uma interface que terá os endpoints
* */
public interface PokemonAPI {
    @GET("pokemon/{id}")
    /*
    * Utilizamos o tipo call, que é uma invocação do retrofit que envia e retorna a response do webserver
    * */
    Call<Pokemon> getPokemonById(@Path("id") int id);
}
