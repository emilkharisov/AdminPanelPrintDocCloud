package ru.knitu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.knitu.form.UserForm;
import ru.knitu.model.Role;
import ru.knitu.model.State;
import ru.knitu.model.User;
import ru.knitu.repo.UserRepository;
import ru.knitu.utils.PasswordGenerator;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    MailSender mailSender;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void createUser(UserForm userForm) {

        PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                .useDigits(true)
                .useLower(true)
                .useUpper(true)
                .build();
        String password = passwordGenerator.generate(8);

        String hashpassword = passwordEncoder.encode(password);

        Role currentRole = userForm.isAdmin() ? Role.ADMIN : Role.USER;

        User user = User.builder().firstname(userForm.getFirstname())
                    .lastname(userForm.getLastname())
                    .login(userForm.getLogin())
                    .typeOfLegalEntity(userForm.getTypeOfLegalEntity())
                    .nameOfLegalEntity(userForm.getNameOfLegalEntity())
                    .hashpassword(hashpassword)
                    .email(userForm.getEmail())
                    .state(State.ACTIVE)
                    .role(currentRole)
                .build();

        userRepository.save(user);
        mailSender.send(userForm.getEmail(),"Пароль", "Ваш пароль в системе - " + password);

    }

    @Override
    public void createTechUser(boolean admin) {

        String hashpassword = passwordEncoder.encode("1234");
        Role role = admin ? Role.ADMIN : Role.USER;

        User user = User.builder().firstname("ADMIN")
                .lastname("ADMIN")
                .login("admin")
                .typeOfLegalEntity("")
                .nameOfLegalEntity("")
                .hashpassword(hashpassword)
                .email("admin@admin.mail.ru")
                .state(State.ACTIVE)
                .role(role)
                .typeOfLegalEntity("ООО")
                .nameOfLegalEntity("Vending Optom")
                .build();

        userRepository.save(user);

    }

}
