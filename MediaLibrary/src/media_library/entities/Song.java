package media_library.entities;

public class Song {
	
	
	//song variable
	private int ID;
	private String title;
	private Double duration;
	private String songWriter;
	private String genre;
	private int artistID;
	private int albumID;
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Double getDuration() {
		return duration;
	}
	
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	
	public String getSongWriter() {
		return songWriter;
	}
	
	public void setSongWriter(String songWriter) {
		this.songWriter = songWriter;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public int getArtistID() {
		return artistID;
	}
	
	public void setArtistID(int artistID) {
		this.artistID = artistID;
	}
	
	public int getAlbumID() {
		return albumID;
	}
	
	public void setAlbumID(int albumID) {
		this.albumID = albumID;
	}
	
	

}
