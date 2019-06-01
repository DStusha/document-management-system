package ru.adeg.dms.security;

public final class TokenUser {
    private final Long id;
    private final String login;
    private final Long roleId;

    public TokenUser(Long id, String login, Long roleId) {
        this.id = id;
        this.login = login;
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public Long getRoleId() {
        return roleId;
    }
}
