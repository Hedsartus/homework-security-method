package ru.netology.homeworksecuritymethod.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_READ,
    ROLE_WRITE,
    ROLE_DELETE;

    @Override
    public String getAuthority() {
        return name();
    }
}
