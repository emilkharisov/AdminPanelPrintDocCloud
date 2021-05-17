package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.knitu.form.UserForm;
import ru.knitu.model.Role;
import ru.knitu.model.User;
import ru.knitu.repo.UserRepository;

@Service
public class EditUserService implements EditService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void edit(Object object, Long id) {

        UserForm userForm = (UserForm) object;

        User user = userRepository.findById(id);
        Role currentRole = userForm.isAdmin() ? Role.ADMIN : Role.USER;

        user.setLastname(userForm.getLastname());
        user.setFirstname(userForm.getFirstname());
        user.setLogin(userForm.getLogin());
        user.setEmail(userForm.getEmail());
        user.setNameOfLegalEntity(userForm.getNameOfLegalEntity());
        user.setTypeOfLegalEntity(userForm.getTypeOfLegalEntity());
        user.setRole(currentRole);

        userRepository.save(user);

    }
}
