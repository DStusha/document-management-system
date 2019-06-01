package ru.adeg.dms.uservice.service.impl;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import ru.adeg.dms.security.TokenData;
import ru.adeg.dms.uservice.entity.User;
import ru.adeg.dms.uservice.service.TokenService;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenServiceImpl implements TokenService {
    @Value("${token.alive}")
    private int tokenDaysAlive;

    @Value("${token.key}")
    private String key;

    public String getToken(final User user) {
        final Map<String, Object> tokenData = new HashMap<>();
        tokenData.put(TokenData.ID.getValue(), user.getUser_id());
        tokenData.put(TokenData.LOGIN.getValue(), user.getLogin());
        tokenData.put(TokenData.ROLE.getValue(), user.getRole_id());
        tokenData.put(TokenData.CREATE_DATE.getValue(), new Date().getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, tokenDaysAlive);
        tokenData.put(TokenData.EXPIRATION_DATE.getValue(), calendar.getTime());
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setExpiration(calendar.getTime());
        jwtBuilder.setClaims(tokenData);
        return jwtBuilder.signWith(SignatureAlgorithm.HS512, key).compact();
    }
}
