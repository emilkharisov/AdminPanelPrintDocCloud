package ru.knitu.app;

import org.springframework.beans.factory.annotation.Autowired;
import ru.knitu.form.UserForm;
import ru.knitu.model.State;
import ru.knitu.model.User;
import ru.knitu.repo.UserRepository;
import ru.knitu.service.UserService;



public class Init {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    public void init(){



    }

}
