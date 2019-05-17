package br.com.alessanderleite.desafioandroidgds.api;

import br.com.alessanderleite.desafioandroidgds.model.Empresa;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("nicolau-kerpen?querycard=15420003466&pin=YMON5BHOQM&qcapi")
    Call<Empresa> getListCall();
}
