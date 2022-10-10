package beginnersTask;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import exceptions.WrongEntryException;

public class FilesProperties
{
	
	Strings word = new Strings();
	
	public <T> void nullCheckForArray(T[] array) throws WrongEntryException
	{
		if(array == null)
		{
			throw new WrongEntryException("GIven Array is null.");
		}
	}
	public Properties getProperties()
	{
		Properties prop = new Properties();
		return prop;
	}
	public void createTextFile(String fileName, String[] strArray) throws IOException, WrongEntryException
	{
		word.nullCheck(fileName);
		nullCheckForArray(strArray);
		
		File file = new File(fileName);
		try(FileWriter writer = new FileWriter(file, true))
		{
			int length = strArray.length;
			for(int i = 0; i<length; i++)
			{
				writer.write(strArray[i]+"\n");
			}
		}
//		catch(IOException e)
//		{
//			throw e;
//		}
	}
	public void storePropertiesInTextFile(Properties prop, String fileName) throws IOException, WrongEntryException
	{
		word.nullCheck(fileName);
		
		File file = new File(fileName);
		try (FileWriter writer = new FileWriter(file, true))
		{
			prop.store(writer, "File is created successfully.");
		}
//		catch (IOException e)
//		{
//			throw e;
//		}
	}
	public void restoreProperties(Properties prop, String fileName) throws IOException, WrongEntryException
	{
		word.nullCheck(fileName);
		
		try(FileReader reader = new FileReader(fileName))
		{
			prop.load(reader);
		}
//		catch (IOException e)
//		{
//			throw e;
//		}
	}
}
