package media_library.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import media_library.dao.ArtistDAO;
import media_library.entities.Artist;

public class JDBCArtistDAO implements ArtistDAO{
	
	
	/**
	 * Artist in database 
	 * -----------------
	 * ID BigSerial
	 * first_name  String 
	 * last_name String 
	 * artist_name String
	 */
	
	private Connection con;

	private PreparedStatement addStm;
	private PreparedStatement updateStm;
	private PreparedStatement deleteStm;
	private PreparedStatement getAllStm;
	private PreparedStatement getOneStm;

	public JDBCArtistDAO() {
		con = ConnectionManager.getConnection();
	}
	
	//creating artist with parameters from database
	@Override
	public Artist createArtist(Artist a) {
		try {
			addStm = con.prepareStatement(
					"INSERT INTO \"Artist\" (\"first_name\", \"last_name\" , \"artist_name\")" + "VALUES(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			addStm.setString(1, a.getFirstName());
			addStm.setString(2, a.getLastName());
			addStm.setString(3, a.getArtistName());

			//executing statement 
			addStm.execute();

			ResultSet keys = addStm.getGeneratedKeys();
			keys.next();
			int key = keys.getInt(1);

			a.setID(key);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	
	@Override
	public void deleteArtist(Artist a) {
	
		try {
			
			deleteStm = con.prepareStatement("DELETE FROM \"Artist\" WHERE \"ID\" = ?");
			
			deleteStm.setInt(1, a.getID());
			
			deleteStm.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	//updating artist 
	@Override
	public void updateArtist(Artist a) {

		try {

			updateStm = con.prepareStatement(
					"UPDATE \"Artist\" SET \"first_name\" = ? , \"last_name\" = ? , \"artist_name\" = ?");

			updateStm.setString(1, a.getFirstName());
			updateStm.setString(2, a.getLastName());
			updateStm.setString(3, a.getArtistName());

			//executing statement
			updateStm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	//getting all artists from database
	@Override
	public List<Artist> getAllArtist() {

		List<Artist> list;

		list = new ArrayList<Artist>();

		try {

			getAllStm = con.prepareStatement("SELECT * FROM \"Artist\"");

			ResultSet resultSet = getAllStm.executeQuery();

			while (resultSet.next()) {

				Artist artist = new Artist();

				artist.setID(resultSet.getInt("ID"));
				artist.setFirstName(resultSet.getString("first_name"));
				artist.setLastName(resultSet.getString("last_name"));
				artist.setArtistName(resultSet.getString("artist_name"));
			

				list.add(artist);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return list;

	}
	
	//getting one artist by ID from database
	@Override
	public Artist getArtist(int id) {

		Artist artist = new Artist();

		try {
			getOneStm = con.prepareStatement("SELECT * FORM \"Artist\" WHERE \"ID\" = ?");

			getOneStm.setInt(1, id);

			ResultSet resultSet = getOneStm.executeQuery();
			resultSet.next();

			artist.setID(resultSet.getInt("ID"));
			artist.setFirstName(resultSet.getString("first_name"));
			artist.setLastName(resultSet.getString("last_name"));
			artist.setArtistName(resultSet.getString("artist_name"));
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return artist;

	}

	

}
