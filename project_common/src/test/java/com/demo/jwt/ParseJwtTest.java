package com.demo.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

public class ParseJwtTest  {

    public static void main(String[] args) throws Exception {
        Claims claims = Jwts.parser().setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE2NjA2NTg2OTEsImV4cCI6MTY2MDY1ODc1MSwicm9sZSI6ImFkbWluIn0.fTn5QSYZRLZT9gjCWCQ0qArneeFxqsEThMjFSbPabDY")
                .getBody();
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println(claims.get("role"));

    }
}
