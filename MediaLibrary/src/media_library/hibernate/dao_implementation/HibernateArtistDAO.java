package media_library.hibernate.dao_implementation;

import java.util.List;

import org.hibernate.Session;

import media_library.dao.ArtistDAO;
import media_library.entities.Artist;
import media_library.hibernate.persistence.HibernatePersistence;

public class HibernateArtistDAO implements ArtistDAO {

	private Session session;

	public HibernateArtistDAO() {
		session = HibernatePersistence.getSessionFactory().openSession();
	}

	// saving artist into database
	@Override
	public Artist createArtist(Artist a) {
		session.beginTransaction();
		session.save(a);
		System.out.println("Inserted Successfully");
		session.getTransaction().commit();
		return a;
	}

	// deleting artist from database
	@Override
	public void deleteArtist(Artist a) {
		session.beginTransaction();
		a = (Artist) session.load(Artist.class, 33);
		session.delete(a);
		System.out.println("Deleted Successfully");
		session.getTransaction().commit();
	}

	// updating artist name in database
	@Override
	public void updateArtist(Artist a) {
		session.beginTransaction();
		a = (Artist) session.get(Artist.class, 35);
		a.setArtistName("Some new artist name!");
		System.out.println("Updated Successfully");
		session.getTransaction().commit();
	}

	// getting all artists from database
	@Override
	public List<Artist> getAllArtist() {
		session.beginTransaction();
		List list = (List<Artist>) session.createSQLQuery("SELECT * FROM \"Artist\"").addEntity(Artist.class).list();
		session.getTransaction().commit();
		return list;
	}

	// getting one artist from database
	@Override
	public Artist getArtist(int id) {
		session.beginTransaction();
		Artist a = (Artist) session.get(Artist.class, id);
		session.getTransaction().commit();
		return a;

	}

}
