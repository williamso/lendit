package com.mobiorama.control;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {
	private static final String CATEGORIA = "emprestimo";
	private String[] ScriptSQLCreate;
	private String scriptDelete;
	
	
	SQLiteHelper(Context context, String name, int version, String[] scriptSQLCreate, String scriptDelete) {
		super(context, name, null, version);
		this.ScriptSQLCreate = scriptSQLCreate;
		this.scriptDelete = scriptDelete;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i(CATEGORIA, "criando banco com sql");
		int qtdeScript = ScriptSQLCreate.length;
		for(int i = 0; i< qtdeScript; i++){
			String sql = ScriptSQLCreate[i];
			Log.i(CATEGORIA, sql);
			db.execSQL(sql);
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(CATEGORIA, "Atualizando da versão "+oldVersion+" para a versão"+newVersion+". Todos os registros serão apagados");
		Log.i(CATEGORIA, scriptDelete);
		onCreate(db);
	}

}
