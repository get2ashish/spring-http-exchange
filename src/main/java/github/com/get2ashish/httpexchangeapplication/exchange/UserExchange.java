package github.com.get2ashish.httpexchangeapplication.exchange;

import github.com.get2ashish.httpexchangeapplication.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@HttpExchange("/users")
public interface UserExchange {

    @GetExchange()
    Flux<User> getAllUsers();

    @GetExchange("/{id}")
    Mono<User> getUserById(@PathVariable("id") Long id);


}
