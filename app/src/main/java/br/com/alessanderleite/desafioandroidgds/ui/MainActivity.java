package br.com.alessanderleite.desafioandroidgds.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.alessanderleite.desafioandroidgds.adapters.EmpresaAdapter;
import br.com.alessanderleite.desafioandroidgds.R;
import br.com.alessanderleite.desafioandroidgds.api.Client;
import br.com.alessanderleite.desafioandroidgds.api.Service;
import br.com.alessanderleite.desafioandroidgds.model.Empresa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private EmpresaAdapter mEmpresaAdapter;
    private List<Empresa> empresaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empresaList = new ArrayList<>();

        init();
    }

    private void init() {
        Service service = Client.getRetrofitInstance().create(Service.class);
        Call<Empresa> call = service.getListCall();
        call.enqueue(new Callback<Empresa>() {
            @Override
            public void onResponse(Call<Empresa> call, Response<Empresa> response) {
                response.body();
                Empresa empresa = new Empresa();

                String nomeEmpresa = response.body().getNomeEmpresa();
                String nomeCliente = response.body().getNome();
                String saldo = response.body().getSaldo();
                empresa.setNomeEmpresa(nomeEmpresa);
                empresa.setNome(nomeCliente);
                empresa.setSaldo(saldo);
                empresaList.add(empresa);

                getRecyclerView();
            }

            @Override
            public void onFailure(Call<Empresa> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
                Toast.makeText(MainActivity.this, "Ocorreu um erro" , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mEmpresaAdapter = new EmpresaAdapter(empresaList, this);
        mRecyclerView.setAdapter(mEmpresaAdapter);
    }
}
