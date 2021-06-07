package ru.knitu.security.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.knitu.model.Role;


@Configuration
@ComponentScan("ru.knitu")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/createTechUser").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/init/**").permitAll()
                .antMatchers("/getResetPassword/**").permitAll()
                .antMatchers("/addVendingMachine/**").hasAuthority(Role.ADMIN.name())
                .antMatchers("//getAddUserPage/**").hasAuthority(Role.ADMIN.name())
                .antMatchers("/allReportSelling/**").hasAuthority(Role.ADMIN.name())
                .antMatchers("/univerReportSelling/**").hasAuthority(Role.ADMIN.name())
                .antMatchers("/bussinessReportSelling/**").hasAuthority(Role.ADMIN.name())
                .antMatchers("/getAllVendingMachine/**").hasAuthority(Role.ADMIN.name())
                .antMatchers("/getUniversityVendingMachine/**").hasAuthority(Role.ADMIN.name())
                .antMatchers("/getUserList/**").hasAuthority(Role.ADMIN.name())
                .antMatchers("/vendingList/**").hasAuthority(Role.ADMIN.name())
                .and()
                .rememberMe().key("uniqueAndSecret")
                .and()
                .formLogin()
                .usernameParameter("login")
                .defaultSuccessUrl("/getMainPage")
                .loginPage("/login").permitAll();

        http.csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
