package media_library.dao;


import java.util.List;

import media_library.entities.Album;

public interface AlbumDAO {
	
	//Creates album
	public Album createAlbum(Album a);
	
	//Removes album
	public void deleteAlbum(Album a);
	
	//Updates album
	public void updateAlbum(Album a);
	
	//Get all albums
	public List<Album> getAllAlbums();
	
	//Gets album by ID
	public Album getAlbum(int id);
	
}

