package RSS;

import java.util.List;
import java.util.Vector;

public class RSSFeed 
{
	private String title = null;
	private String pubdate = null;
	private int itemcount = 0;
	private List<RSSItem> itemlist;
	
    public RSSFeed()
    {
        itemlist = new Vector(0); 
    }
    public int addItem(RSSItem _item)
    {
        itemlist.add(_item);
        itemcount++;
        return itemcount;
    }
    public RSSItem getItem(int _location)
    {
        return itemlist.get(_location);
    }
    public List<RSSItem> getAllItems()
    {
        return itemlist;
    }
    public int getItemCount()
    {
        return itemcount;
    }
    public void setTitle(String _title)
    {
        title = _title;
    }
    public void setPubDate(String _pubdate)
    {
        pubdate = _pubdate;
    }
    public String getTitle()
    {
        return title;
    }
    public String getPubDate()
    {
        return pubdate;
    }
    

}
