package media_library.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import media_library.dao.AlbumDAO;
import media_library.entities.Album;

public class JDBCAlbumDAO implements AlbumDAO {
	
	
	/**
	 * Album in database 
	 * -----------------
	 * ID BigSerial
	 * album_name  String 
	 * album_publisher String 
	 * year_of_publishing integer
	 * artist_ID integer (foreign key from artist table)
	 */

	private Connection con;

	private PreparedStatement addStm;
	private PreparedStatement updateStm;
	private PreparedStatement deleteStm;
	private PreparedStatement getAllStm;
	private PreparedStatement getOneStm;

	public JDBCAlbumDAO() {
		con = ConnectionManager.getConnection();
	}

	@Override
	public Album createAlbum(Album a) {
		try {
			//adding  album with parameters from database
			addStm = con.prepareStatement(
					"INSERT INTO \"Album\" (\"album_name\",\"album_publisher\",\"year_of_publishing\",\"artist_ID\")" + "VALUES(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			addStm.setString(1, a.getAlbumName());
			addStm.setString(2, a.getAlbumPublisher());
			addStm.setInt(3, a.getYearOfPublishing());
			addStm.setInt(4, a.getArtistID());

			//executing prepare statement (creating album)
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
	public void deleteAlbum(Album a) {
	
		try {
			//trying to delete album with these parameters
			deleteStm = con.prepareStatement("DELETE FROM \"Album\" WHERE \"ID\" = ?");
			
			deleteStm.setInt(1, a.getID());
			
			//executing statement
			deleteStm.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	@Override
	public void updateAlbum(Album a) {

		try {
			
			//updating album with these parameters
			updateStm = con.prepareStatement(
					"UPDATE \"Album\" SET \"album_name\" = ? , \"album_publisher\" = ? , \"year_of_publishing\" = ? , \"artist_ID\" = ?");

			updateStm.setString(1, a.getAlbumName());
			updateStm.setString(2, a.getAlbumPublisher());
			updateStm.setInt(3, a.getYearOfPublishing());
			updateStm.setInt(4, a.getArtistID());

			//executing statement
			updateStm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	//getting all albums from database
	@Override
	public List<Album> getAllAlbums() {

		List<Album> list;

		list = new ArrayList<Album>();

		try {

			getAllStm = con.prepareStatement("SELECT * FROM \"Album\"");

			ResultSet resultSet = getAllStm.executeQuery();

			while (resultSet.next()) {

				Album album = new Album();

				album.setID(resultSet.getInt("ID"));
				album.setAlbumName(resultSet.getString("album_name"));
				album.setAlbumPublisher(resultSet.getString("album_publisher"));
				album.setYearOfPublishing(resultSet.getInt("year_of_publishing"));
				album.setArtistID(resultSet.getInt("artist_ID"));

				list.add(album);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return list;

	}

	
	//getting one album by ID from database
	@Override
	public Album getAlbum(int id) {

		Album album = new Album();

		try {
			getOneStm = con.prepareStatement("SELECT * FORM \"Album\" WHERE ID = ?");

			getOneStm.setInt(1, id);

			ResultSet resultSet = getOneStm.executeQuery();
			resultSet.next();

			album.setID(resultSet.getInt("ID"));
			album.setAlbumName(resultSet.getString("album_name"));
			album.setAlbumPublisher(resultSet.getString("album_publisher"));
			album.setYearOfPublishing(resultSet.getInt("year_of_publishing"));
			album.setArtistID(resultSet.getInt("artist_ID"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return album;

	}

}
