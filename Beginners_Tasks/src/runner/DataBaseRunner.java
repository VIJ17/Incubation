package runner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import beginnersTask.DataBase;
import beginnersTask.DependentPojo;
import beginnersTask.EmployeePojo;

public class DataBaseRunner
{
	
	static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	static Scanner sc = new Scanner(System.in);
	
	private int getInteger()
	{
		int value = sc.nextInt();
		sc.nextLine();
		return value;
	}
	
	private String getString()
	{
		String str = sc.nextLine();
		return str;
	}
	
	private String getDataTypeForColumns()
	{
		logger.info("Enter the data type of the column.");
		String dataType = sc.nextLine();
		
		if(dataType.equalsIgnoreCase("int"))
		{
			dataType = "INT";
		}else if(dataType.equalsIgnoreCase("String"))
		{
			dataType = "VARCHAR";
			dataType += "(" + getStringLength() + ")";
			
		}else if(dataType.equalsIgnoreCase("long"))
		{
			dataType = "BIGINT";
		}
		
		return dataType;
	}
	
	private int getStringLength()
	{
		logger.info("Enter the maximum length of the String.");
		int length = sc.nextInt();
		return length;
	}
	
	private String getColumnNames()
	{
		logger.info("Enter the Column name");
		String columnName = sc.nextLine();
		
		columnName += " " + getDataTypeForColumns();
		
		return columnName;
	}
	
	private String getPrimaryKey()
	{
		logger.info("Enter the column name to set Primary key.");
		String primaryKey = sc.nextLine();
		return primaryKey;
	}
	
	private String getColumnNamesInSql()
	{
		logger.info("Enter the number of columns.");
		int n = sc.nextInt();
		sc.nextLine();
		List<String> columnList = new ArrayList<String>();
		
		String primaryKey = getPrimaryKey();
		columnList.add(primaryKey + " NOT NULL (" + getDataTypeForColumns());
		
		for(int i = 0; i<n; i++)
		{
			columnList.add(getColumnNames());
		}
		
		columnList.add("PRIMARY KEY(" + getPrimaryKey() + ")");
		
		String sql = String.join(", ", columnList);
		return sql;
	}
	
	private void printMap(List<EmployeePojo> list)
	{
		
		for(EmployeePojo pojo : list)
		{
			
			System.out.println("EMPLOYEE_ID : " + pojo.getEmployeeId());
			System.out.println("NAME : " + pojo.getName());
			System.out.println("MOBILE : " + pojo.getMobileNum());
			System.out.println("EMAIL : " + pojo.getEmailId());
			System.out.println("DEPARTMENT : " + pojo.getDepartment());
			System.out.println("___________________________________________________________");
			
		}
	}
	
	private void printMapCombined(Map<Integer,List<Object>> map)
	{
		int n = map.size();
		
		for(int i = 1; i<=n; i++)
		{
			List<Object> list = map.get(i);
			
			EmployeePojo emplPojo = (EmployeePojo) list.get(0);
			DependentPojo depPojo = (DependentPojo) list.get(1);
			
			System.out.println("EMPLOYEE_ID : " + emplPojo.getEmployeeId());
			System.out.println("NAME : " + emplPojo.getName());
			System.out.println("MOBILE : " + emplPojo.getMobileNum());
			System.out.println("EMAIL : " + emplPojo.getEmailId());
			System.out.println("DEPARTMENT : " + emplPojo.getDepartment());
			System.out.println("DEPENDENT NAME : " + depPojo.getName());
			System.out.println("AGE : " + depPojo.getAge());
			System.out.println("RELATIONSHIP : " + depPojo.getRelationship());
			System.out.println("___________________________________________________________");
			
		}
	}
	
	public static void main(String[] args)
	{
		DataBaseRunner runner = new DataBaseRunner();
		DataBase db = new DataBase();
		
		try
		{
			
			logger.info("Enter the case number to execute...");
			int caseValue = runner.getInteger();
			
			switch(caseValue)
			{
				case 1:
				{
					logger.info("Enter the Table name to create");
					String tableName = runner.getString();
					
					String sql = runner.getColumnNamesInSql();
					
					db.createTableInDataBase(tableName, sql);
					logger.info("Table created successfuly...");
					break;
					
				}
				case 2:
				{
					logger.info("Enter the Table name to add details.");
					String tableName = runner.getString();
					logger.info("Enter the number of Employees...");
					int n = sc.nextInt();
					List<EmployeePojo> employeeList = new ArrayList<EmployeePojo>();
					
					for(int i = 0; i<n; i++)
					{
						employeeList.add(new EmployeePojo());
					}
					
					for(EmployeePojo pojo : employeeList)
					{
						logger.info("Enter the Employee ID.");
						String str = runner.getString();
						pojo.setEmployeeId(str);
						logger.info("Enter the Employee Name.");
						str = runner.getString();
						pojo.setName(str);
						logger.info("Enter the Employee mobile number.");
						str = runner.getString();
						pojo.setMobileNum(str);
						logger.info("Enter Employee Email Id.");
						str = runner.getString();
						pojo.setEmailId(str);
						logger.info("Enter Employee Department.");
						str = runner.getString();
						pojo.setDepartment(str);
					}
					
					db.insertTableDetails(employeeList, tableName);
					logger.info("Employees details inserted successfully...");
					break;
				}
				case 3:
				{
					logger.info("Enter the Table name to get details.");
					String tableName = runner.getString();
					logger.info("Enter the Employee name to get details.");
					String name = runner.getString();
					
					List<EmployeePojo> map = db.retrieveTableDetails(tableName, name);

					runner.printMap(map);
					
					break;
				}
				case 4:
				{
					logger.info("Enter the Table name to Update details.");
					String tableName = runner.getString();
					logger.info("Enter the Employee Name to which have to Update data.");
					String name = runner.getString();
					logger.info("Enter the updated mobile number.");
					String mobileNumber = runner.getString();
					
					db.modifyTableDetails(tableName, name, mobileNumber);
					
					List<EmployeePojo> map = db.retrieveTableDetails(tableName, name);
					
					runner.printMap(map);
					
					break;
				}
				case 5:
				{
					logger.info("Enter the Table name to get details.");
					String tableName = runner.getString();
					logger.info("Enter the value for first number of Employees to print");
					int n = runner.getInteger();
					
					List<EmployeePojo> map = db.getFirstNRecords(tableName, n);
					
					runner.printMap(map);
					
					break;
				}
				case 6:
				{
					logger.info("Enter the Table name to sort the details.");
					String tableName = runner.getString();
					logger.info("Enter the column name to sort the Table.");
					String sortID = runner.getString();
					logger.info("Enter the value for first number of Employees to print after sorting");
					int n = runner.getInteger();
					logger.info("Enter 'a' to sort data in ascending.\nor\nEnter 'd' to sort data in descending.");
					String decision = runner.getString();
					
					switch(decision)
					{
						case "a":
						{
							List<EmployeePojo> map = db.sortDataInAscending(tableName, sortID, n);
							runner.printMap(map);
							break;
						}
						case "d":
						{
							List<EmployeePojo> map = db.sortDataInDescending(tableName, sortID, n);
							runner.printMap(map);
							break;
						}
						default:
						{
							logger.info("Invalid Input.");
							break;
						}
					}
					logger.info("Table sorted successfully...");

					break;
				}
				case 7:
				{
					logger.info("Enter the Table name to Delete the details.");
					String tableName = runner.getString();
					logger.info("Enter the Employee ID which have to delete from the table.");
					String employeeID = runner.getString();
					
					db.deleteTableContent(tableName, employeeID);
					
					List<EmployeePojo> map = db.getTableDetails(tableName);
					
					runner.printMap(map);	//To see whether the specified details are deleted or not.
					
					break;
				}
				case 8:
				{
					logger.info("Enter the Table name to create Dependent Table.");
					String tableName = runner.getString();
					logger.info("Enter the Parent Table name.");
					String parentTable = runner.getString();
					logger.info("Enter the foreignKey to set.");
					String foreignKey = runner.getString();
					
					String sql = runner.getColumnNamesInSql();
					
					db.createDependentTable(tableName, sql, parentTable, foreignKey);
					logger.info("Table created successfuly...");
					break;
				}
				case 9:
				{
					logger.info("Enter the Table name to add details.");
					String tableName = runner.getString();
					logger.info("Enter the total number of Dependents...");
					int n = sc.nextInt();
					sc.nextLine();
					List<DependentPojo> dependentList = new ArrayList<DependentPojo>();
					
					for(int i = 0; i<n; i++)
					{
						dependentList.add(new DependentPojo());
					}
					
					for(DependentPojo pojo : dependentList)
					{
						logger.info("Enter the Employee ID.");
						String str = runner.getString();
						pojo.setEmployeeId(str);
						logger.info("Enter the Dependent ID.");
						str = runner.getString();
						pojo.setDependentId(str);
						logger.info("Enter the Dependent Name.");
						str = runner.getString();
						pojo.setName(str);
						logger.info("Enter the Dependent Age.");
						int age = runner.getInteger();
						pojo.setAge(age);
						logger.info("Enter Dependent's relationship with Employee.");
						str = runner.getString();
						pojo.setRelationship(str);
					}
					
					db.insertDependentTableDetails(dependentList, tableName);
					logger.info("Dependents details inserted successfully...");
					break;
				}
				case 10:
				{
					logger.info("Enter the Dependent Table name.");
					String tableName = runner.getString();
					logger.info("Enter the Parent Table name.");
					String parentTable = runner.getString();
					logger.info("Enter the Foreign key column name.");
					String foreignKey = runner.getString();
					logger.info("Enter the Employee ID for which dependents details are needed.");
					String employeeID = runner.getString();
					
					Map<Integer,List<Object>> map = db.retrieveDependentTableDetails(tableName, parentTable, foreignKey, employeeID);
					
					runner.printMapCombined(map);
					
					break;
				}
				case 11:
				{
					logger.info("Enter the Parent Table name.");
					String parentTable = runner.getString();
					logger.info("Enter the Dependent Table name.");
					String tableName = runner.getString();
					logger.info("Enter the Foreign key column name.");
					String foreignKey = runner.getString();
					logger.info("Enter the column name to sort the Table.");
					String sortID = runner.getString();
					logger.info("Enter the value for first number of Employees to print after sorting");
					int n = runner.getInteger();
					
					Map<Integer,List<Object>> map = db.getDependentTableDetails(tableName, parentTable, foreignKey, sortID, n);
					
					runner.printMapCombined(map);
					
					break;
				}
				default:
				{
					logger.info("XXX...Invalid Case Value...XXX");
					break;
				}
			}
		}
		catch(SQLException e)
		{
			logger.info(e.getMessage());
//			e.printStackTrace();
		}
		catch(InputMismatchException e)
		{
			logger.warning("Data type mismatch...");
//	    	e.printStackTrace();
		}
	}

}
