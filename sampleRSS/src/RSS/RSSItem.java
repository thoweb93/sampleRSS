package RSS;

public class RSSItem {
	private String title = null;
	private String description = null;
	private String link = null;
	private String category = null;
	private String pubdate = null;
	
	RSSItem(){}
	
	void setTitle(String _title){
		title = _title;
	}
	
	void setDescription(String _description){
		description = _description;
	}
	void setLink(String _link){
		link = _link;
	}
    void setCategory(String _category)
    {
        category = _category;
    }
    void setPubDate(String _pubdate)
    {
        pubdate = _pubdate;
    }
    String getTitle()
    {
        return title;
    }
    String getDescription()
    {
        return description;
    }
    String getLink()
    {
        return link;
    }
    String getCategory()
    {
        return category;
    }
    String getPubDate()
    {
        return pubdate;
    }
    /*@Override
    public String toString()
    {
        // limit how much text you display
        if (title.length() > 42)
        {
            return title.substring(0, 42) + "...";
        }
        return title;
    }*/
}
