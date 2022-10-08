package runner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import beginnersTask.DataBase;
import beginnersTask.DependentPojo;
import beginnersTask.EmployeePojo;

public class DataBaseRunner
{
	
	static Scanner sc = new Scanner(System.in);
	
	public int getInteger()
	{
		int value = sc.nextInt();
		sc.nextLine();
		return value;
	}
	public String getString()
	{
		String str = sc.nextLine();
		return str;
	}
	public void printResult(ResultSet result) throws SQLException
	{
		while(result.next())
		{
			System.out.print("EmployeeId : " + result.getLong("EMPLOYEE_ID") + ";\t");
			System.out.print("NAME : " + result.getString("NAME") + ";\t");
			System.out.print("MOBILE : " + result.getLong("MOBILE") + ";\t");
			System.out.print("EMAIL : " + result.getString("EMAIL") + ";\t");
			System.out.print("DEPARTMENT : " + result.getString("DEPARTMENT") + "\n");
		}
	}
	public void printDependentResult(ResultSet result) throws SQLException
	{
		while(result.next())
		{
			System.out.print("EmployeeId : " + result.getLong("EMPLOYEE_ID") + ";");
			System.out.print("DependentId : " + result.getString("DEPENDENT_ID") + ";");
			System.out.print("Dependent Name : " + result.getString("NAME") + ";");
			System.out.print("Dependent Age : " + result.getString("AGE") + ";");
			System.out.print("Relationship : " + result.getString("RELATIONSHIP") + ";\n");
			System.out.print("Employee Name : " + result.getString("Employee.NAME") + ";");
			System.out.print("MOBILE : " + result.getLong("MOBILE") + ";");
			System.out.print("EMAIL : " + result.getString("EMAIL") + ";");
			System.out.print("DEPARTMENT : " + result.getString("DEPARTMENT") + ";\n");
			
		}
	}
	
	public static void main(String[] args)
	{
		DataBaseRunner runner = new DataBaseRunner();
		DataBase db = new DataBase();
		System.out.println("Enter the case number to execute...");
		int caseValue = sc.nextInt();
		sc.nextLine();
		
		try
		{
			switch(caseValue)
			{
				case 1:
				{
					System.out.println("Enter the Table name to create");
					String tableName = runner.getString();
					
					db.createTableInDataBase(tableName);
					System.out.println("Table created successfuly...");
					break;
					
				}
				case 2:
				{
					System.out.println("Enter the Table name to add details.");
					String tableName = runner.getString();
					System.out.println("Enter the number of Employees...");
					int n = sc.nextInt();
					List<EmployeePojo> employeeList = new ArrayList<EmployeePojo>();
					
					for(int i = 0; i<n; i++)
					{
						employeeList.add(new EmployeePojo());
					}
					
					for(EmployeePojo pojo : employeeList)
					{
						System.out.println("Enter the Employee ID.");
						String str = runner.getString();
						pojo.setEmployeeId(str);
						System.out.println("Enter the Employee Name.");
						str = runner.getString();
						pojo.setName(str);
						System.out.println("Enter the Employee mobile number.");
						str = runner.getString();
						pojo.setMobileNum(str);
						System.out.println("Enter Employee Email Id.");
						str = runner.getString();
						pojo.setEmailId(str);
						System.out.println("Enter Employee Department.");
						str = runner.getString();
						pojo.setDepartment(str);
					}
					
					db.insertTableDetails(employeeList, tableName);
					System.out.println("Employees details inserted successfully...");
					break;
				}
				case 3:
				{
					System.out.println("Enter the Table name to get details.");
					String tableName = runner.getString();
					System.out.println("Enter the Employee name to get details.");
					String name = runner.getString();
					
					ResultSet result = db.retrieveTableDetails(tableName, name);
					
					runner.printResult(result);
					break;
				}
				case 4:
				{
					System.out.println("Enter the Table name to Update details.");
					String tableName = runner.getString();
					System.out.println("Enter the Employee Name to which have to Update data.");
					String name = runner.getString();
					System.out.println("Enter the updated mobile number.");
					String mobileNumber = runner.getString();
					
					db.modifyTableDetails(tableName, name, mobileNumber);
					
					ResultSet result = db.retrieveTableDetails(tableName, name);
					runner.printResult(result);
					break;
				}
				case 5:
				{
					System.out.println("Enter the Table name to get details.");
					String tableName = runner.getString();
					System.out.println("Enter the value for first number of Employees to print");
					int n = runner.getInteger();
					
					ResultSet result = db.getFirstNRecords(tableName, n);
					
					runner.printResult(result);
					break;
				}
				case 6:
				{
					System.out.println("Enter the Table name to sort the details.");
					String tableName = runner.getString();
					System.out.println("Enter the column name to sort the Table.");
					String sortID = runner.getString();
					System.out.println("Enter 'a' to sort data in ascending.\nor\nEnter 'd' to sort data in descending.");
					String decision = runner.getString();
					
					switch(decision)
					{
						case "a":
						{
							ResultSet result = db.sortDataInAscending(tableName, sortID);
							runner.printResult(result);
							break;
						}
						case "d":
						{
							ResultSet result = db.sortDataInDescending(tableName, sortID);
							runner.printResult(result);
							break;
						}
						default:
						{
							System.out.println("Invalid Input.");
							break;
						}
					}
					System.out.println("Table sorted successfully...");

					break;
				}
				case 7:
				{
					System.out.println("Enter the Table name to Delete the details.");
					String tableName = runner.getString();
					System.out.println("Enter the Employee ID which have to delete from the table.");
					String employeeID = runner.getString();
					
					db.deleteTableContent(tableName, employeeID);
					
					ResultSet result = db.getTableDetails(tableName);
					runner.printResult(result);						   //To see whether the specified details are deleted or not.
					break;
				}
				case 8:
				{
					System.out.println("Enter the Table name to create Dependent Table.");
					String tableName = runner.getString();
					System.out.println("Enter the Parent Table name.");
					String parentTable = runner.getString();
					System.out.println("Enter the foreignKey to set.");
					String foreignKey = runner.getString();
					
					db.createDependentTable(tableName, parentTable, foreignKey);
					System.out.println("Table created successfuly...");
					break;
				}
				case 9:
				{
					System.out.println("Enter the Table name to add details.");
					String tableName = runner.getString();
					System.out.println("Enter the total number of Dependents...");
					int n = sc.nextInt();
					sc.nextLine();
					List<DependentPojo> dependentList = new ArrayList<DependentPojo>();
					
					for(int i = 0; i<n; i++)
					{
						dependentList.add(new DependentPojo());
					}
					
					for(DependentPojo pojo : dependentList)
					{
						System.out.println("Enter the Employee ID.");
						String str = runner.getString();
						pojo.setEmployeeId(str);
						System.out.println("Enter the Dependent ID.");
						str = runner.getString();
						pojo.setDependentId(str);
						System.out.println("Enter the Dependent Name.");
						str = runner.getString();
						pojo.setName(str);
						System.out.println("Enter the Dependent Age.");
						int age = runner.getInteger();
						pojo.setAge(age);
						System.out.println("Enter Dependent's relationship with Employee.");
						str = runner.getString();
						pojo.setRelationship(str);
					}
					
					db.insertDependentTableDetails(dependentList, tableName);
					System.out.println("Dependents details inserted successfully...");
					break;
				}
				case 10:
				{
					System.out.println("Enter the Dependent Table name.");
					String tableName = runner.getString();
					System.out.println("Enter the Parent Table name.");
					String parentTable = runner.getString();
					System.out.println("Enter the Foreign key column name.");
					String foreignKey = runner.getString();
					System.out.println("Enter the Employee ID for which dependents details are needed.");
					String employeeID = runner.getString();
					
					ResultSet result = db.retrieveDependentTableDetails(tableName, parentTable, foreignKey, employeeID);
					runner.printDependentResult(result);
					break;
				}
				case 11:
				{
					System.out.println("Enter the Dependent Table name.");
					String tableName = runner.getString();
					System.out.println("Enter the Parent Table name.");
					String parentTable = runner.getString();
					System.out.println("Enter the Foreign key column name.");
					String foreignKey = runner.getString();
					
					ResultSet result = db.getDependentTableDetails(tableName, parentTable, foreignKey);
					runner.printDependentResult(result);
					break;
				}
				default:
				{
					System.out.println("XXX...Invalid Case Value...XXX");
					break;
				}
			}
		}
		catch(SQLException | InputMismatchException e)
		{
			e.printStackTrace();
		}
	}

}
