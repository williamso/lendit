package com.mobiorama.control.receiver;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.mobiorama.R;
import com.mobiorama.Principal;
import com.mobiorama.control.EmprestimoDao;
import com.mobiorama.model.Emprestimo;

public class OnTimeCheckdevolutions extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		EmprestimoDao emprestimoDao = new EmprestimoDao(context);
		ArrayList<Emprestimo> emprestimos = emprestimoDao.getEmprestimos();
		Calendar hoje = Calendar.getInstance();
		Log.i(Principal.CATEGORIA, "Dia do mes "+hoje.get(Calendar.DAY_OF_MONTH));
		Log.i(Principal.CATEGORIA, "Mes do ano "+hoje.get(Calendar.MONTH));
		Log.i(Principal.CATEGORIA, "Ano "+hoje.get(Calendar.YEAR));
		
		boolean hasEmprestimosNaoDevolvidos = false;
		for(Emprestimo emprestimo:emprestimos){
			Calendar dataprevista = Calendar.getInstance();
			dataprevista.set(Calendar.DAY_OF_MONTH, emprestimo.getDia());
			dataprevista.set(Calendar.MONTH, emprestimo.getMes());
			dataprevista.set(Calendar.YEAR, emprestimo.getAno());
			
			if(hoje.after(dataprevista))
				hasEmprestimosNaoDevolvidos = true;
			
		}
		if(hasEmprestimosNaoDevolvidos){			
			String tickerText = "Opss!";
			//Detalhes da mensagem, quem enviou e o texto
			CharSequence titulo = "LENDIT";
			CharSequence mensagem = "Existem itens não devolvidos";
			criarNotificacao(context, tickerText, titulo, mensagem, Principal.class);
		}
	}
	
	protected void criarNotificacao( Context context, CharSequence mensagemBarraStatus, CharSequence titulo, CharSequence mensagem, Class<?> activity){
		//Recupera o serviço do NotificationManager
		NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification n = new Notification(R.drawable.statusbar, mensagemBarraStatus, System.currentTimeMillis());
		//PendingIntent para executar a Activity se o usuário selecionar a Notificacao
		PendingIntent p = PendingIntent.getActivity(context, 0, new Intent(context, activity),0);
		//INFORMACOES
		n.setLatestEventInfo(context, titulo, mensagem, p);
		/**
		 * PREICSA DE PERMISSAO TO USANDO <uses-permission android:name="android.permission.VIBRATE" />
		 *eSPERA 100MS E VIBRA POR 250MS, DEPOIS ESPERA POR 100MS E VIBRA POR 500MS
		 */
		n.vibrate = new long[]{100,250,100,500};
		//id (número único) que identifica esta notificação
		nm.notify(R.string.app_name, n);
	}

}
