package http.management;

import config.management.ProductConfigManager;

public class PostCodeHttpManager extends HttpManager{

	public PostCodeHttpManager( final String postcode ) {
		super( ProductConfigManager.postcodesBaseUrl() +
				ProductConfigManager.postcostsLatestServiceEndpoint()+postcode);
	}
}
