package beginnersTask;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class FilesProperties
{
	public Properties getProperties()
	{
		Properties prop = new Properties();
		return prop;
	}
	public void createTextFile(String fileName, String[] strArray) throws IOException
	{
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
	public void storePropertiesInTextFile(Properties prop, String fileName) throws IOException
	{
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
	public void restoreProperties(Properties prop, String fileName) throws IOException
	{

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
