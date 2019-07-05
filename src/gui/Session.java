package gui;

public class Session {
	
	int duration;
	int intensity;
	String description;
	String type;
	String author;
	
	public Session(int duration, int intensity, String description, String type, String author) {
		this.duration = duration;
		this.intensity = intensity;
		this.description = description;
		this.type = type;
		this.author = author;
	}
	
	public int getDuration() {
		return duration;
	}

	public int getIntensity() {
		return intensity;
	}

	public String getDescription() {
		return description;
	}

	public String getType() {
		return type;
	}

	public String getAuthor() {
		return author;
	}
}
