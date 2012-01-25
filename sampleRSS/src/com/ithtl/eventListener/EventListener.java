package com.ithtl.eventListener;
import com.ithtl.sampleRSS.SampleRSSActivity;
import com.ithtl.sampleRSS.ViewRSS;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class EventListener implements OnClickListener {

	private SampleRSSActivity sRSS;
	
	public EventListener(SampleRSSActivity _sRSS){
		this.sRSS = _sRSS;
	}
	
	public void onClick(View _v){
		if(_v==this.sRSS.getBt_getRSS()){
			Intent intentList = new Intent(_v.getContext(), ViewRSS.class);
			this.sRSS.startActivity(intentList);
		}
	}
}
