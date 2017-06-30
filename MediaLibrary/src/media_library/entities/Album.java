package media_library.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "\"Album\"")
public class Album implements Serializable{

	

	// album variable

	private static final long serialVersionUID = -4733171036520447911L;

	@Id
	@Column(name = "\"ID\"", unique = true , nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@Column(name = "album_name", nullable = false)
	private String albumName;

	@Column(name = "album_publisher", nullable = false)
	private String albumPublisher;

	@Column(name = "year_of_publishing", nullable = false)
	private int yearOfPublishing;

	@Column(name = "\"artist_ID\"", nullable = false)
	private int artistID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@Column
	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	@Column
	public String getAlbumPublisher() {
		return albumPublisher;
	}

	public void setAlbumPublisher(String albumPublisher) {
		this.albumPublisher = albumPublisher;
	}

	@Column
	public int getYearOfPublishing() {
		return yearOfPublishing;
	}

	public void setYearOfPublishing(int yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}


	@ManyToOne(cascade = { CascadeType.ALL })
	public int getArtistID() {
		return artistID;
	}

	public void setArtistID(int artistID) {
		this.artistID = artistID;
	}
	
	@Override
	public String toString(){
		return(getAlbumName()+" "+getAlbumPublisher()+" "+getYearOfPublishing());
	}

}
