package RSS;

import java.text.AttributedCharacterIterator.Attribute;
import java.util.jar.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

public class RSSHandler extends DefaultHandler {

	RSSFeed feed;
	RSSItem item;
	String lastElementName = "";
	boolean bFoundChannel = false;
	
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
	
	public void startElement(String _namespaceURI, String _localName,String _qName, 
            Attributes _atts) throws SAXException{
		depth++;
		if(_localName.equals("channel")){
			currentState = 0;
			return;			
		}
		if(_localName.equals("image")){
			feed.setTitle(item.getTitle());
			feed.setPubDate(item.getPubDate());
		}
		if(_localName.equals("item")){
			item = new RSSItem();
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













