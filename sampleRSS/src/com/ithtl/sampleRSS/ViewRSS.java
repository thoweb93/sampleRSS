package com.ithtl.sampleRSS;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import RSS.RSSFeed;
import RSS.RSSHandler;
import RSS.RSSItem;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ViewRSS extends Activity {

	public final String RSSFEEDOFCHOICE = "http://rss.slashdot.org/Slashdot/slashdot";
	
	private RSSFeed feed = null;	
	
	@Override
	public void  onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rsslist);
		
		feed = getFeed(RSSFEEDOFCHOICE);
		UpdateDisplay();
	}
	
	private void UpdateDisplay(){
		TextView tV_FeedTitle = (TextView) findViewById(R.id.tV_FeedTitle);
		TextView tV_FeedPupDate = (TextView) findViewById(R.id.tV_FeedUpdate);
		ListView lV_FeedItems = (ListView)findViewById(R.id.lV_FeedItems);
		
		if(feed ==null){
			tV_FeedTitle.setText("No RSS Feed Available");
			return;
		}
		
		tV_FeedTitle.setText(feed.getTitle());
		//tV_FeedPupDate.setText(feed.getPubDate());
		
		ArrayAdapter<RSSItem> adapter = new ArrayAdapter<RSSItem>(this, android.R.layout.simple_list_item_1, feed.getAllItems());
		lV_FeedItems.setAdapter(adapter);
		lV_FeedItems.setSelection(0);
	}
	private RSSFeed getFeed(String _url){
		try{
			URL url = new URL(_url);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			
			XMLReader xmlReader = parser.getXMLReader();			
			RSSHandler rssHandler = new RSSHandler();
			xmlReader.setContentHandler(rssHandler);
			InputSource is = new InputSource(url.openStream());
			xmlReader.parse(is);
			return rssHandler.getFeed();
		}
		catch(Exception ee){
			return null;
		}
	}
}
