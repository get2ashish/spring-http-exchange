package github.com.get2ashish.httpexchangeapplication.demo;

import github.com.get2ashish.httpexchangeapplication.exchange.UserExchange;
import github.com.get2ashish.httpexchangeapplication.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Exchange {


    private UserExchange userExchange;

    @Autowired
    public Exchange(UserExchange userExchange) {
        this.userExchange = userExchange;
    }


    @PostConstruct
    public void init() {
        List<User> responseUsers = userExchange.getAllUsers().map(data ->{
            return data;
        }).collectList().block();
        System.out.println("List of Users size is" +responseUsers.size());
        System.out.println("List of Users are" +responseUsers);

        User responseById = userExchange.getUserById(1L).block();
        System.out.println("Response is for id 1 is "+responseById);
    }
}
