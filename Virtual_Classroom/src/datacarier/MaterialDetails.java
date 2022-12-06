package datacarier;

public class MaterialDetails
{
	private long materialID;
	private long postedBy;
	private String title;
	private String content;
	
	public long getMaterialID()
	{
		return materialID;
	}
	public void setMaterialID(long materialID)
	{
		this.materialID = materialID;
	}
	public long getPostedBy()
	{
		return postedBy;
	}
	public void setPostedBy(long postedBy)
	{
		this.postedBy = postedBy;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
}
