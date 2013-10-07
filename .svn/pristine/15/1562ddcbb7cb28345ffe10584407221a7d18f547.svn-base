package com.mobiorama.control;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mobiorama.model.Emprestimo;

public class EmprestimoDao {
	private SQLiteDatabase db;
	
	private static final String SCRIPT_DATABASE_DELETE = "DROP TABLE IF EXISTS emprestimos";
	
	private static final String[] SCRIPT_DATABASE_CREATE = new String[] { "CREATE TABLE emprestimos (_id integer primary key autoincrement, nome text not null, dia int not null, mes int not null, ano int not null, emprestimo text not null);"};
	
	private static final String NOME_BANCO = "lendit";
	
	private static final int VERSAO_BANCO = 1;
	
	private static final String TABELA_EMPRESTIMO = "emprestimos";
	
	private SQLiteHelper dbHelper;
	
	private static final String ID = "_ID";
	private static final String NOME = "nome";
	private static final String ANO = "ano";
	private static final String MES = "mes";
	private static final String DIA = "dia";
	private static final String ITEM = "emprestimo";
	
	private static final String [] COLUNAS = {EmprestimoDao.ID, EmprestimoDao.NOME, 
		EmprestimoDao.DIA, EmprestimoDao.MES, EmprestimoDao.ANO, EmprestimoDao.ITEM};
	
	public EmprestimoDao(Context ctx){
		dbHelper = new SQLiteHelper(ctx, EmprestimoDao.NOME_BANCO, EmprestimoDao.VERSAO_BANCO, EmprestimoDao.SCRIPT_DATABASE_CREATE, EmprestimoDao.SCRIPT_DATABASE_DELETE);
	}

	public ArrayList<Emprestimo> getEmprestimos(){
		db = dbHelper.getWritableDatabase();
		Cursor c = db.query("emprestimos", COLUNAS, null, null, null, null, null);
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
		c.close();
		this.fechar();
		return emprestimos;
	}
	
	public SQLiteDatabase getDb() {
		db = dbHelper.getWritableDatabase();
		return db;
	}

	public void setDb(SQLiteDatabase db) {
		this.db = db;
	}
	
	public void save(Emprestimo emprestimo){
		db = dbHelper.getWritableDatabase();
		ContentValues valores = new ContentValues();
		valores.put("nome", emprestimo.getNome());
		valores.put("dia", emprestimo.getDia());
		valores.put("mes", emprestimo.getMes());
		valores.put("ano", emprestimo.getAno());
		valores.put("emprestimo", emprestimo.getItemEmprestimo());
		db.insert(TABELA_EMPRESTIMO, null, valores);
		db.close();
	}
	
	public void update(Emprestimo emprestimo){
		db = dbHelper.getWritableDatabase();
		ContentValues valores = new ContentValues();
		valores.put("nome", emprestimo.getNome());
		valores.put("dia", emprestimo.getDia());
		valores.put("mes", emprestimo.getMes());
		valores.put("ano", emprestimo.getAno());
		valores.put("emprestimo", emprestimo.getItemEmprestimo());
		db.update(TABELA_EMPRESTIMO, valores, "_id = ?", new String[]{emprestimo.getIdLong()+""});
		db.close();
	}
	
	public void excluir(Long id){
		db = dbHelper.getWritableDatabase();
		db.delete(TABELA_EMPRESTIMO, "_id=?", new String[]{id+""});
		this.fechar();
	}
	
	public List<Emprestimo> getEmprestimos(String condicao){
		db = dbHelper.getWritableDatabase();
		condicao = "%"+condicao+"%";
		Cursor c = db.query(true, TABELA_EMPRESTIMO, EmprestimoDao.COLUNAS , " nome LIKE ? OR emprestimo LIKE ?", 
				new String[]{condicao, condicao}, null, null, null, null);
		Emprestimo emprestimo = null;
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		if(c.getCount() > 0){
			emprestimo = new Emprestimo();
			c.moveToFirst();
			do{
				emprestimo = new Emprestimo();
				emprestimo.setId(c.getInt(0));
				emprestimo.setNome(c.getString(1));
				emprestimo.setDia(c.getInt(2));
				emprestimo.setMes(c.getInt(3));
				emprestimo.setAno(c.getInt(4));
				emprestimo.setItemEmprestimo(c.getString(5));
				emprestimos.add(emprestimo);
			}while(c.moveToNext());
		}
		c.close();
		this.fechar();
		return emprestimos;
	}
	
	public Emprestimo getEmprestimo(long id){
		db = dbHelper.getWritableDatabase();
		Cursor c = db.query(true, TABELA_EMPRESTIMO, EmprestimoDao.COLUNAS , "_id=?", 
				new String[]{id+""}, null, null, null, null);
		Emprestimo emprestimo = null;
		if(c.getCount() > 0){
			emprestimo = new Emprestimo();
			c.moveToFirst();
			emprestimo.setId(c.getInt(0));
			emprestimo.setNome(c.getString(1));
			emprestimo.setDia(c.getInt(2));
			emprestimo.setMes(c.getInt(3));
			emprestimo.setAno(c.getInt(4));
			emprestimo.setItemEmprestimo(c.getString(5));
		}
		c.close();
		this.fechar();
		return emprestimo;
	}
	
	public void fechar(){
		db.close();
	}
	
}
