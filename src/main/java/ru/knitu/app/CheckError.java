package ru.knitu.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ru.knitu.model.VendingError;
import ru.knitu.repo.VendingErrorRepository;

import java.util.List;
import java.util.Optional;

@EnableScheduling
@Component
public class CheckError {

    @Autowired
    VendingErrorRepository vendingErrorRepository;

    @Scheduled(fixedRate = 10000000)
    public void checkError(){

        if(vendingErrorRepository != null) {
            System.out.println("hello1");
            Optional<List<VendingError>> vendingErrors = Optional.ofNullable(vendingErrorRepository.findAll());
            if (vendingErrors.isPresent()) {
                for (VendingError vendingError : vendingErrors.get()) {
                    System.out.println(vendingError.getErrorMessage() + " " + vendingError.getVendingMachine().toString());
                }
            }
        }

    }

}
