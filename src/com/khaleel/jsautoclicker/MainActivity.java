package com.khaleel.jsautoclicker;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	private Spinner link_spinner;
	private Spinner time_spinner;
	private Button run_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		link_spinner = (Spinner) findViewById(R.id.link_spinner);
		time_spinner = (Spinner) findViewById(R.id.time_spinner);
		run_button = (Button) findViewById(R.id.run_button);
		
		List<String> links = new ArrayList<String>();
		links.add("http://affiliates.mozilla.org/link/banner/42069");
		links.add("http://affiliates.mozilla.org/referral/57480/");
		links.add("http://affiliates.mozilla.org/link/banner/42070");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, links);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			link_spinner.setAdapter(dataAdapter);
		
		List<String> times = new ArrayList<String>();
		times.add("3");
		times.add("10");
		times.add("20");
		times.add("30");
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, times);
			dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			time_spinner.setAdapter(dataAdapter1);
			
			run_button.setOnClickListener(new OnClickListener(){
				public void onClick(View v)
				{
					String url = String.valueOf(link_spinner.getSelectedItem());
					Log.d("LINK", url);
					String times = String.valueOf(time_spinner.getSelectedItem());
					Log.d("StringNUMBER",times);
					
					
					int no_of_time = Integer.parseInt(times);
					
					
					for (int i=0; i< no_of_time; i++)
					{
						startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(url)));
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
		
	}
}
