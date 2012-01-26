package RSS;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

public class RSSHandler extends DefaultHandler {

	private RSSFeed feed;
	private RSSItem item;
	private boolean bFoundChannel = false; 
	private String lastElementName = "";
	
	final int RSS_TITLE = 1;
	final int RSS_LINK = 2;
	final int RSS_DESCRIPTION = 3;
	final int RSS_CATEGORY = 4;
	final int RSS_PUBDATE = 5;
	
	int depth = 0;
	int currentState = 0;
	
	public RSSHandler() {}
	
	public RSSFeed getFeed(){
		return feed;
	}
	
	public void startDocument() throws SAXException{
		feed = new RSSFeed();
		item = new RSSItem();
	}
	
	public void endDocument() throws SAXException{}
	
	public void startElement(String _namespaceURI, String _localName, String _qName, Attributes _atts) throws SAXException{
		depth++;
		Log.i("RSSReader", "localName: " + _localName);
		if(_localName.equals("channel")){
			currentState = 0;
			return;			
		}
		if(_localName.equals("image")){
			feed.setTitle(item.getTitle());
			feed.setPubDate(item.getPubDate());
			return;
		}
		if(_localName.equals("item")){
			item = new RSSItem();
			Log.i("RSSReader", "startElement: item true");
			return;
		}
		if(_localName.equals("title")){
			currentState = RSS_TITLE;
			return;
		}
		if(_localName.equals("description")){
			currentState = RSS_DESCRIPTION;
			return;
		}
		if(_localName.equals("link")){
			currentState = RSS_LINK;
			return;
		}
		if(_localName.equals("category")){
			currentState = RSS_CATEGORY;
			return;
		}
		if(_localName.equals("pupDate")){
			currentState = RSS_PUBDATE;
			return;
		}
		currentState = 0;
		Log.i("RSSReader", "Test startElement false");		
	}
	
	public void endElement(String _namespaceURI, String _localName, String _qName) throws SAXException{
		depth--;
		if(_localName.equals("item")){
			feed.addItem(item);
			return;
		}
	}
	
	public void characters(char _ch[], int _start, int _length){
		String theString = new String(_ch, _start, _length);
		Log.i("RSSReader", "currentstate : "+currentState);
		Log.i("RSSReader", "characters[" + theString + "]");		
		
		switch(currentState){
		case RSS_TITLE:
			item.setTitle(theString);
			currentState = 0;
			break;
		case RSS_LINK:
			item.setLink(theString);
			currentState = 0;
			break;
		case RSS_DESCRIPTION:
			item.setDescription(theString);
			currentState = 0;
			break;
		case RSS_CATEGORY:
			item.setCategory(theString);
			currentState = 0;
			break;
		case RSS_PUBDATE:
			item.setPubDate(theString);
			currentState = 0;
			break;
		default:
			return;
		}
	}
}













