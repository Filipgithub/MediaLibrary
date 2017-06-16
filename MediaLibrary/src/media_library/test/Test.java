package media_library.test;

import media_library.dao.AlbumDAO;
import media_library.dao.ArtistDAO;
import media_library.dao.SongDAO;
import media_library.dao.implementation.ConnectionManager;
import media_library.dao.implementation.JDBCAlbumDAO;
import media_library.dao.implementation.JDBCArtistDAO;
import media_library.dao.implementation.JDBCSongDAO;
import media_library.entities.Album;
import media_library.entities.Artist;
import media_library.entities.Song;

public class Test {

	public static void main(String[] args) {

		ConnectionManager.getConnection();
		
		Artist artist = new Artist();
		ArtistDAO artistDao = new JDBCArtistDAO();
		
		artist.setFirstName("Gordon Matthew Thomas");
		artist.setLastName("Sumner");
		artist.setArtistName("String");
		
		artistDao.createArtist(artist);
		artistDao.updateArtist(artist);
		//artistDao.deleteArtist(artist);
		
		Album album = new Album();
		AlbumDAO albumDao = new JDBCAlbumDAO();
		
		album.setAlbumName("Acoustic Live in Newcastle ");
		album.setAlbumPublisher("The Soul Cages");
		album.setArtistID(1);
		album.setYearOfPublishing(1991);
		
		albumDao.createAlbum(album);
		albumDao.updateAlbum(album);
		//albumDao.deleteAlbum(album);
		
		Song song = new Song();
		SongDAO songDao = new JDBCSongDAO();

		song.setTitle("Mad About You");
		song.setDuration(3.14);
		song.setSongWriter("Sting");
		song.setGenre("Jazz,Pop");
		song.setArtistID(1);
		song.setAlbumID(20);
		
		songDao.createSong(song);
		songDao.updateSong(song);
		//songDao.deleteSong(song);
		
	}

}
