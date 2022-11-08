package com.example.userregistration.event;

import com.example.userregistration.entity.AppUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {


    private final AppUser user;
    private final String applicationUrl;

    public RegistrationCompleteEvent(AppUser user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
