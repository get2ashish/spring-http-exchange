package github.com.get2ashish.httpexchangeapplication.config;

import github.com.get2ashish.httpexchangeapplication.exchange.UserExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ApplicationConfig {

    @Bean
    WebClient createUserWebClient(){
        return WebClient.create("https://jsonplaceholder.typicode.com");
    }

    @Bean
    UserExchange postClient(WebClient webClient) {
        HttpServiceProxyFactory httpServiceProxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                        .build();
        return httpServiceProxyFactory.createClient(UserExchange.class);
    }



}
