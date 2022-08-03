package commonLib.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
	
public static Properties readProperties(String filename) throws IOException {//return type would be Properties its a class provided by java to read configuration in key value pairs,passing arguement as String filename,file name is name where will be passing name of file which we want to read
	
filename=filename.trim(); //first we need to trim this file name,ts good practice to trim first that removes any white spaces if present,all leading and trailing space removed

InputStream fileReader = new FileInputStream(filename); //InputStream is a class that helps us to read data from any external file in stream,FileInputStream class as data reading from file

Properties property = new Properties();

property.load(fileReader);//it will read everything from fileReader and covert it into key value pairs

return property;
}
}
