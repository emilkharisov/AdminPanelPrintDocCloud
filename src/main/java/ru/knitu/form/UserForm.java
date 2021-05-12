package ru.knitu.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    private String firstname;
    private String lastname;
    private String typeOfLegalEntity;
    private String nameOfLegalEntity;
    private String login;
    private boolean admin;
    private String email;

}
