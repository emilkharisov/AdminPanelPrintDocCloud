package ru.knitu.service;

import ru.knitu.form.VendingMachineForm;
import ru.knitu.model.User;

public interface VendingMachineService {

    void createVendingMachine(VendingMachineForm vendingMachineForm, User user);

}
