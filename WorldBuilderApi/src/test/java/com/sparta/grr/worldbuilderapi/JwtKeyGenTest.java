package com.sparta.grr.worldbuilderapi;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;

public class JwtKeyGenTest {

    @Test
    public void generateKey(){
        SecretKey key = Jwts.SIG.HS512.key().build();
        String keyString = DatatypeConverter.printHexBinary(key.getEncoded());
        System.out.printf("\n KEY - %s \n",keyString);
    }
}
