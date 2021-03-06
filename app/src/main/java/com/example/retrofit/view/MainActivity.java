package com.example.retrofit.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.retrofit.R;
import com.example.retrofit.databinding.ActivityMainBinding;
import com.example.retrofit.model.Pokemon;
import com.example.retrofit.retrofit.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
* Primeiramente para usar o retrofit precisamos importar duas bibliotecas no gradle,
* retrofit
*   implementation 'com.squareup.retrofit2:retrofit:2.9.0'
* e o jackson (conversor e serializador para json)
*   implementation 'com.squareup.retrofit2:converter-jackson:2.9.0'
* */
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bindig;
    //Retrofit config
    RetrofitConfig retrofitConfig;
    //'Chamada' para a requisição
    Call<Pokemon> request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.bindig = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.bindig.getRoot());

        //Starto meu objeto retrofit
        this.retrofitConfig = new RetrofitConfig();

        this.bindig.btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(bindig.edtId.getText().toString());
                //Seto o endpoit utilizado
                request = retrofitConfig.getPokemonAPI().getPokemonById(id);
                //Faço minha requisição
                request.enqueue(new Callback<Pokemon>() {
                    //Me retorna dois métodos, onresponse e onfailure
                    @Override
                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                        Pokemon pokemon = response.body();
                        bindig.textId.setText(String.valueOf(pokemon.getId()));
                        bindig.textName.setText(pokemon.getName());
                        bindig.textAltura.setText(String.valueOf(pokemon.getHeight()));
                        bindig.textPeso.setText(String.valueOf(pokemon.getWeight()));
                    }

                    @Override
                    public void onFailure(Call<Pokemon> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Fail to get POKEMON", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
