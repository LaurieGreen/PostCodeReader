import java.io.File;

import config.management.ProductConfigManager;
import http.management.PostCodeHttpManager;
import object.mapping.PostcodeJsonDTO;
import object.mapping.PostcodesDeserialiser;

public class Main {
	public static void main( String[] args ) {

		final String postcode = "G840NY";
		PostcodeJsonDTO postcodesJsonDTO;

		if (ProductConfigManager.testEnv().equals( "file" )) {
			postcodesJsonDTO = new PostcodesDeserialiser().fixerLatestRatesData(
					new File( ProductConfigManager.postcodesTestFileLocation() ) );
		} else{
			PostCodeHttpManager postCodeHttpManager = new PostCodeHttpManager(postcode);
			postCodeHttpManager.makeUrlCall();
			postcodesJsonDTO = new PostcodesDeserialiser().fixerLatestRatesData(postCodeHttpManager.getResponseBody());
		}

		System.out.println(postcodesJsonDTO.getStatus());
		System.out.println(postcodesJsonDTO.getResult());
		System.out.println(postcodesJsonDTO.getQuality());
		System.out.println(postcodesJsonDTO.getEastings());
		System.out.println(postcodesJsonDTO.getNorthings());
		System.out.println(postcodesJsonDTO.getCountry());
		System.out.println(postcodesJsonDTO.getNhsHa());
		System.out.println(postcodesJsonDTO.getCodes());

	}
}
