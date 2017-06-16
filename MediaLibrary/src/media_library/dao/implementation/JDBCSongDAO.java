package media_library.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import media_library.dao.SongDAO;
import media_library.entities.Song;

public class JDBCSongDAO implements SongDAO {

	private Connection con;

	private PreparedStatement addStm;
	private PreparedStatement updateStm;
	private PreparedStatement deleteStm;
	private PreparedStatement getAllStm;
	private PreparedStatement getOneStm;

	public JDBCSongDAO() {
		con = ConnectionManager.getConnection();
	}
	
	//adding song to database with these parameters
	@Override
	public Song createSong(Song s) {
		try {
			addStm = con.prepareStatement(
					"INSERT INTO \"Song\" (\"title\",\"duration\",\"song_writer\",\"genre\",\"artist_ID\",\"album_ID\")" + "VALUES(?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			addStm.setString(1, s.getTitle());
			addStm.setDouble(2, s.getDuration());
			addStm.setString(3, s.getSongWriter());
			addStm.setString(4, s.getGenre());
			addStm.setInt(5, s.getArtistID());
			addStm.setInt(6, s.getAlbumID());

			//executing statement
			addStm.execute();

			ResultSet keys = addStm.getGeneratedKeys();
			keys.next();
			int key = keys.getInt(1);

			s.setID(key);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	//deleting song from database
	@Override
	public void deleteSong(Song s) {
	
		try {
			
			deleteStm = con.prepareStatement("DELETE FROM \"Song\" WHERE \"ID\" = ?");
			
			deleteStm.setInt(1, s.getID());
			
			deleteStm.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	//updating song in database
	@Override
	public void updateSong(Song s) {

		try {

			updateStm = con.prepareStatement(
					"UPDATE \"Song\" SET \"title\" = ? , \"duration\" = ? , \"song_writer\" = ? , \"genre\" = ?, \"artist_ID\" = ?, \"album_ID\" = ?");

			updateStm.setString(1, s.getTitle());
			updateStm.setDouble(2, s.getDuration());
			updateStm.setString(3, s.getSongWriter());
			updateStm.setString(4, s.getGenre());
			updateStm.setInt(5, s.getArtistID());
			updateStm.setInt(6, s.getAlbumID());

			
            //executing update statement
			updateStm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//getting all songs from database
	@Override
	public List<Song> getAllSong() {

		List<Song> list;

		list = new ArrayList<Song>();

		try {

			getAllStm = con.prepareStatement("SELECT * FROM \"Song\"");

			ResultSet resultSet = getAllStm.executeQuery();

			while (resultSet.next()) {

				Song s = new Song();

				s.setID(resultSet.getInt("ID"));
				s.setTitle(resultSet.getString("title"));
				s.setDuration(resultSet.getDouble("duration"));
				s.setSongWriter(resultSet.getString("song_writer"));
				s.setGenre(resultSet.getString("genre"));
				s.setArtistID(resultSet.getInt("artist_ID"));
				s.setAlbumID(resultSet.getInt("album_ID"));
				
				list.add(s);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return list;

	}
	
	
	//getting one song by ID from database
	@Override
	public Song getSong(int id) {

		Song s = new Song();

		try {
			getOneStm = con.prepareStatement("SELECT * FORM \"Song\" WHERE \"ID\" = ?");

			getOneStm.setInt(1, id);

			ResultSet resultSet = getOneStm.executeQuery();
			resultSet.next();

			s.setID(resultSet.getInt("ID"));
			s.setTitle(resultSet.getString("title"));
			s.setDuration(resultSet.getDouble("duration"));
			s.setSongWriter(resultSet.getString("song_writer"));
			s.setGenre(resultSet.getString("genre"));
			s.setArtistID(resultSet.getInt("artist_ID"));
			s.setAlbumID(resultSet.getInt("album_ID"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;

	}
}
