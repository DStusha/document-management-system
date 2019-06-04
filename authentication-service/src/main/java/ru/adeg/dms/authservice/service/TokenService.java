package ru.adeg.dms.authservice.service;

import ru.adeg.dms.security.TokenUser;

public interface TokenService {
    String getToken(final TokenUser user);
}
