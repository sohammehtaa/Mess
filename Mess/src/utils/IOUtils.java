package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.core.Customer;

public class IOUtils {

	public static void storeDetails(Map<String, Customer> map, String fileName) throws FileNotFoundException, IOException
	{
		try(ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			out.writeObject(map);
		}
	}
	
	public static Map<String, Customer> restoreDetails(Map<String, Customer> map, String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		try(ObjectInputStream in= new ObjectInputStream(new FileInputStream(fileName)))
		{
			return (Map<String, Customer>)in.readObject();
		}
	}
}
