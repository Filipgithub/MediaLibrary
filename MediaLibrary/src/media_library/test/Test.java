package media_library.test;

import java.util.ArrayList;

import media_library.dao.AlbumDAO;
import media_library.dao.ArtistDAO;
import media_library.dao.SongDAO;
import media_library.entities.Album;
import media_library.entities.Artist;
import media_library.entities.Song;
import media_library.hibernate.dao_implementation.HibernateAlbumDAO;
import media_library.hibernate.dao_implementation.HibernateArtistDAO;
import media_library.hibernate.dao_implementation.HibernateSongDAO;

public class Test {

	public static void main(String[] args) {

		Artist artist = new Artist();
		/**
		 * Creating artistDao with JDBC connection
		 */
		// ArtistDAO artistDao = new JDBCArtistDAO();

		/**
		 * Creating artistDAO with Hibernate
		 */
		ArtistDAO artistDAO = new HibernateArtistDAO();

		artist.setFirstName("Gordon Matthew Thomas");
		artist.setLastName("Sumner");
		artist.setArtistName("String");

		//tests creating artist
		// artistDAO.createArtist(artist);

		//testing artist update
		//artistDAO.updateArtist(artist);
		
		//testing artist deleting
		// artistDAO.deleteArtist(artist);

		// testing get all artist
		ArrayList<Artist> artists = (ArrayList<Artist>) artistDAO.getAllArtist();
		for (Artist a : artists)
			System.out.println(a);

		// testing get one artist by id
		System.out.println(artistDAO.getArtist(10).getFirstName());

		// ***********************************************************
		// creating album
		Album album = new Album();

		/**
		 * Creating albumDao with JDBC
		 */
		// AlbumDAO albumDao = new JDBCAlbumDAO();

		/**
		 * Creating albumDAO with Hibernate
		 */
		AlbumDAO albumDao = new HibernateAlbumDAO();

		album.setAlbumName("Acoustic Live in Newcastle ");
		album.setAlbumPublisher("The Soul Cages");
		album.setArtistID(1);
		album.setYearOfPublishing(1991);

		//testing album creating 
		// albumDao.createAlbum(album);
		
		//testing album updating
		 //albumDao.updateAlbum(album);
		
		//testing album deleting
		// albumDao.deleteAlbum(album);

		// testing get all albums
		ArrayList<Album> albums = (ArrayList<Album>) albumDao.getAllAlbums();
		for (Album a : albums)
			System.out.println(a);

		// testing get one album by id
		System.out.println(albumDao.getAlbum(20).getAlbumPublisher());

		// ********************************************************
		// creating song
		Song song = new Song();

		/**
		 * Creating Song with JDBC
		 */
		// SongDAO songDao = new JDBCSongDAO();

		/**
		 * Creating songDAO with Hibernate
		 */
		SongDAO songDao = new HibernateSongDAO();

		song.setTitle("Mad About You");
		song.setDuration(3.14);
		song.setSongWriter("Sting");
		song.setGenre("Jazz,Pop");
		song.setArtistID(1);
		song.setAlbumID(21);

		//tests creating song
		// songDao.createSong(song);
		
		//testing song update
		 songDao.updateSong(song);
		
		//tests deleting song
		 songDao.deleteSong(song);

		// testing get all songs
		ArrayList<Song> songs = (ArrayList<Song>) songDao.getAllSong();
		for (Song s : songs)
			System.out.println(s);

		// testing get one song by id
		System.out.println(songDao.getSong(14).getTitle());
	}

}
