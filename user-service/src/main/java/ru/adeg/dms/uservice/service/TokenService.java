package ru.adeg.dms.uservice.service;

import ru.adeg.dms.security.TokenUser;

public interface TokenService {
    String getToken(final TokenUser user);
}
