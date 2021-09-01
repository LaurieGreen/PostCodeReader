package http.management;

import java.io.IOException;
import java.util.Arrays;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

public class HttpManager {
	private final HttpClient client;
	private final HttpGet httpGet;
	private HttpResponse httpResponse;

	public HttpManager( String urlString ) {
		this.client = HttpClientBuilder.create().build();
		this.httpGet = new HttpGet(urlString);
	}

	public void makeUrlCall( ){
		try {
			httpResponse = client.execute( httpGet );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	public String getResponseBody(){
		try {
			return EntityUtils.toString( httpResponse.getEntity() );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return null;
	}

	public Header[] responseHeaders(){
		return httpResponse.getAllHeaders();
	}

	public static void main( String[] args ) {
		HttpManager manager = new HttpManager( "https://bbc.co.uk" );
		manager.makeUrlCall();
		System.out.println(manager.getResponseBody());
			for (Header header : manager.responseHeaders()){
				System.out.println(header);
			}
	}
}
