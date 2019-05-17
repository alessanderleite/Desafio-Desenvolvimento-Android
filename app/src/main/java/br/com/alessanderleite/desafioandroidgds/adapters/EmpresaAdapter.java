package br.com.alessanderleite.desafioandroidgds.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.com.alessanderleite.desafioandroidgds.R;
import br.com.alessanderleite.desafioandroidgds.model.Empresa;
import br.com.alessanderleite.desafioandroidgds.ui.MovimentoActivity;

public class EmpresaAdapter extends RecyclerView.Adapter<EmpresaAdapter.ViewHolder> {

    private List<Empresa> empresaList;
    private Context context;

    public EmpresaAdapter(List<Empresa> empresaList, Context context) {
        this.empresaList = empresaList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_empresa, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Empresa empresa = empresaList.get(i);

        holder.mEmpresa.setText(empresa.getNomeEmpresa());
        holder.mCliente.setText(empresa.getNome());
        holder.mSaldo.setText(empresa.getSaldo());
    }

    @Override
    public int getItemCount() {
        return empresaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mEmpresa;
        private TextView mCliente;
        private TextView mSaldo;
        private Button mBtnMovimentacao;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mEmpresa = (TextView) itemView.findViewById(R.id.empresa);
            mCliente = (TextView) itemView.findViewById(R.id.cliente);
            mSaldo = (TextView) itemView.findViewById(R.id.saldo);
            mBtnMovimentacao = (Button) itemView.findViewById(R.id.btn_movimentacao);

            mBtnMovimentacao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MovimentoActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
