package com.jentsch.launchfrombrowser;

import android.app.*;
import android.content.*;
import android.net.*;
import android.os.*;
import android.widget.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		String info = "Launch Params: ";
		try {
			info += " " + getIntent().getDataString();
		} catch (Exception e) {
			info += " " + e.toString();
		}
		((TextView)findViewById(R.id.info)).setText(info);
		if (info.indexOf("Herzlichen Glückwunsch") >= 0)
		{
			Toast.makeText(this, "Du hast es geschafft", Toast.LENGTH_LONG);		
		} else {
			String url = "http://dieletztedomain.de/";
			Uri uriUrl = Uri.parse(url);
			Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
			startActivity(launchBrowser);
		}
		
    }
}
