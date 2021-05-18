package ru.knitu.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    @NotBlank(message = "Поле обязательно")
    private String firstname;
    @NotBlank(message = "Поле обязательно")
    private String lastname;
    @NotBlank(message = "Поле обязательно")
    private String typeOfLegalEntity;
    @NotBlank(message = "Поле обязательно")
    private String nameOfLegalEntity;
    @NotBlank(message = "Поле обязательно")
    private String login;
    private boolean admin;
    @Email(message = "Неккоректная почта")
    @NotBlank(message = "Поле обязательно")
    private String email;

}
