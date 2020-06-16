package helper;

public class RestResponse {
	
	private String title;
	private String text;
	private String icon;
	
	public RestResponse(String title, String text, String icon) {
		this.title = title;
		this.text = text;
		this.icon = icon;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}
