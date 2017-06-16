package media_library.dao;

import java.util.List;

import media_library.entities.Artist;

public interface ArtistDAO {
	
	//creates Artist
	public Artist createArtist(Artist a);
	
	//Removes Artist
	public void deleteArtist(Artist a);
	
	//Updates Artist
	public void updateArtist(Artist a);
	
	//Get all Artist
	public List<Artist> getAllArtist();
	
	//Gets Artist by ID
	public Artist getArtist(int id);
	

}
