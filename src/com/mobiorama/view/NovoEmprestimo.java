package com.mobiorama.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.mobiorama.R;
import com.mobiorama.control.EmprestimoDao;
import com.mobiorama.model.Emprestimo;

public class NovoEmprestimo extends Activity implements OnClickListener {
	Bundle params;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.novo);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_generalcoders_novo);
		Intent it = getIntent();
		if( it != null ){
			if( it.getExtras() != null ){
				Bundle params = it.getExtras();
				EmprestimoDao emprestimoDao = new EmprestimoDao(this);
				Emprestimo emprestimo = emprestimoDao.getEmprestimo(params.getInt("id"));
			
				EditText txtNome = (EditText) findViewById(R.id.nome);
				txtNome.setText(emprestimo.getNome());
				DatePicker picker = (DatePicker) findViewById(R.id.datePicker);
				picker.updateDate(emprestimo.getAno(), emprestimo.getMes(), emprestimo.getDia());
				EditText itemEmprestimo = (EditText) findViewById(R.id.itemEmprestimo);
				itemEmprestimo.setText(emprestimo.getItemEmprestimo());
				this.params = params;
			
			}
			
			Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
			btnSalvar.setOnClickListener(this);
		
			Button btnCancelar = (Button) findViewById(R.id.btnCancelar);
			btnCancelar.setOnClickListener(this);
			
		}
	}

	public void onClick(View v) {
		Intent it = new Intent(this, ListaEmprestimoNovo.class);
		if( v.getId() == R.id.btnCancelar )
			this.startActivity(it);
		else{
			EmprestimoDao emprestimoDao = new EmprestimoDao(this);
			Emprestimo emprestimo = new Emprestimo();
			if(params != null){
				emprestimo.setIdLong(params.getInt("id"));
			}
			emprestimo.setNome(((EditText)findViewById(R.id.nome)).getText().toString());
			emprestimo.setDia(((DatePicker)findViewById(R.id.datePicker)).getDayOfMonth());
			emprestimo.setMes(((DatePicker)findViewById(R.id.datePicker)).getMonth());
			emprestimo.setAno(((DatePicker)findViewById(R.id.datePicker)).getYear());
			emprestimo.setItemEmprestimo(((EditText)findViewById(R.id.itemEmprestimo)).getText().toString());
			if(params != null){
				emprestimoDao.update(emprestimo);
			}else{
				emprestimoDao.save(emprestimo);
			}
			this.finish();
			this.startActivity(it);
		}
      
      
	}
}
