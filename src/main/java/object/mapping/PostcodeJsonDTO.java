package object.mapping;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostcodeJsonDTO {

	private int status;
	private JsonNode result;
	private String postcode;
	private int quality;
	private long eastings;
	private long northings;
	private String country;
	private String nhs_ha;
	private double longitude;
	private double latitude;
	@JsonProperty("european_electoral_region")
	private String europeanElectoralRegion;
	@JsonProperty("primary_care_trust")
	private String primaryCareTrust;
	private String region;
	private String lsoa;
	private String msoa;
	private String incode;
	private String outcode;
	@JsonProperty("parliamentary_constituency")
	private String parliamentaryConstituency;
	@JsonProperty("admin_district")
	private String adminDistrict;
	private String parish;
	@JsonProperty("admin_county")
	private String adminCounty;
	@JsonProperty("admin_ward")
	private String adminWard;
	private String ced;
	private String ccg;
	private String nuts;
	private Map<String, String> codes;


	public int getStatus() {
		return status;
	}

	public JsonNode getResult() {
		return result;
	}

	public String getPostcode() {
		return getResult().get( "postcode").asText();
	}

	public int getQuality() {
		return getResult().get( "quality").asInt();
	}

	public long getEastings() {
		return getResult().get( "eastings").asLong();
	}

	public long getNorthings() {
		return getResult().get( "northings").asLong();
	}

	public String getCountry() {
		return getResult().get( "country").asText();
	}

	public String getNhsHa() {
		return getResult().get( "nhs_ha").asText();
	}

	public double getLongitude() {
		return getResult().get( "longitude").asDouble();
	}

	public double getLatitude() {
		return getResult().get( "latitude").asDouble();
	}

	public String getEuropeanElectoralRegion() {
		return getResult().get( "european_electoral_region").asText();
	}

	public String getPrimaryCareTrust() {
		return getResult().get( "primary_care_trust").asText();
	}

	public String getRegion() {
		return getResult().get( "region").asText();
	}

	public String getLsoa() {
		return getResult().get( "lsoa").asText();
	}

	public String getMsoa() {
		return getResult().get( "msoa").asText();
	}

	public String getIncode() {
		return getResult().get( "incode").asText();
	}

	public String getOutcode() {
		return getResult().get( "outcode").asText();
	}

	public String getParliamentaryConstituency() {
		return getResult().get( "parliamentary_constituency").asText();
	}

	public String getAdminDistrict() {
		return getResult().get( "admin_district").asText();
	}

	public String getParish() {
		return getResult().get( "parish").asText();
	}

	public String getAdminCounty() {
		return getResult().get( "admin_county").asText();
	}

	public String getAdminWard() {
		return getResult().get( "admin_ward").asText();
	}

	public String getCed() {
		return getResult().get( "ced").asText();
	}

	public String getCcg() {
		return getResult().get( "ccg").asText();
	}

	public String getNuts() {
		return getResult().get( "nuts").asText();
	}

	public Map<String,String> getCodes() {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> codes = mapper.convertValue(getResult().get("codes"),
				new TypeReference<>() {});
		return codes;
	}

}
