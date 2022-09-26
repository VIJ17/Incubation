package runner;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import exceptions.WrongEntryException;
import methodClass.HashMaps;

public class HashMapRunner
{
	public static Scanner sc = new Scanner(System.in);
	
	public Map<String,String> getMapKeyValuesStrings()
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put("A", "Vijay");
		map.put("B", "Balaji");
		map.put("C", "Arun");
		return map;
	}
	public Map<Integer,Integer> getMapKeyValuesIntegers()
	{
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(001, 35);
		map.put(002, 45);
		map.put(003, 55);
		return map;
	}
	public Map<String,Integer> getMapKeyValues()
	{
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("Vijay", 35);
		map.put("Balaji", 45);
		map.put("Arun", 55);
		return map;
	}
	public Map<String,HashMaps> getMapKeyValuesWithObjects()
	{
		Map<String,HashMaps> map = new HashMap<String,HashMaps>();
		map.put("Vijay", new HashMaps());
		map.put("Balaji", new HashMaps());
		map.put("Arun", new HashMaps());
		return map;
	}
	public Map<String,String> getMapKeyValuesWithNullValue()
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put("A", "Vijay");
		map.put("B", "Balaji");
		map.put("C", null);
		return map;
	}
	public Map<String,String> getMapKeyValuesWithNullKey()
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put("A", "Vijay");
		map.put("B", "Balaji");
		map.put(null, "Arun");
		return map;
	}
	public void changeValues(Map<String,String> map)
	{
		map.replace("A", "Pandiyan");
		map.replace("B", "Shyam");
		map.replace("C", "Siva");
	}
	public Map<String,String> get2ndMapKeyValuesStrings()
	{
		Map<String,String> map = new HashMap<String,String>();
		System.out.println("Enter the number of elements");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the key & its value alternaively...");
		for(int i = 0; i < n; i++)
		{
			String key = sc.nextLine();
			String value = sc.nextLine();
			map.put(key, value);
		}
		return map;
	}
	
	public static void main(String args[])
	{
		HashMapRunner run = new HashMapRunner();
		HashMaps hashmap = new HashMaps(); 
		System.out.println("Enter a case number to execute...");
		int caseValue = sc.nextInt();
		sc.nextLine();
		try
		{
		switch(caseValue)
		{
			case 1:
			{
		    	Map<String,String> map = hashmap.getHashMap("String", "String");
		    	System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	break;
		   	}
		 	case 2:
		 	{
		    	Map<String,String> map = hashmap.getHashMap("String", "String");
		    	map = run.getMapKeyValuesStrings();
		    	System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	break;
		   	}
		 	case 3:
		 	{
		 		Map<Integer,Integer> map = hashmap.getHashMap(1, 1);
		 		map = run.getMapKeyValuesIntegers();
		 		System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	break;
		 	}
		 	case 4:
		 	{
		 		Map<String,Integer> map = hashmap.getHashMap("", 1);
		 		map = run.getMapKeyValues();
		 		System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	break;
		 	}
		 	case 5:
		 	{
		 		Map<String,HashMaps> map = hashmap.getHashMap("", new HashMaps());
		 		map = run.getMapKeyValuesWithObjects();
		 		System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	break;
		 	}
		 	case 6:
		 	{
		 		Map<String,String> map = hashmap.getHashMap("String", "String");
		 		map = run.getMapKeyValuesWithNullValue();
		    	System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	break;
		 	}
		 	case 7:
		 	{
		 		Map<String,String> map = hashmap.getHashMap("String", "String");
		 		map = run.getMapKeyValuesWithNullKey();
		    	System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	break;
		 	}
		 	case 8:
		 	{
		 		Map<String,String> map = hashmap.getHashMap("", "");
		    	map = run.getMapKeyValuesStrings();
		    	System.out.println("Enter the key to check...");
		    	String key = sc.nextLine();
		    	System.out.println(hashmap.checkThePresenceOfKey(map, key));
		    	break;
		 	}
		 	case 9:
		 	{
		 		Map<String,String> map = hashmap.getHashMap("", "");
		    	map = run.getMapKeyValuesStrings();
		    	System.out.println("Enter the Value to check...");
		    	String value = sc.nextLine();
		    	System.out.println(hashmap.checkThePresenceOfValue(map, value));
		    	break;
		 	}
		 	case 10:
		 	{
		 		Map<String,String> map = hashmap.getHashMap("", "");
		    	map = run.getMapKeyValuesStrings();
		    	System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	run.changeValues(map);
		    	System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	break;
		 	}
		 	case 11:
		 	{
		 		Map<String,String> map = hashmap.getHashMap("", "");
		    	map = run.getMapKeyValuesStrings();
		    	System.out.println("Enter the key to get the Value...");
		    	String key = sc.nextLine();
		    	System.out.println(hashmap.getValueOfExistingKey(map, key));
		    	break;
		 	}
		 	case 12:
		 	{
		 		Map<String,String> map = hashmap.getHashMap("", "");
		    	map = run.getMapKeyValuesStrings();
		    	System.out.println("Enter the default value to return");
		    	String defaultValue = sc.nextLine();
		    	System.out.println("Enter the key to get the Value...");
		    	String key = sc.nextLine();
		    	System.out.println(hashmap.getValueForNonExistingKey(map, key, defaultValue));
		    	break;
		 	}
		 	case 13:
		 	{
		 		Map<String,String> map = hashmap.getHashMap("", "");
		    	map = run.getMapKeyValuesStrings();
		    	System.out.println("Enter the key to get the Value...");
		    	String key = sc.nextLine();
		    	System.out.println(hashmap.getValueOfExistingKeyWithDefault(map, key));
		    	break;
		 	}
		 	case 14:
		 	{
		 		Map<String,String> map = hashmap.getHashMap("", "");
		    	map = run.getMapKeyValuesStrings();
		    	System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	System.out.println("Enter the key to remove from the Maping...");
		    	String key = sc.nextLine();
		    	hashmap.removeExistingKey(map, key);
		    	System.out.println("After removing the given Key : "+map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	break;
		 	}
		 	case 15:
		 	{
		 		Map<String,String> map = hashmap.getHashMap("", "");
		    	map = run.getMapKeyValuesStrings();
		    	System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	System.out.println("Enter the key to remove from the Maping...");
		    	String key = sc.nextLine();
		    	System.out.println("Enter the Value to which given key is mapped...");
		    	String value = sc.nextLine();
		    	hashmap.removeExistingKeyWithValue(map, key, value);
		    	System.out.println("After removing the Key only if it matches the given value :"+map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	break;
		 	}
		 	case 16:
		 	{
		 		Map<String,String> map = hashmap.getHashMap("", "");
		    	map = run.getMapKeyValuesStrings();
		    	System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	System.out.println("Enter the key to replace its value...");
		    	String key = sc.nextLine();
		    	System.out.println("Enter the new Value to replace for the Key...");
		    	String value = sc.nextLine();
		    	hashmap.replaceExistingKey(map, key, value);
		    	System.out.println("After replacing the Value for given key :"+map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	break;
		 	}
		 	case 17:
		 	{
		 		Map<String,String> map = hashmap.getHashMap("", "");
		    	map = run.getMapKeyValuesStrings();
		    	System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	System.out.println("Enter the key to replace its value...");
		    	String key = sc.nextLine();
		    	System.out.println("Enter the Value to check before replacing the new Value...");
		    	String oldValue = sc.nextLine();
		    	System.out.println("Enter the new Value to replace for the Key...");
		    	String newValue = sc.nextLine();
		    	hashmap.replaceExistingKeyWithValue(map, key, oldValue, newValue);
		    	System.out.println("After removing the Key only if it matches the given value :"+map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	break;
		 	}
		 	case 18:
		 	{
		 		Map<String,String> map = hashmap.getHashMap("", "");
		    	map = run.getMapKeyValuesStrings();
		    	System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	Map<String,String> map1 = hashmap.getHashMap("", "");
		    	map1 = run.get2ndMapKeyValuesStrings();
		    	hashmap.joinMaps(map, map1);
		    	System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	break;
		 	}
		 	case 19:
		 	{
		 		Map<String,String> map = hashmap.getHashMap("", "");
		    	map = run.getMapKeyValuesStrings();
		    	map.forEach((k, v) -> System.out.println("Key = "+k+", Value ="+v));
		    	break;
		 	}
		 	case 20:
		 	{
		 		Map<String,String> map = hashmap.getHashMap("", "");
		    	map = run.getMapKeyValuesStrings();
		    	System.out.println(map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	hashmap.removeAllEntries(map);
		    	System.out.println("After removing all entries in the map : "+map);
		    	System.out.println("Size of the HashMap is : "+hashmap.getMapSize(map));
		    	break;
		 	}
		 	default :
		 	{
		 		System.out.println("XXX...Invalid Case Number...XXX");
		 		break;
		 	}
		}
		}
		catch(WrongEntryException ex)
		{
			System.out.println(ex.getMessage());
		}
		catch(InputMismatchException e)
		{
			System.out.println("...Invalid Data type entered...");
		}
	}
}
