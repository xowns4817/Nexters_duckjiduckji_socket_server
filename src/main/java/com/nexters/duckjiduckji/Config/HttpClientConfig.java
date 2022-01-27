package com.nexters.duckjiduckji.Config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {

    @Value("${restemplate.connectionTimeOut}")
    private int connectionTimeOut;

    @Value("${restemplate.readTimeOut}")
    private int readTimeOut;

    @Value("${restemplate.defaultMaxPerRoute}")
    private int defaultMaxPerRoute;

    @Value("${restemplate.maxToal}")
    private int maxTotal;

    // 요청단 10개의 RestTemplate Client를 만들고, 최대 50개 까지 증가
    @Bean
    public RestTemplate getRestTemplate() {
            PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
            connManager.setDefaultMaxPerRoute(defaultMaxPerRoute); // path의 최대 연결수
            connManager.setMaxTotal(maxTotal);

            CloseableHttpClient client = HttpClientBuilder.create().setConnectionManager(connManager).build();

            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(client);
            factory.setConnectTimeout(connectionTimeOut);
            factory.setReadTimeout(readTimeOut);

            return new RestTemplate(factory);
    }

    // Hearder bean 설정(json)
    @Bean(name = "application-json-header")
    public HttpHeaders applicationJsonHeader() {
        HttpHeaders headers = new HttpHeaders();
        //headers.set("Authorization", "");
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @Bean(name = "multipart-formdata-header")
    public HttpHeaders multipartFormDataHeader() {
        HttpHeaders headers = new HttpHeaders();
        //headers.set("Authorization", "");
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        return headers;
    }

};
