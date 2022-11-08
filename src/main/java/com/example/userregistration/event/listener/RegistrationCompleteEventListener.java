package com.example.userregistration.event.listener;

import com.example.userregistration.email.EmailSender;
import com.example.userregistration.email.EmailValidator;
import com.example.userregistration.entity.AppUser;
import com.example.userregistration.event.RegistrationCompleteEvent;
import com.example.userregistration.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@Async
public class RegistrationCompleteEventListener implements
        ApplicationListener<RegistrationCompleteEvent> {

    private final EmailSender emailSender;

    private final EmailValidator emailValidator;
    private final UserService userService;

    public RegistrationCompleteEventListener(EmailSender emailSender, EmailValidator emailValidator, UserService userService) {
        this.emailSender = emailSender;
        this.emailValidator = emailValidator;
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create the Verification Token for the User with Link
        AppUser user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        //Send Mail to user
        String url =
                event.getApplicationUrl()
                        + "/verifyRegistration?token="
                        + token;
        // Validate  email
        boolean isValidEmail = emailValidator.
                test(event.getUser().getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        //Send
        emailSender.send(
                event.getUser().getEmail(),
                emailSender.buildEmail(event.getUser().getFirstName(), url));

        //sendVerificationEmail()
        log.info("Click the link to verify your account: {}",
                url);
    }


}