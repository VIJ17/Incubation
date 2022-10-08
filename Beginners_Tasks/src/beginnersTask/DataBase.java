package beginnersTask;

import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase
{
	
	private String url = "jdbc:mysql://localhost/incubationDB";
	private String userName = "root";
	private String password = "";
	
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
	
	public PreparedStatement createConnection(String sql) throws SQLException
	{
		Connection connection = DriverManager.getConnection(url, userName, password);
		PreparedStatement stmt = connection.prepareStatement(sql);
		return stmt;
			
	}
	
	public void createTableInDataBase(String tableName) throws SQLException
	{
		String sql = "CREATE TABLE "+tableName+" (EMPLOYEE_ID VARCHAR(30) NOT NULL, NAME VARCHAR(30), MOBILE VARCHAR(30), EMAIL VARCHAR(30), DEPARTMENT VARCHAR(30), PRIMARY KEY(EMPLOYEE_ID))";
		PreparedStatement stmt = createConnection(sql);
		stmt.execute();
	}
	
	public void createDependentTable(String tableName, String parentTable, String foreignKey) throws SQLException
	{
		String sql = "CREATE TABLE "+tableName+" (EMPLOYEE_ID VARCHAR(30) NOT NULL, DEPENDENT_ID VARCHAR(30) NOT NULL, NAME VARCHAR(30), AGE INT, RELATIONSHIP VARCHAR(30), PRIMARY KEY(DEPENDENT_ID), FOREIGN KEY ("+foreignKey+") REFERENCES "+parentTable+"("+foreignKey+"))";
		PreparedStatement stmt = createConnection(sql);
		stmt.execute();
	}
	
	public String insertsql(String tableName)
	{
		String sql = "INSERT INTO "+tableName+" VALUES (?, ?, ?, ?, ?)";
		return sql;
	}
	
	public void insertTableDetails(List<EmployeePojo> employeeList, String tableName) throws SQLException
	{
		String sql = insertsql(tableName);
		PreparedStatement stmt = createConnection(sql);
		
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
	
	public void insertDependentTableDetails(List<DependentPojo> dependentList, String tableName) throws SQLException
	{
		String sql = insertsql(tableName);
		PreparedStatement stmt = createConnection(sql);
		
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
	
	public ResultSet getTableDetails(String tableName) throws SQLException
	{
		String sql = "SELECT * FROM "+tableName;
		PreparedStatement stmt = createConnection(sql);
		ResultSet result = stmt.executeQuery();
		return result;
	}
	
	public ResultSet getDependentTableDetails(String tableName, String parentTable, String foreignKey) throws SQLException
	{
		String sql = "SELECT * FROM "+tableName+" INNER JOIN "+parentTable+" ON "+tableName+"."+foreignKey+"="+parentTable+"."+foreignKey;
		PreparedStatement stmt = createConnection(sql);
		ResultSet result = stmt.executeQuery();
		return result;
	}
	//select * from Dependents inner join Employee on Dependents.EMPLOYEE_ID=Employee.EMPLOYEE_ID;
	
	public ResultSet retrieveTableDetails(String tableName, String name) throws SQLException
	{
		String sql = "SELECT * FROM "+tableName+" WHERE NAME = '"+name+"'";
		PreparedStatement stmt = createConnection(sql);
		ResultSet result = stmt.executeQuery();
		return result;
	}
	
	public ResultSet retrieveDependentTableDetails(String tableName, String parentTable, String foreignKey, String employeeID) throws SQLException
	{
		String sql = "SELECT * FROM "+tableName+" INNER JOIN "+parentTable+" ON "+tableName+"."+foreignKey+"="+parentTable+"."+foreignKey+" WHERE "+parentTable+"."+foreignKey+"="+employeeID;
		PreparedStatement stmt = createConnection(sql);
		ResultSet result = stmt.executeQuery();
		return result;
	}
	//select * from Dependents inner join Employee on Dependents.EMPLOYEE_ID=Employee.EMPLOYEE_ID where Employee.EMPLOYEE_ID=1;
	
	public void modifyTableDetails(String tableName, String name, String mobileNumber) throws SQLException
	{
		String sql = "UPDATE "+tableName+" SET MOBILE = "+mobileNumber+" WHERE NAME = '"+name+"'";
		PreparedStatement stmt = createConnection(sql);
		stmt.execute();
	}
	
	public ResultSet getFirstNRecords(String tableName, int n) throws SQLException
	{
		String sql = "SELECT * FROM "+tableName+" LIMIT "+n;
		PreparedStatement stmt = createConnection(sql);
		ResultSet result = stmt.executeQuery();
		return result;
	}
	
	public ResultSet sortDataInAscending(String tableName, String sortID) throws SQLException
	{
		String sql = "SELECT * FROM "+tableName+" ORDER BY "+sortID;
		PreparedStatement stmt = createConnection(sql);
		ResultSet result = stmt.executeQuery();
		return result;
	}
	
	public ResultSet sortDataInDescending(String tableName, String sortID) throws SQLException
	{
		String sql = "SELECT * FROM "+tableName+" ORDER BY "+sortID+" DESC";
		PreparedStatement stmt = createConnection(sql);
		ResultSet result = stmt.executeQuery();
		return result;
	}
	
	public void deleteTableContent(String tableName, String employeeID) throws SQLException
	{
		String sql = "DELETE FROM "+tableName+" WHERE EMPLOYEE_ID = '"+employeeID+"'";
		PreparedStatement stmt = createConnection(sql);
		stmt.execute();
	}
}
