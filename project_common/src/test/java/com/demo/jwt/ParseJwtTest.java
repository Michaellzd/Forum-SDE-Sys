package com.demo.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

public class ParseJwtTest  {

    public static void main(String[] args) throws Exception {
        Claims claims = Jwts.parser().setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE2NjA2NzM3OTgsImV4cCI6MTY2MDY3Mzg1OCwicm9sZSI6ImFkbWluIn0.G8HFhY0RRDINeOtYoXQ8okFgh8C8nh1WLrToutkiEhY")
                .getBody();
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println(claims.get("role"));

    }
}
