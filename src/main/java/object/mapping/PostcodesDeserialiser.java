package object.mapping;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PostcodesDeserialiser {
	private ObjectMapper objectMapper = new ObjectMapper();

	public PostcodeJsonDTO fixerLatestRatesData( File jsonFileLocation){
		try {
			return objectMapper.readValue( jsonFileLocation, PostcodeJsonDTO.class );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return null;
	}

	public PostcodeJsonDTO fixerLatestRatesData(String jsonString){
		try {
			return objectMapper.readValue( jsonString, PostcodeJsonDTO.class );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return null;
	}
}
