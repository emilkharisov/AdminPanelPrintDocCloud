package ru.knitu.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ru.knitu.controller.vendingMachine.VendingMachineController;
import ru.knitu.model.User;
import ru.knitu.model.VendingError;
import ru.knitu.repo.VendingErrorRepository;
import ru.knitu.service.MailSender;
import ru.knitu.utils.UserUtility;

import java.util.List;
import java.util.Optional;

@EnableScheduling
@Component
public class CheckError {

    @Autowired
    VendingErrorRepository vendingErrorRepository;
    @Autowired
    MailSender mailSender;

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckError.class);

    @Scheduled(fixedRate = 1800000)
    public void checkError(){

        if(vendingErrorRepository != null) {
            Optional<List<VendingError>> vendingErrors = Optional.ofNullable(vendingErrorRepository.findAll());
            if (vendingErrors.isPresent()) {
                for (VendingError vendingError : vendingErrors.get()) {
                    String errorMessage = "Ошибка аппарата - " + vendingError.getVendingMachine().getName() + "\n" + vendingError.getErrorMessage();
                    User user = vendingError.getVendingMachine().getUser();
                    LOGGER.info("CheckError.checkError" + errorMessage);
                    // mailSender.send(user.getEmail(),"Ошибка аппарата", errorMessage);

                }
            }
        }

    }

}
