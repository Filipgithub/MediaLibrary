package media_library.hibernate.dao_implementation;

import java.util.List;

import org.hibernate.Session;

import media_library.dao.AlbumDAO;
import media_library.entities.Album;
import media_library.hibernate.persistence.HibernatePersistence;

public class HibernateAlbumDAO implements AlbumDAO {

	private Session session;

	public HibernateAlbumDAO() {
		session = HibernatePersistence.getSessionFactory().openSession();
	}

	// saving album into database
	@Override
	public Album createAlbum(Album a) {
		session.beginTransaction();
		session.save(a);
		System.out.println("Inserted Successfully");
		session.getTransaction().commit();
		return a;
	}

	// deleting album from database
	@Override
	public void deleteAlbum(Album a) {
		session.beginTransaction();
		a = (Album) session.load(Album.class, 24);
		session.delete(a);
		System.out.println("Deleted Successfully");
		session.getTransaction().commit();
	}

	// updating album in database
	@Override
	public void updateAlbum(Album a) {
		session.beginTransaction();
		a = (Album) session.get(Album.class, 22);
		a.setAlbumName("Some new album name!");
		System.out.println("Updated Successfully");
		session.getTransaction().commit();
	}

	// getting all albums from database
	@Override
	public List<Album> getAllAlbums() {
		session.beginTransaction();
		List list = (List<Album>) session.createSQLQuery("SELECT * FROM \"Album\"").addEntity(Album.class).list();
		session.getTransaction().commit();
		return list;
	}

	// getting one album from database
	@Override
	public Album getAlbum(int id) {
		session.beginTransaction();
		Album a = (Album) session.get(Album.class, id);
		session.getTransaction().commit();
		return a;
	}

}
