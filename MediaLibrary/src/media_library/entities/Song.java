package media_library.entities;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="\"Song\"")
public class Song implements Serializable{
	
	
	private static final long serialVersionUID = 8658644760403007209L;

	//song variable
	@Id
	@Column(name = "\"ID\"", unique = true , nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="duration", nullable=false)
	private Double duration;
	
	
	@Column(name="song_writer", nullable=false)
	private String songWriter;
	
	@Column(name="genre", nullable=false)
	private String genre;
	
	
	@Column(name="\"artist_ID\"", nullable=false)
	private int artistID;
	
	
	@Column(name="\"album_ID\"", nullable=false)
	private int albumID;
	
	
		public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	
	
	@Column
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column
	public Double getDuration() {
		return duration;
	}
	
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	
	@Column
	public String getSongWriter() {
		return songWriter;
	}
	
	public void setSongWriter(String songWriter) {
		this.songWriter = songWriter;
	}
	
	@Column
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@ManyToOne(cascade = { CascadeType.ALL })
	public int getArtistID() {
		return artistID;
	}
	
	public void setArtistID(int artistID) {
		this.artistID = artistID;
	}
	

	@ManyToOne(cascade = { CascadeType.ALL })
	public int getAlbumID() {
		return albumID;
	}
	
	public void setAlbumID(int albumID) {
		this.albumID = albumID;
	}
	
	@Override
	public String toString(){
		return(getTitle()+" "+getGenre()+" "+getSongWriter()+" "+getDuration());
	}

}
