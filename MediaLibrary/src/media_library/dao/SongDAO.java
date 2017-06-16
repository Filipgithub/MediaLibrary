package media_library.dao;

import java.util.List;

import media_library.entities.Song;

public interface SongDAO {
	//Creates Song
	public Song createSong(Song a);
	
	//Removes Song
	public void deleteSong(Song a);
	
	//Updates Song
	public void updateSong(Song a);
	
	//Get all albums
	public List<Song> getAllSong();
	
	//Gets Song by ID
	public Song getSong(int id);
	


}
