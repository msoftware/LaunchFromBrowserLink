package com.jentsch.launchfrombrowser;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.net.*;
import java.util.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		String info = "";
		try {
			info = getIntent().getDataString();
			Uri data = getIntent().getData();
			String scheme = data.getScheme(); // "http"
			String host = data.getHost(); // "twitter.com"
			List<String> params = data.getPathSegments();
			String first = params.get(0); // "status"
			String second = params.get(1); // "1234"
		
			info = scheme + " " + host + " " + first + " " + second;
		} catch (Exception e) {
			info += " " + e.toString();
		}
		((TextView)findViewById(R.id.info)).setText(info);
		
    }
}
