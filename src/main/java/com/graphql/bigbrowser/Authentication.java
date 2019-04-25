package com.graphql.bigbrowser;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWT;

public class Authentication {

    private static String secret = "Noël c'est le 25 décembre";

    public static String encodePassword(String inPassword){
        Algorithm algorithmHS = Algorithm.HMAC256(secret);
        String token = JWT.create()
                .withIssuer("auth0")
                .sign(algorithmHS);
        return token;
    }

}
