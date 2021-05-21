package ru.knitu.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ru.knitu.model.User;
import ru.knitu.model.VendingError;
import ru.knitu.repo.VendingErrorRepository;
import ru.knitu.service.MailSender;

import java.util.List;
import java.util.Optional;

@EnableScheduling
@Component
public class CheckError {

    @Autowired
    VendingErrorRepository vendingErrorRepository;
    @Autowired
    MailSender mailSender;

    @Scheduled(fixedRate = 30000)
    public void checkError(){

        if(vendingErrorRepository != null) {
            Optional<List<VendingError>> vendingErrors = Optional.ofNullable(vendingErrorRepository.findAll());
            if (vendingErrors.isPresent()) {
                for (VendingError vendingError : vendingErrors.get()) {
                    String errorMessage = "Ошибка аппарата - " + vendingError.getVendingMachine().getName() + "\n" + vendingError.getErrorMessage();
                    User user = vendingError.getVendingMachine().getUser();
                   // mailSender.send(user.getEmail(),"Ошибка аппарата", errorMessage);

                }
            }
        }

    }

}
