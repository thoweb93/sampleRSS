package RSS;

public class RSSItem {
	private String title = "";
	private String description = "";
	private String link = "";
	private String category = "";
	private String pubdate = "";
	
	public RSSItem(){}
	
	public void setTitle(String _title){
		title = _title;
	}
	
	public void setDescription(String _description){
		description = _description;
	}
	public void setLink(String _link){
		link = _link;
	}
	public void setCategory(String _category)
    {
        category = _category;
    }
	public void setPubDate(String _pubdate)
    {
        pubdate = _pubdate;
    }
	public String getTitle()
    {
        return title;
    }
	public String getDescription()
    {
        return description;
    }
	public String getLink()
    {
        return link;
    }
	public String getCategory()
    {
        return category;
    }
	public String getPubDate()
    {
        return pubdate;
    }
	
    @Override
    public String toString()
    {
        // limit how much text you display
        if (title.length() > 42)
        {
            return title.substring(0, 42) + "...";
        }
        return title;
    }
}
