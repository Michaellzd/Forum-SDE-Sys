package com.demo.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

public class ParseJwtTest  {

    public static void main(String[] args) throws Exception {
        Claims claims = Jwts.parser().setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE2NjA1MDU1OTIsImV4cCI6MTY2MDUwNTY1Miwicm9sZSI6ImFkbWluIn0.LW6oYQ9YRK3Za47d6Kqj8YZNazztNGNSMIvEQ-D28GU")
                .getBody();
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println(claims.get("role"));

    }
}
