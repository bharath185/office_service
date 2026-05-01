package com.officeconnect.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String SECRET_KEY = "RimIndiaRimIndiaRimIndiaRimIndia"; // 32 bytes for HS256
    private static final String AUTH_KEY = "RimAuth";
    private static final String OFFICE_CONNECT_KEY = "OfficeConnect";
    private static final String VISITORS_KEY = "Visitors";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Max-Age", "3600");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        String authHeader = request.getHeader("Authorization");
        String authKeyHeader = request.getHeader("AuthKey");
        String requestUri = request.getRequestURI();

        if (isPublicEndpoint(requestUri)) {
            filterChain.doFilter(request, response);
            return;
        }

        if (authHeader == null || authHeader.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"StatusCode\":401,\"Message\":\"Unauthorized\"}");
            return;
        }

        if (authHeader.equals(OFFICE_CONNECT_KEY) || authHeader.equals(VISITORS_KEY)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            Claims claims = decodeToken(authHeader);
            if (claims == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"StatusCode\":401,\"Message\":\"Token Invalid\"}");
                return;
            }

            String issuedAt = (String) claims.get("iat");
            if (isTokenExpired(issuedAt)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"StatusCode\":401,\"Message\":\"Token Expired\"}");
                return;
            }

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"StatusCode\":401,\"Message\":\"Invalid Token\"}");
        }
    }

    private boolean isPublicEndpoint(String uri) {
        // TEMPORARY: Allow ALL endpoints for testing
        return true;
    }

    private Claims decodeToken(String token) {
        try {
            // Use the SECRET_KEY bytes directly (same as encoding)
            byte[] keyBytes = SECRET_KEY.getBytes(java.nio.charset.StandardCharsets.UTF_8);
            SecretKey key = Keys.hmacShaKeyFor(keyBytes);
            return Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (Exception e) {
            // Try alternate decoding
            try {
                byte[] keyBytes = base64UrlDecode(SECRET_KEY);
                SecretKey key = Keys.hmacShaKeyFor(keyBytes);
                return Jwts.parser()
                        .verifyWith(key)
                        .build()
                        .parseSignedClaims(token)
                        .getPayload();
            } catch (Exception e2) {
                System.out.println("JWT Decode Error: " + e.getMessage());
                return null;
            }
        }
    }

    private boolean isTokenExpired(String issuedAt) {
        try {
            long issuedTime = Long.parseLong(issuedAt);
            long currentTime = System.currentTimeMillis() / 1000;
            long hoursDiff = (currentTime - issuedTime) / 3600;
            return hoursDiff > 24;
        } catch (Exception e) {
            return true;
        }
    }

    public static String encodeAuthToken(String user) {
        try {
            // Use the SECRET_KEY bytes directly - it must be at least 256 bits (32 bytes)
            byte[] keyBytes = SECRET_KEY.getBytes(java.nio.charset.StandardCharsets.UTF_8);
            SecretKey key = Keys.hmacShaKeyFor(keyBytes);
            long issued = System.currentTimeMillis() / 1000;
            String token = Jwts.builder()
                    .claim("user", user)
                    .claim("iat", String.valueOf(issued))
                    .signWith(key)
                    .compact();
            System.out.println("=== encodeAuthToken SUCCESS ===");
            System.out.println("Token: " + token);
            return token;
        } catch (Exception e) {
            System.out.println("=== encodeAuthToken FAILED ===");
            e.printStackTrace();
            return null;
        }
    }

    public static String encodeToken(String user, String empCode) {
        return encodeAuthToken(user);
    }

    public static byte[] base64UrlDecode(String arg) {
        try {
            return java.util.Base64.getUrlDecoder().decode(arg);
        } catch (Exception e) {
            // If not valid base64, return bytes directly
            return arg.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        }
    }
}