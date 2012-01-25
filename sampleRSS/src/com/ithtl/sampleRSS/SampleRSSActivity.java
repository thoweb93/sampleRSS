package com.ithtl.sampleRSS;

import com.ithtl.eventListener.EventListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class SampleRSSActivity extends Activity {
	
	private Button bt_getRSS;
	private EventListener eventListener;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.eventListener = new EventListener(this);
        
        this.bt_getRSS = (Button) this.findViewById(R.id.bt_getRSS);
        this.bt_getRSS.setOnClickListener(this.eventListener);
    }    
    public Button getBt_getRSS(){return this.bt_getRSS;}
}