package com.nexters.duckjiduckji.Config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {

    // 요청단 10개의 RestTemplate Client를 만들고, 최대 50개 까지 증가
    public RestTemplate getRestTemplate(int defaultMaxPerRoute, int maxTotal) {
            PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
            connManager.setDefaultMaxPerRoute(defaultMaxPerRoute); // path의 최대 연결수
            connManager.setMaxTotal(maxTotal);

            CloseableHttpClient client = HttpClientBuilder.create().setConnectionManager(connManager).build();

            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(client);
            factory.setConnectTimeout(3000);
            factory.setReadTimeout(3000);

            return new RestTemplate(factory);
        }

        @Bean
        public RestTemplate coffeeRestTemplate() {
            return getRestTemplate(10, 50);
        }
};
