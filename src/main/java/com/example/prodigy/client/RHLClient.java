package com.example.prodigy.client;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;
import java.util.ArrayList;

@Configuration
public class RHLClient {
	private static final Logger logger = LogManager.getLogger(RHLClient.class);
	@Value("${spring.elasticsearch.rest.uris}")
	String hosts;
	@Value("${spring.elasticsearch.rest.username}")
	String elkUID;
	@Value("${spring.elasticsearch.rest.password}")
	String elkPass;

	@Bean(destroyMethod = "close")
	public RestHighLevelClient getClient() {
		try {
			ArrayList<HttpHost> httpHosts = new ArrayList<>();
			for (String host : hosts.split(",")) {
				URL hostUrl = new URL(host);
				httpHosts.add(new HttpHost(hostUrl.getHost(), hostUrl.getPort(), hostUrl.getProtocol()));
			}
			logger.info("Host --> {}", hosts);

			//elkPass is decrypted at the time of startup by the EnvironmentDecryptApplicationInitializer
			logger.info("Cred --> [{}, {}]", elkUID, elkPass);

			final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
			credentialsProvider.setCredentials(AuthScope.ANY,
					new UsernamePasswordCredentials(elkUID, elkPass));

			RestClientBuilder builder = RestClient.builder(httpHosts.toArray(new HttpHost[httpHosts.size()]))
					.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
						@Override
						public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
							return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
						}
					});
			logger.info("********** connection object build *********");
			RestHighLevelClient esClient = new RestHighLevelClient(builder);
			logger.info("Client connection...{}", hosts);
			return esClient;

		} catch (Exception e) {
			logger.error("In getClient Exception...", e);
			return null;
		}

	}
}
