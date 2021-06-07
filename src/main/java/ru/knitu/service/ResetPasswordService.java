package ru.knitu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.knitu.controller.user.UserController;
import ru.knitu.model.User;
import ru.knitu.repo.UserRepository;
import ru.knitu.utils.PasswordGenerator;
import ru.knitu.utils.UserUtility;

@Service
public class ResetPasswordService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    MailSender mailSender;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    public  void resetPassword(User user){

        PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                .useDigits(true)
                .useLower(true)
                .useUpper(true)
                .build();
        String password = passwordGenerator.generate(8);

        String hashpassword = passwordEncoder.encode(password);

        user.setHashpassword(hashpassword);
        userRepository.save(user);

        mailSender.send(user.getEmail(),"Смена пароля", "Ваш новый пароль в системе - " + password);

        LOGGER.info("ResetPasswordService.resetPassword  USER = " + user.getLogin());


    }

}
