package com.mobiorama.control;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;

import com.mobiorama.view.ListaEmprestimoNovo;

public class Time extends CountDownTimer {
	private Activity act;
	
	public Time(Activity act){
		super(3000, 1000);
		this.act = act;
	}
	
	@Override
	public void onFinish() {
		this.cancel();
		this.act.finish();
		Intent it = new Intent(act,ListaEmprestimoNovo.class);
		this.act.startActivity(it);
	}

	@Override
	public void onTick(long millisUntilFinished) {

	}

	public Activity getAct() {
		return act;
	}

	public void setAct(Activity act) {
		this.act = act;
	}

}
