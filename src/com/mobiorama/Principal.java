package com.mobiorama;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.mobiorama.R;
import com.mobiorama.control.Time;

public class Principal extends Activity{
	public static final String CATEGORIA = "LENDIT";
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_generalcoders_main);
        Time t = new Time(this);
        t.start();
    }
}