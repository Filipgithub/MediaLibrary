package media_library.entities;

public class Album {
	
	
	//album variable
	private int ID;
	private String albumName;
	private String albumPublisher;
	private int yearOfPublishing;
	private int artistID;
	
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getAlbumName() {
		return albumName;
	}
	
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	
	public String getAlbumPublisher() {
		return albumPublisher;
	}
	
	public void setAlbumPublisher(String albumPublisher) {
		this.albumPublisher = albumPublisher;
	}
	
	public int getYearOfPublishing() {
		return yearOfPublishing;
	}
	
	public void setYearOfPublishing(int yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}
	
	public int getArtistID() {
		return artistID;
	}
	
	public void setArtistID(int artistID) {
		this.artistID = artistID;
	}
	
	
	

}
