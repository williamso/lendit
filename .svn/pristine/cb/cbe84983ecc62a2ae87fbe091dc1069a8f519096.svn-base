package com.mobiorama.control.receiver;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.mobiorama.Principal;

public class OnSystemStartsReceiver extends BroadcastReceiver {

	public static final String VERIFICAR_DEVOLUCAO = "VERIFICA_DEVOLUCAO";
	
	/**
	 * ESSA CLASSE REGISTRA QUANDO O SISTEMA É INICIADO 
	 * E PARTIR DAI GERA UM ALARMEMANAGER PARA A CADA DIA NA HORA QUE O USUÁRIO
	 * ESCOLHEU ELE VERIFIQUE SE ALGUM IMPRESTO ULTRAPASSOU O PRAZO E JÁ DEVIA SER
	 * DEVOLVIDO A CONFIGURACAO PARA RECEBER ESSE ALERTA DO SISTEMA É FEITO NO 
	 * ANDROIDMANIFEST.XMl
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Pegou a mensagem inicial", Toast.LENGTH_SHORT).show();
		Log.i(Principal.CATEGORIA, "Sistema operacional iniciado, iniciando os alarmes");
		Intent it = new Intent(OnSystemStartsReceiver.VERIFICAR_DEVOLUCAO);
		PendingIntent p = PendingIntent.getBroadcast(context, 0, it, 0);
		//Para executar o alarme depois de x segundos a partir de agora
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		//SEGUNDOS EM UM DIA 60*60*24
		c.add(Calendar.SECOND, 200);	
		//Agenda o alarme
		AlarmManager alarme = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		long time = c.getTimeInMillis();
		// 60000 para cada minuto
		// 60000 * 60 para uma hora 
		// 60000 *60 * 24 para um dia 
		long TempoParaRepetirVerificao = 60000;  
		alarme.setRepeating(AlarmManager.RTC_WAKEUP, time, TempoParaRepetirVerificao, p);
		Log.i(Principal.CATEGORIA, "crio o alarme");	
	}
	
}