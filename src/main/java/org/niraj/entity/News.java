package org.niraj.entity;

public class News {

	private int newsId;
	private String newsHeading; 
	private String newsCategory;
	private String brief;

	public News() {
		super();
	}
	public News(int newsId, String newsHeading, String newsCategory, String brief) {
		super();
		this.newsId = newsId;
		this.newsHeading = newsHeading;
		this.newsCategory = newsCategory;
		this.brief = brief;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsHeading() {
		return newsHeading;
	}
	public void setNewsHeading(String newsHeading) {
		this.newsHeading = newsHeading;
	}
	public String getNewsCategory() {
		return newsCategory;
	}
	public void setNewsCategory(String newsCategory) {
		this.newsCategory = newsCategory;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsHeading=" + newsHeading + ", newsCategory=" + newsCategory + ", brief="
				+ brief + "]";
	}
		
}
