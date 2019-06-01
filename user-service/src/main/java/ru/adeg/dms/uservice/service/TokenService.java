package ru.adeg.dms.uservice.service;

import ru.adeg.dms.uservice.entity.User;

public interface TokenService {
    String getToken(final User user);
}
