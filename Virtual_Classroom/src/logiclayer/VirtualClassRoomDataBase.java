package logiclayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;

import datacarier.MaterialDetails;
import datacarier.QADetails;
import datacarier.UserDetails;
import exceptions.WrongEntryException;
import virtualclassroomframe.VirtualClassRoomInterface;

public class VirtualClassRoomDataBase implements VirtualClassRoomInterface
{
	
	private String url = "jdbc:mysql://localhost/VIRTUAL_CLASSROOM";
	private String userName = "root";
	private String password = "Root@123";
	
	private void closeStatement(PreparedStatement stmt)
	{
		try
		{
			stmt.close();
		}
		catch(Exception e) {}
	}
	
	private void closeConnection(Connection connection)
	{
		try
		{
			connection.close();
		}
		catch(Exception e) {}
	}
	
	private Connection createConnection() throws SQLException
	{
		Connection connection = DriverManager.getConnection(url, userName, password);
		
		return connection;
	}
	
	private PreparedStatement createPreparedStatement(String sql, Connection connection) throws SQLException
	{
		PreparedStatement stmt = connection.prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		return stmt;
	}
	
	private void dataAvailabilityCheck(ResultSet result) throws WrongEntryException, SQLException
	{
		if(result.next() == false)
		{
			throw new WrongEntryException("UserID or Password is incorrect.");
		}
		else if(result.getString("STATUS").equals("INACTIVE"))
		{
			throw new WrongEntryException("Your ID is INACTIVE. \nPlease contact Admin.");
		}
		else if(result.getString("STATUS").equals("PENDING"))
		{
			throw new WrongEntryException("Your ID is pending for approval. \nPlease contact Admin.");
		}
	}
	
	@Override
	public UserDetails userRegistration(UserDetails userDetails) throws WrongEntryException
	{
		String password = userDetails.getPassword();
		String name = userDetails.getName();
		int age = userDetails.getAge();
		long mobile = userDetails.getMobile();
		String email = userDetails.getEmail();
		String role = userDetails.getRole();
		String department = userDetails.getDepartment();
		
		String sql = "INSERT INTO USER_DETAILS (PASSWORD, NAME, AGE, MOBILE, EMAIL, ROLE, DEPARTMENT, STATUS) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setString(1, password);
			stmt.setNString(2, name);
			stmt.setInt(3, age);
			stmt.setLong(4, mobile);
			stmt.setString(5, email);
			stmt.setString(6, role);
			stmt.setString(7, department);
			stmt.setString(8, "PENDING");
			
			stmt.execute();
			
			stmt.close();							//Closing statement...
			
			sql = "SELECT * FROM USER_DETAILS WHERE NAME = ? AND PASSWORD = ?";
			
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setString(1, name);
			stmt.setString(2, password);
			
			ResultSet result = stmt.executeQuery();
			
			while(result.next())
			{
				userDetails.setUserID(result.getLong("USER_ID"));
				userDetails.setStatus(result.getString("STATUS"));
			}
			
			return userDetails;
		}
		catch(SQLException e)
		{
			throw new WrongEntryException(e);
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}

	@Override
	public UserDetails userLogin(long userID, String password) throws WrongEntryException
	{
		String sql = "SELECT * FROM USER_DETAILS WHERE USER_ID = ? AND PASSWORD = ?";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, userID);
			stmt.setString(2, password);
			
			ResultSet result = stmt.executeQuery();
			
			dataAvailabilityCheck(result);
			result.beforeFirst();
			UserDetails userDetails = new UserDetails();
			
			while(result.next())
			{
				userDetails.setUserID(result.getLong("USER_ID"));
				userDetails.setPassword(result.getString("PASSWORD"));
				userDetails.setName(result.getString("NAME"));
				userDetails.setAge(result.getInt("AGE"));
				userDetails.setEmail(result.getString("EMAIL"));
				userDetails.setMobile(result.getLong("MOBILE"));
				userDetails.setRole(result.getString("ROLE"));
				userDetails.setDepartment(result.getString("DEPARTMENT"));
				userDetails.setStatus(result.getString("STATUS"));
			}
			
			return userDetails;
		}
		catch(SQLException e)
		{
			throw new WrongEntryException(e);
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}

	@Override
	public boolean editProfile(UserDetails userDetails) throws WrongEntryException
	{
		String name = userDetails.getName();
		int age = userDetails.getAge();
		long mobile = userDetails.getMobile();
		String email = userDetails.getEmail();
		
		String sql = "UPDATE USER_DETAILS SET NAME = ?, AGE = ?, MOBILE = ?, EMAIL = ? WHERE USER_ID = ?";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setString(1, name);
			stmt.setInt(3, age);
			stmt.setLong(4, mobile);
			stmt.setString(5, email);
			
			boolean result = stmt.execute();
			
			return result;
		}
		catch(SQLException e)
		{
			throw new WrongEntryException(e);
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}

	@Override
	public Map<Integer, MaterialDetails> showMaterials() throws WrongEntryException
	{
		String sql = "SELECT * FROM MATERIAL_DETAILS";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			stmt = createPreparedStatement(sql, connection);
			
			ResultSet result = stmt.executeQuery();
			Map<Integer, MaterialDetails> materialMap = new Hashtable<>();
			int i = 1;
			
			while(result.next())
			{
				MaterialDetails materialDetails = new MaterialDetails();
				materialDetails.setMaterialID(result.getLong("MATERIAL_ID"));
				materialDetails.setPostedBy(result.getLong("POSTED_BY"));
				materialDetails.setTitle(result.getString("TITLE"));
				materialDetails.setContent(result.getString("CONTENT"));
				materialMap.put(i, materialDetails);
				i++;
			}
			
			return materialMap;
		}
		catch(SQLException e)
		{
			throw new WrongEntryException(e);
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}

	@Override
	public boolean uploadMaterials(MaterialDetails materialDetails) throws WrongEntryException
	{
		long postedBy = materialDetails.getPostedBy();
		String title = materialDetails.getTitle();
		String content = materialDetails.getContent();
		
		String sql = "INSERT INTO MATERIAL_DETAILS (POSTED_BY, TITLE, CONTENT) VALUES (?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, postedBy);
			stmt.setString(2, title);
			stmt.setString(3, content);
			
			boolean result = stmt.execute();
			
			return result;
		}
		catch(SQLException e)
		{
			throw new WrongEntryException(e);
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}
	
	@Override
	public void removeMaterial(long materialID) throws WrongEntryException
	{
		String sql = "DELETE FROM MATERIAL_DETAILS WHERE MATERIAL_ID = ?";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, materialID);
			
			stmt.execute();
		}
		catch(SQLException e)
		{
			throw new WrongEntryException(e);
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}

	@Override
	public void askQuestion(QADetails qaDetails) throws WrongEntryException
	{
		long materialID = qaDetails.getMaterialID();
		String question = qaDetails.getQuestion();
		
		String sql = "INSERT INTO QA_DETAILS (MATERIAL_ID, QUESTION) VALUES (?, ?)";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, materialID);
			stmt.setString(2, question);
			
			stmt.execute();
		}
		catch(SQLException e)
		{
			throw new WrongEntryException(e);
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}

	@Override
	public Map<Integer, QADetails> showAnswers() throws WrongEntryException
	{
		String sql = "SELECT * FROM QA_DETAILS";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			stmt = createPreparedStatement(sql, connection);
			
			ResultSet result = stmt.executeQuery();
			Map<Integer, QADetails> qaMap = new Hashtable<>();
			int i = 1;
			
			while(result.next())
			{
				QADetails qaDetails = new QADetails();
				qaDetails.setQuestionID(result.getLong("QUESTION_ID"));
				qaDetails.setMaterialID(result.getLong("MATERIAL_ID"));
				qaDetails.setTitle(result.getString("TITLE"));
				qaDetails.setQuestion(result.getString("QUESTION"));
				qaDetails.setAnswer(result.getString("ANSWER"));
				qaMap.put(i, qaDetails);
			}
			
			return qaMap;
		}
		catch(SQLException e)
		{
			throw new WrongEntryException(e);
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}

	@Override
	public Map<Integer, QADetails> showQuestions(long postedBy) throws WrongEntryException
	{
		String sql = "SELECT * FROM QA_DETAILS INNER JOIN MATERIAL_DETAILS ON QA_DETAILS.MATERIAL_ID = MATERIAL_DETAILS.MATERIAL_ID WHERE QA_DETAILS.ANSWER IS NULL AND MATERIAL_DETAILS.POSTED_BY = ?";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, postedBy);
			
			ResultSet result = stmt.executeQuery();
			Map<Integer, QADetails> qaMap = new Hashtable<>();
			int i = 1;
			
			while(result.next())
			{
				QADetails qaDetails = new QADetails();
				qaDetails.setQuestionID(result.getLong("QUESTION_ID"));
				qaDetails.setMaterialID(result.getLong("MATERIAL_ID"));
				qaDetails.setTitle(result.getString("TITLE"));
				qaDetails.setQuestion(result.getString("QUESTION"));
				qaMap.put(i, qaDetails);
				i++;
			}
			
			return qaMap;
		}
		catch(SQLException e)
		{
			throw new WrongEntryException(e);
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}

	@Override
	public void uploadAnswers(QADetails qaDetails) throws WrongEntryException
	{
		String answer = qaDetails.getAnswer();
		long questionID = qaDetails.getQuestionID();
		
		String sql = "UPDATE QA_DETAILS SET ANSWER = ? WHERE QUESTION_ID = ?";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setString(1, answer);
			stmt.setLong(2, questionID);
			
			stmt.execute();
		}
		catch(SQLException e)
		{
			throw new WrongEntryException(e);
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}

	@Override
	public Map<Integer, UserDetails> getUsersList() throws WrongEntryException
	{
		String sql = "SELECT NAME, ROLE, STATUS FROM USER_DETAILS WHERE STATUS = 'ACTIVE'";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			stmt = createPreparedStatement(sql, connection);
			
			ResultSet result = stmt.executeQuery();
			Map<Integer, UserDetails> usersMap = new Hashtable<>();
			int i = 1;
			
			while(result.next())
			{
				UserDetails userDetails = new UserDetails();
				userDetails.setName(result.getString("NAME"));
				userDetails.setRole(result.getString("ROLE"));
				userDetails.setStatus(result.getString("STATUS"));
				usersMap.put(i, userDetails);
				i++;
			}
			
			return usersMap;
		}
		catch(SQLException e)
		{
			throw new WrongEntryException(e);
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}

	@Override
	public Map<Integer, UserDetails> showRequest() throws WrongEntryException
	{
		String sql = "SELECT * FROM USER_DETAILS WHERE STATUS = 'PENDING'";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			stmt = createPreparedStatement(sql, connection);
			
			ResultSet result = stmt.executeQuery();
			Map<Integer, UserDetails> usersMap = new Hashtable<>();
			int i = 1;
			
			while(result.next())
			{
				UserDetails userDetails = new UserDetails();
				userDetails.setUserID(result.getLong("USER_ID"));
				userDetails.setName(result.getString("NAME"));
				userDetails.setAge(result.getInt("AGE"));
				userDetails.setMobile(result.getLong("MOBILE"));
				userDetails.setEmail(result.getString("EMAIL"));
				userDetails.setRole(result.getString("ROLE"));
				userDetails.setDepartment(result.getString("DEPARTMENT"));
				userDetails.setStatus(result.getString("STATUS"));
				usersMap.put(i, userDetails);
				i++;
			}
			
			return usersMap;
		}
		catch(SQLException e)
		{
			throw new WrongEntryException(e);
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}

	@Override
	public Map<Integer, QADetails> showQuestionsAndAnswers() throws WrongEntryException
	{
		String sql = "SELECT * FROM QA_DETAILS";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			stmt = createPreparedStatement(sql, connection);
			
			ResultSet result = stmt.executeQuery();
			Map<Integer, QADetails> qaMap = new Hashtable<>();
			int i = 1;
			
			while(result.next())
			{
				QADetails qaDetails = new QADetails();
				qaDetails.setQuestionID(result.getLong("QUESTION_ID"));
				qaDetails.setMaterialID(result.getLong("MATERIAL_ID"));
				qaDetails.setQuestion(result.getString("QUESTION"));
				qaDetails.setAnswer(result.getString("ANSWER"));
				qaMap.put(i, qaDetails);
				i++;
			}
			
			return qaMap;
		}
		catch(SQLException e)
		{
			throw new WrongEntryException(e);
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}

	@Override
	public void deleteQADetails(long questionID) throws WrongEntryException
	{
		String sql = "DELETE * FROM QA_DETAILS WHERE QUESTION_ID = ?";
		
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
			connection = createConnection();
			stmt = createPreparedStatement(sql, connection);
			
			stmt.setLong(1, questionID);
			stmt.execute();
		}
		catch(SQLException e)
		{
			throw new WrongEntryException(e);
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}

}
