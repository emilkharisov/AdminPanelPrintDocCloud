package ru.knitu.service;

import ru.knitu.form.UserForm;

public interface UserService {

    void createUser(UserForm userForm);

    void createTechUser();

}
