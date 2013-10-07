package com.mobiorama.view;

import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.mobiorama.R;
import com.mobiorama.control.EmprestimoAdapter;
import com.mobiorama.control.EmprestimoDao;
import com.mobiorama.model.Emprestimo;

public class ListaEmprestimoNovo extends Activity implements OnItemClickListener, OnClickListener, OnItemLongClickListener {
	private Dialog dialog = null;
	private int pesquisaClicada;
	private Emprestimo emprestimoSelecionado;
	@Override	
	protected void onCreate(Bundle savedInstanceState) {
		pesquisaClicada = 0;
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.novolistaemprestimo);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_generalcoders_lista);

		ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAddEmprestimo);
		ImageButton btnPesquisar = (ImageButton) findViewById(R.id.btnPesquisaEmprestimo);

		ListView lt = (ListView) findViewById(R.id.listaemp);
		EmprestimoDao emprestimoDao = new EmprestimoDao(this);
		Intent it = this.getIntent();
		List<Emprestimo> emprestimos = null;
		if(it != null){
			if(it.getExtras() != null ){
				Bundle params = it.getExtras();
				emprestimos = emprestimoDao.getEmprestimos(params.getString("busca"));
			}else{
				emprestimos = emprestimoDao.getEmprestimos();				
			}
		}

		EmprestimoAdapter emprestimo = new EmprestimoAdapter(this, emprestimos);
		lt.setAdapter( emprestimo);

		btnAdd.setOnClickListener(this);
		btnPesquisar.setOnClickListener(this);
		lt.setOnItemClickListener(this);
		lt.setOnItemLongClickListener(this);
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		//Toast.makeText(this, "Ddasdasda", Toast.LENGTH_SHORT).show();
		EmprestimoAdapter emp = (EmprestimoAdapter)arg0.getAdapter();
		Emprestimo emprestimo  = (Emprestimo) emp.getItem(arg2);

		Bundle params = new Bundle();
		params.putString("nome", emprestimo.getNome());
		params.putInt("id", emprestimo.getId());
		params.putInt("dia", emprestimo.getDia());
		params.putInt("mes", emprestimo.getMes());
		params.putInt("ano", emprestimo.getAno());
		params.putString("itemEmprestimo", emprestimo.getItemEmprestimo());
		Intent it = new Intent(this,NovoEmprestimo.class);
		it.putExtras(params);
		this.finish();
		this.startActivity(it);
		//	this.finish();
	}

	public void onClick(View v) {
		//SE FOI CLICADO O BOTÃO ADCIONAR
		if(v.getId() == R.id.btnAddEmprestimo){			
			Intent it = new Intent(this, NovoEmprestimo.class);
			this.finish();
			this.startActivity(it);
		}else if(v.getId() == R.id.btnCancelarDevolvido){
			dialog.dismiss();
			// SE FOI CLICADO O BOTÃO PESQUISAR NA DIALOG 
		}else if(v.getId() == R.id.btnSalvarDevolvido){
			EmprestimoDao dao = new EmprestimoDao(this);
			dao.excluir(Long.parseLong(emprestimoSelecionado.getId()+""));
			dialog.dismiss();
			Intent it = new Intent(this,ListaEmprestimoNovo.class);
			this.finish();
			this.startActivity(it);
		}else if(v.getId() == R.id.btnpesquisardialog){
			EditText parametroPesquisa = (EditText) dialog.findViewById(R.id.txtParametroPesquisa);
			String parametro = parametroPesquisa.getText().toString();
			Bundle param = new Bundle();
			param.putString(getString(R.string.pesquisar), parametro);
			Intent it = new Intent(this, ListaEmprestimoNovo.class);
			it.putExtras(param);
			this.finish();
			this.startActivity(it);
			//		this.finish();
		}else if(v.getId() == R.id.btncancelardialog){
			this.dialog.hide();
		}else if(v.getId() == R.id.txtParametroPesquisa){
			if(pesquisaClicada == 0){
				EditText txtParametroPesquisa = (EditText) dialog.findViewById(R.id.txtParametroPesquisa);
				txtParametroPesquisa.setText("");
			}
		}else{
			openDialog();
		}

	}

	private void openDialog(){
		dialog = new Dialog(this);
		dialog.setTitle(getString(R.string.pesquisar));
		dialog.setContentView(R.layout.dialogpesquisaremprestimo);
		dialog.setCancelable(true);

		EditText txtParametroPesquisa 	= (EditText) dialog.findViewById(R.id.txtParametroPesquisa);
		txtParametroPesquisa.setOnClickListener(this);
		Button btnPesquisa 				= (Button) dialog.findViewById(R.id.btnpesquisardialog);
		Button btnCancelarDialog 		= (Button) dialog.findViewById(R.id.btncancelardialog);
		btnCancelarDialog.setOnClickListener(this);
		btnPesquisa.setOnClickListener(this);
		dialog.show();
	}

	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		EmprestimoAdapter emprestimos 	= (EmprestimoAdapter)((ListView)arg0).getAdapter();
		emprestimoSelecionado = (Emprestimo)emprestimos.getItem(arg2);
		dialog = new Dialog(this);
		dialog.setTitle(getString(R.string.devolvido));
		dialog.setContentView(R.layout.dialogdeletaremprestimo);
		dialog.setCancelable(true);
		Button btnSalvarDevolvido 		= (Button)dialog.findViewById(R.id.btnSalvarDevolvido);
		Button btnCancelarDevolvido 	= (Button)dialog.findViewById(R.id.btnCancelarDevolvido);
		btnSalvarDevolvido.setOnClickListener(this);
		btnCancelarDevolvido.setOnClickListener(this);
		dialog.show();
		return false;
	}
}