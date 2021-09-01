package config.management;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ProductConfigManager {
	// preparing our private variable for our properties object initialisation
	private static final Properties config;

	/*
	We are using a static block to initialise our static propertise instantiation and set our reader

	It is very similar to what you do when initialising a normal class i.e. public Config(){}

	Using a static block means that when we run/build our program this block is immidately loaded referred to as "eager loading"
	 */
	static { //TODO: read more about static block
		// Instantiation of our Properties object - Properties object is there to work with .properties files
		config = new Properties();
		try {
			// loading our config file using a newly instantiaded FileReader
			config.load( new FileReader( "src/main/config.properties" ) );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	public static String postcodesBaseUrl(){
		return config.getProperty( "postcodes_base_url" );
	}

	public static String postcostsLatestServiceEndpoint(){
		return config.getProperty( "postcodes_latest_service_endpoint" );
	}

	public static String postcodesTestFileLocation(){
		return config.getProperty( "postcodes_test_file_location" );
	}

	public static String testEnv(){
		return config.getProperty( "test_env" );
	}

	public static void main( String[] args ) {
		System.out.println( ProductConfigManager.postcodesBaseUrl() );
		System.out.println( ProductConfigManager.postcostsLatestServiceEndpoint() );
	}
}
