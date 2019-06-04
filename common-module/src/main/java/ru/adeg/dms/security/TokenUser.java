package ru.adeg.dms.security;

import java.util.List;

public final class TokenUser {
    private final String login;
    private final List<String> roles;

    public TokenUser(String login, List<String> roles) {
        this.login = login;
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public List<String> getRoles() {
        return roles;
    }
}
