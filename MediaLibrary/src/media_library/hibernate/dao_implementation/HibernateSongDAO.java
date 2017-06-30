package media_library.hibernate.dao_implementation;

import java.util.List;

import org.hibernate.Session;

import media_library.dao.SongDAO;
import media_library.entities.Artist;
import media_library.entities.Song;
import media_library.hibernate.persistence.HibernatePersistence;

public class HibernateSongDAO implements SongDAO {

	private Session session;

	public HibernateSongDAO() {
		session = HibernatePersistence.getSessionFactory().openSession();
	}

	// saving song into databse
	@Override
	public Song createSong(Song a) {
		session.beginTransaction();
		session.save(a);
		System.out.println("Inserted Successfully");
		session.getTransaction().commit();
		return a;
	}

	// deleting song from database
	@Override
	public void deleteSong(Song a) {
		session.beginTransaction();
		a = (Song) session.load(Song.class, 10);
		session.delete(a);
		System.out.println("Deleted Successfully");
		session.getTransaction().commit();
	}

	// updating song in database
	@Override
	public void updateSong(Song a) {
		session.beginTransaction();
		a = (Song) session.get(Song.class, 13);
		a.setSongWriter("Some new song writer name!");
		System.out.println("Updated Successfully");
		session.getTransaction().commit();
	}

	// getting all songs from database
	@Override
	public List<Song> getAllSong() {
		session.beginTransaction();
		List list = (List<Song>) session.createSQLQuery("SELECT * FROM \"Song\"").addEntity(Song.class).list();
		session.getTransaction().commit();
		return list;
	}

	// getting one song from database
	@Override
	public Song getSong(int id) {
		session.beginTransaction();
		Song a = (Song) session.get(Song.class, id);
		session.getTransaction().commit();
		return a;

	}

}
