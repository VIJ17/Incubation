package beginnersTask;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase
{
	
	private String url = "jdbc:mysql://localhost/incubationDB";
	private String userName = "root";
	private String password = "Root@123";
	
	public void setUrl(String url)
	{
		this.url = url;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getUrl()
	{
		return url;
	}
	public String getUserName()
	{
		return userName;
	}
	public String getPassword()
	{
		return password;
	}
	
	private Connection createConnection() throws SQLException
	{
		Connection connection = DriverManager.getConnection(url, userName, password);
		return connection;
	}
	
	private PreparedStatement createPreparedStatement(Connection connection, String sql) throws SQLException
	{
		PreparedStatement stmt = connection.prepareStatement(sql);
		return stmt;
	}
	
	public void createTableInDataBase(String tableName, String sql) throws SQLException
	{
		sql = "CREATE TABLE "+tableName+" ("+sql+")";
		
		try(Connection connection = createConnection();
				PreparedStatement stmt = createPreparedStatement(connection, sql);)
		{
			stmt.execute();
		}
		
	}
//	"CREATE TABLE "+tableName+" (EMPLOYEE_ID VARCHAR(30) NOT NULL, NAME VARCHAR(30), MOBILE VARCHAR(30), EMAIL VARCHAR(30), DEPARTMENT VARCHAR(30), PRIMARY KEY(EMPLOYEE_ID))";

	public void createDependentTable(String tableName, String sql, String parentTable, String foreignKey) throws SQLException
	{
		sql = "CREATE TABLE "+tableName+" ("+sql+", FOREIGN KEY ("+foreignKey+") REFERENCES "+parentTable+"("+foreignKey+"))";

		try(Connection connection = createConnection();
				PreparedStatement stmt = createPreparedStatement(connection, sql);)
		{
			stmt.execute();
		}
		
	}
//	"CREATE TABLE "+tableName+" (EMPLOYEE_ID VARCHAR(30) NOT NULL, DEPENDENT_ID VARCHAR(30) NOT NULL, NAME VARCHAR(30), AGE INT, RELATIONSHIP VARCHAR(30), PRIMARY KEY(DEPENDENT_ID), FOREIGN KEY ("+foreignKey+") REFERENCES "+parentTable+"("+foreignKey+"))";
	
	private String getValuesString(int n)
	{
		List<String> valuesArray = new ArrayList<String>();
		
		for(int i = 0; i<n; i++)
		{
			valuesArray.add("?");
		}
		
		String valuesString = String.join(", ", valuesArray);
		
		return valuesString;
	}
	
	private String insertsql(String tableName, int n)
	{
		String valuesString = getValuesString(n);
		String sql = "INSERT INTO "+tableName+" VALUES ("+valuesString+")";
		return sql;
	}
	
	private ResultSet getTableDetailsAsResultSet(String tableName) throws SQLException
	{
		String sql = "SELECT * FROM "+tableName;
		
		try(Connection connection = createConnection();
				PreparedStatement stmt = createPreparedStatement(connection, sql);)
		{
			ResultSet result = stmt.executeQuery();
			return result;
		}
		
	}
	
	private int getNoOfColumns(ResultSet result) throws SQLException
	{
		ResultSetMetaData metadata = result.getMetaData();
		int numberOfColumns = metadata.getColumnCount();
		return numberOfColumns;
	}
	
	public void insertTableDetails(List<EmployeePojo> employeeList, String tableName) throws SQLException
	{
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
		ResultSet result = getTableDetailsAsResultSet(tableName);
		int n = getNoOfColumns(result);
		
		String sql = insertsql(tableName, n);
		
		connection = createConnection();
		stmt = createPreparedStatement(connection, sql);
		
		for(EmployeePojo pojo : employeeList)
		{
			stmt.setString(1, pojo.getEmployeeId());
			stmt.setString(2, pojo.getName());
			stmt.setString(3, pojo.getMobileNum());
			stmt.setString(4, pojo.getEmailId());
			stmt.setString(5, pojo.getDepartment());
			
			stmt.addBatch();
		}
			stmt.executeBatch();
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}
	
	public void insertDependentTableDetails(List<DependentPojo> dependentList, String tableName) throws SQLException
	{
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try
		{
		ResultSet result = getTableDetailsAsResultSet(tableName);
		int n = getNoOfColumns(result);
		
		String sql = insertsql(tableName, n);
		
		connection = createConnection();
		stmt = createPreparedStatement(connection, sql);
		
		for(DependentPojo pojo : dependentList)
		{
			stmt.setString(1, pojo.getEmployeeId());
			stmt.setString(2, pojo.getDependentId());
			stmt.setString(3, pojo.getName());
			stmt.setInt(4, pojo.getAge());
			stmt.setString(5, pojo.getRelationship());
			
			stmt.addBatch();
		}
			stmt.executeBatch();
		}
		finally
		{
			closeStatement(stmt);
			closeConnection(connection);
		}
	}
	
	private List<EmployeePojo> convertResultToList(ResultSet result) throws SQLException
	{
		List<EmployeePojo> list = new ArrayList<EmployeePojo>();
		
		while(result.next())
		{
			EmployeePojo emplPojo = new EmployeePojo();
			
			emplPojo.setEmployeeId(result.getString("EMPLOYEE_ID"));
			emplPojo.setDepartment(result.getString("DEPARTMENT"));
			emplPojo.setEmailId(result.getString("EMAIL"));
			emplPojo.setMobileNum(result.getString("MOBILE"));
			emplPojo.setName(result.getString("NAME"));
			
			list.add(emplPojo);
			
		}
		return list;
	}
	
	private Map<Integer,List<Object>> convertResultToMapCombined(ResultSet result) throws SQLException
	{
		Map<Integer,List<Object>> map = new LinkedHashMap<>();
		
		int key = 1;
		
		while(result.next())
		{
			EmployeePojo emplPojo = new EmployeePojo();
			DependentPojo depPojo = new DependentPojo();
			
			List<Object> list = new ArrayList<>();
			
			emplPojo.setName(result.getString("Employee.NAME"));
			emplPojo.setEmployeeId(result.getString("EMPLOYEE_ID"));
			emplPojo.setMobileNum(result.getString("MOBILE"));
			emplPojo.setEmailId(result.getString("EMAIL"));
			emplPojo.setDepartment(result.getString("DEPARTMENT"));
			
			list.add(emplPojo);
			
			depPojo.setName(result.getString("Dependents.NAME"));
			depPojo.setAge(result.getInt("AGE"));
			depPojo.setRelationship(result.getString("RELATIONSHIP"));
			
			list.add(depPojo);
			
			map.put(key, list);
			
			key++;
		}

		return map;
	}
	
	public List<EmployeePojo> getTableDetails(String tableName) throws SQLException
	{
		String sql = "SELECT * FROM "+tableName;
		
		try(Connection connection = createConnection();
		PreparedStatement stmt = createPreparedStatement(connection, sql);)
		{
			ResultSet result = stmt.executeQuery();
			
			return convertResultToList(result);
			
		}
	}
	
	public Map<Integer,List<Object>> getDependentTableDetails(String tableName, String parentTable, String foreignKey, String sortID, int n) throws SQLException
	{
		String sql = "SELECT * FROM "+parentTable+" INNER JOIN "+tableName+" ON "+parentTable+"."+foreignKey+"="+tableName+"."+foreignKey+" ORDER BY "+parentTable+"."+sortID+" LIMIT ?";
		
		try(Connection connection = createConnection();
		PreparedStatement stmt = createPreparedStatement(connection, sql);)
		{
			stmt.setInt(1, n);
			
			ResultSet result = stmt.executeQuery();
				
			return convertResultToMapCombined(result);
				
		}
	}
	//select * from Employee inner join Dependents on Employee.EMPLOYEE_ID=Dependents.EMPLOYEE_ID order by Employee.NAME limit 5;
	
	public List<EmployeePojo> retrieveTableDetails(String tableName, String name) throws SQLException
	{
		String sql = "SELECT * FROM "+tableName+" WHERE NAME = ?";
		
		try(Connection connection = createConnection();
		PreparedStatement stmt = createPreparedStatement(connection, sql);)
		{	
			stmt.setString(1, name);
			
			ResultSet result = stmt.executeQuery();
			
			return convertResultToList(result);
			
		}
	}
	
	public Map<Integer,List<Object>> retrieveDependentTableDetails(String tableName, String parentTable, String foreignKey, String employeeID) throws SQLException
	{
		String sql = "SELECT * FROM "+parentTable+" INNER JOIN "+tableName+" ON "+parentTable+"."+foreignKey+"="+tableName+"."+foreignKey+" WHERE "+parentTable+"."+foreignKey+"= ?";
		
		try(Connection connection = createConnection();
		PreparedStatement stmt = createPreparedStatement(connection, sql);)
		{
			stmt.setString(1, employeeID);
			
			ResultSet result = stmt.executeQuery();
				
			return convertResultToMapCombined(result);
				
		}
	}
	//select * from Dependents inner join Employee on Dependents.EMPLOYEE_ID=Employee.EMPLOYEE_ID where Employee.EMPLOYEE_ID=1;
	
	public List<EmployeePojo> modifyTableDetails(String tableName, String name, String mobileNumber) throws SQLException
	{
		String sql = "UPDATE "+tableName+" SET MOBILE = "+mobileNumber+" WHERE NAME = ?";
		
		try(Connection connection = createConnection();
		PreparedStatement stmt = createPreparedStatement(connection, sql);)
		{
			stmt.setString(1, name);
			
			ResultSet result = stmt.executeQuery();
			
			return convertResultToList(result);
			
		}
	}
	
	public List<EmployeePojo> getFirstNRecords(String tableName, int n) throws SQLException
	{
		String sql = "SELECT * FROM "+tableName+" LIMIT ?";
		
		try(Connection connection = createConnection();
		PreparedStatement stmt = createPreparedStatement(connection, sql);)
		{
			stmt.setInt(1, n);
			
			ResultSet result = stmt.executeQuery();
			
			return convertResultToList(result);
			
		}
	}
	
	public List<EmployeePojo> sortDataInAscending(String tableName, String sortID, int n) throws SQLException
	{
		String sql = "SELECT * FROM "+tableName+" ORDER BY "+sortID+" LIMIT ?";
		
		try(Connection connection = createConnection();
		PreparedStatement stmt = createPreparedStatement(connection, sql);)
		{
			stmt.setInt(1, n);
			
			ResultSet result = stmt.executeQuery();
			
			return convertResultToList(result);
			
		}
	}
	
	public List<EmployeePojo> sortDataInDescending(String tableName, String sortID, int n) throws SQLException
	{
		String sql = "SELECT * FROM "+tableName+" ORDER BY "+sortID+" DESC LIMIT ?";
		
		try(Connection connection = createConnection();
		PreparedStatement stmt = createPreparedStatement(connection, sql);)
		{
			stmt.setInt(1, n);
			
			ResultSet result = stmt.executeQuery();
			
			return convertResultToList(result);
			
		}
	}
	
	public List<EmployeePojo> deleteTableContent(String tableName, String employeeID) throws SQLException
	{
		String sql = "DELETE FROM "+tableName+" WHERE EMPLOYEE_ID = ?";
		
		try(Connection connection = createConnection();
		PreparedStatement stmt = createPreparedStatement(connection, sql);)
		{
			stmt.setString(1, employeeID);
			ResultSet result = stmt.executeQuery();
			
			return convertResultToList(result);
		}
	}
	
	public void closeStatement(Statement stmt)
	{
		try
		{
			stmt.close();
		}
		catch(Exception e) {}
	}
	
	public void closeConnection(Connection connection)
	{
		try
		{
			connection.close();
		}
		catch(Exception e) {}
	}
}
