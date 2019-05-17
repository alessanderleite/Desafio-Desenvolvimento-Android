package br.com.alessanderleite.desafioandroidgds.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import br.com.alessanderleite.desafioandroidgds.adapters.MovimentoAdapter;
import br.com.alessanderleite.desafioandroidgds.R;
import br.com.alessanderleite.desafioandroidgds.api.Client;
import br.com.alessanderleite.desafioandroidgds.api.Service;
import br.com.alessanderleite.desafioandroidgds.model.Empresa;
import br.com.alessanderleite.desafioandroidgds.model.Movimento;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovimentoActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MovimentoAdapter mAdapter;
    private List<Movimento> movimentoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimento);

        init();
    }

    private void init() {
        Service service = Client.getRetrofitInstance().create(Service.class);
        Call<Empresa> call = service.getListCall();
        call.enqueue(new Callback<Empresa>() {
            @Override
            public void onResponse(Call<Empresa> call, Response<Empresa> response) {
                movimentoList = response.body().getMovimentos();
                getRecyclerViewMovimento();
            }

            @Override
            public void onFailure(Call<Empresa> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
                Toast.makeText(MovimentoActivity.this, "Ocorreu um erro", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getRecyclerViewMovimento() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_mov);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MovimentoAdapter(movimentoList, this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
