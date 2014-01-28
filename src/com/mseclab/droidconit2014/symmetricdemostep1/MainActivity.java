package com.mseclab.droidconit2014.symmetricdemostep1;

import java.security.Provider;
import java.security.Security;
import java.util.Set;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView outView;
	private final static String TAG = "DROIDCONIT";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		outView = (TextView) findViewById(R.id.out_view);
		showProviders();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void showProviders() {
		Provider[] providers = Security.getProviders();
		for (Provider provider : providers) {
			debug("Provider: " + provider.getName());
			debug("Version : " + Double.toString(provider.getVersion()));
			debug("Info    : " + provider.getInfo());
			Set<Provider.Service> services = provider.getServices();
			for (Provider.Service service : services) {
				debug("  algorithm: " + service.getAlgorithm());
				debug(service.toString());
				
			}
			debug("\n");
		}
	}

	private void debug(String message) {
		Log.v(TAG, message);
		outView.append(message + "\n");
	}

}
