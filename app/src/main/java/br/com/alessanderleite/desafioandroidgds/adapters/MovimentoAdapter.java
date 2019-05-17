package br.com.alessanderleite.desafioandroidgds.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.alessanderleite.desafioandroidgds.R;
import br.com.alessanderleite.desafioandroidgds.model.Movimento;

public class MovimentoAdapter extends RecyclerView.Adapter<MovimentoAdapter.ViewHolder> {

    private List<Movimento> movimentoList;
    private Context context;

    public MovimentoAdapter(List<Movimento> movimentoList, Context context) {
        this.movimentoList = movimentoList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_movimento, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Movimento movimento = movimentoList.get(i);

        holder.mNumId.setText(movimento.getNumId());
        holder.mCodProduto.setText(movimento.getCodProduto());
        holder.mQuantidade.setText(movimento.getQuantidade());
        holder.mVlTotal.setText(movimento.getVlTotal());
        holder.mDtOcorrencia.setText(movimento.getDtOcorrencia());
        holder.mOperacaoDC.setText(movimento.getOperacaoDC());
        holder.mDescricao.setText(movimento.getDescricao());
        holder.mCancelado.setText(movimento.getCancelado());

    }

    @Override
    public int getItemCount() {
        return movimentoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mNumId;
        private TextView mCodProduto;
        private TextView mQuantidade;
        private TextView mVlTotal;
        private TextView mDtOcorrencia;
        private TextView mOperacaoDC;
        private TextView mDescricao;
        private TextView mCancelado;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mNumId = (TextView) itemView.findViewById(R.id.numId);
            mCodProduto = (TextView) itemView.findViewById(R.id.codProduto);
            mQuantidade = (TextView) itemView.findViewById(R.id.quantidade);
            mVlTotal = (TextView) itemView.findViewById(R.id.vlTotal);
            mDtOcorrencia = (TextView) itemView.findViewById(R.id.dtOcorrencia);
            mOperacaoDC = (TextView) itemView.findViewById(R.id.operacaoDC);
            mDescricao = (TextView) itemView.findViewById(R.id.descricao);
            mCancelado = (TextView) itemView.findViewById(R.id.cancelado);
        }
    }
}
