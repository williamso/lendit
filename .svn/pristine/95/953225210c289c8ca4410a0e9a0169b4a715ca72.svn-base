package com.mobiorama.view;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mobiorama.control.EmprestimoAdapter;
import com.mobiorama.control.EmprestimoDao;
import com.mobiorama.model.Emprestimo;

public class ListaEmprestimo extends ListActivity {
	private static final int EDITAR = 0;
//	private static final int EXCLUIR = 1;
	private static final int NOVO = 2;
	private long idSelecionado = 0;
	private int opcaoSelecionada = 3; // 0 para editar 1 para excluir
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//ContactsContract.Contacts atualizada no livro ele usa outra classe mais coloquei essa porque ja ï¿½ a versï¿½o atualizada da classe
		//recupera o cursor dos contatos da agenda do celular 
		//Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
		//startManagingCursor(c);		
		
		EmprestimoDao emprestimoDao = new EmprestimoDao(this);
		ArrayList<Emprestimo> emprestimos = emprestimoDao.getEmprestimos();
		EmprestimoAdapter emprestimo = new EmprestimoAdapter(this, emprestimos);
		setListAdapter( emprestimo );
		registerForContextMenu(getListView());
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 super.onCreateOptionsMenu(menu);
		 MenuItem item = menu.add(0, NOVO, 0, "Novo");
		 // O EXEMPO DO MENU TA NA ÁGINA 250
		// item.setIcon(R.drawable.icon)
		 return true;
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("Opções");
	    String[] menuItems = {"Editar", "Deletar"};
	    for (int i = 0; i<menuItems.length; i++) {
	      menu.add(Menu.NONE, i, i, menuItems[i]);
	    }
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		super.onContextItemSelected(item);
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
		this.idSelecionado = info.id;
		return true;
	}
		
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		super.onMenuItemSelected(featureId, item);
		this.opcaoSelecionada = item.getItemId();
		if(opcaoSelecionada == EDITAR){
			Intent it = new Intent(this,NovoEmprestimo.class);
			Bundle params = new Bundle();
			params.putLong("id", idSelecionado);
			it.putExtras(params);
			idSelecionado = 0;
			this.finish();
			this.startActivity(it);
		}else if(opcaoSelecionada == NOVO){
			Intent it = new Intent(this,NovoEmprestimo.class);
			idSelecionado = 0;
			this.finish();
			this.startActivity(it);
		}else{
			EmprestimoDao emprestimo = new EmprestimoDao(this);
			emprestimo.excluir(idSelecionado);
			idSelecionado = 0;
			Intent it = new Intent(this,ListaEmprestimo.class);
			this.finish();
			this.startActivity(it);
		}
		return true;
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
//		
//		Emprestimo emprestimo = (Emprestimo) this.getListAdapter().getItem(position);
//		
//		Bundle params = new Bundle();
//		params.putString("nome", emprestimo.getNome());
//		params.putInt("id", emprestimo.getId());
//		params.putInt("dia", emprestimo.getDia());
//		params.putInt("mes", emprestimo.getMes());
//		params.putInt("ano", emprestimo.getAno());
//		params.putString("itemEmprestimo", emprestimo.getItemEmprestimo());
//		Intent it = new Intent(this,NovoEmprestimo.class);
//		it.putExtras(params);
//		this.startActivity(it);
	}
}
