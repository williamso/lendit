package com.mobiorama.control;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobiorama.R;
import com.mobiorama.model.Emprestimo;

public class EmprestimoAdapter extends BaseAdapter {
	private Context context;
	private List<Emprestimo> lista;

	public EmprestimoAdapter(Context context, List<Emprestimo> lista){
		this.context = context;
		this.lista = lista;
	}

	public int getCount() {
		return lista.size();
	} 

	public Object getItem(int position) {
		return lista.get(position);
	}

	public long getItemId(int position) {
		return lista.get(position).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Emprestimo emprestimo = lista.get(position);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.rowemprestimo, null);
		TextView nome = (TextView) v.findViewById(R.id.nomeRow);
		ImageView img = (ImageView) v.findViewById(R.id.status);
		img.setImageResource(trocarImagem(emprestimo.getDia(), (emprestimo.getMes()+1), emprestimo.getAno()));
		nome.setText(emprestimo.getNome());
		TextView itemEmprestado = (TextView) v.findViewById(R.id.itemEmprestadoRow);
		itemEmprestado.setText(emprestimo.getItemEmprestimo());
		TextView data = (TextView) v.findViewById(R.id.data);
		data.setText(emprestimo.getDia()+"/"+(emprestimo.getMes()+1)+"/"+emprestimo.getAno());
		return v;
	}
	
	private int trocarImagem(int dia, int mes, int ano){
		int retorno = 0;
		if(validaData(dia, mes, ano).equalsIgnoreCase(Datas.OK))
			retorno = R.drawable.green;
		else if(validaData(dia, mes, ano).equalsIgnoreCase(Datas.ATRASADO))
			retorno = R.drawable.red;
		else
			retorno = R.drawable.orange;
		
		return retorno;
	}

	private String validaData(int dia, int mes, int ano){
		String retorno = null;
		Datas data = new Datas();
		if( ano < data.getAno() )
			retorno =  Datas.ATRASADO;
		else if( ano == data.getAno() && mes < data.getMes() )
			retorno = Datas.ATRASADO;
		else if( ano == data.getAno() && mes == data.getMes() && dia < data.getDia() )
			retorno = Datas.ATRASADO;
		else if( ano == data.getAno() && mes == data.getMes() && dia == data.getDia() )
			retorno = Datas.NODIA;
		else
			retorno = Datas.OK;
		return retorno;
	}
}
