package com.mobiorama.model;

import java.util.ArrayList;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class EmprestimoDao {
	private SQLiteDatabase db;
	
	public EmprestimoDao(SQLiteDatabase db){
		this.db = db;
	}

	public ArrayList<Emprestimo> getEmprestimos(){
		Cursor c = db.query("emprestimos", new String[]{"_id", "nome", "dia", "mes", "ano", "emprestimo"}, null, null, null, null, null);
		ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		if(c.getCount() > 0){
			c.moveToFirst();
			do{
				Emprestimo emprestimo = new Emprestimo();
				emprestimo.setId(c.getInt(0));
				emprestimo.setNome(c.getString(1));
				emprestimo.setDia(c.getInt(2));
				emprestimo.setMes(c.getInt(3));
				emprestimo.setAno(c.getInt(4));
				emprestimo.setItemEmprestimo(c.getString(5));
				emprestimos.add(emprestimo);
			}while(c.moveToNext());
		}
		return emprestimos;
	}
	
	public SQLiteDatabase getDb() {
		return db;
	}

	public void setDb(SQLiteDatabase db) {
		this.db = db;
	}
	
}
