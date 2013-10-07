package com.mobiorama.view;


import com.mobiorama.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TabHost;

public class Tabs extends TabActivity {
	TabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.tabs);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_generalcoders_novo);
		mTabHost = getTabHost();
	    mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("TAB 2").setContent(new Intent(this, NovoEmprestimo.class)));
	    mTabHost.addTab(mTabHost.newTabSpec("tab_test233").setIndicator("TAB 3333").setContent(new Intent(this, ListaEmprestimoNovo.class)));    
	    mTabHost.setCurrentTab(0);
	}
}
