package br.com.caelum.eats.seguranca;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
class JwtTokenManager {

	private String secret;
	private long expirationInMillis;

	public JwtTokenManager(	@Value("${jwt.secret}") String secret, 
							@Value("${jwt.expiration}") long expirationInMillis) {
		this.secret = secret;
		this.expirationInMillis = expirationInMillis;
	}

	public String generateToken(User user) {
		final Date now = new Date();
		final Date expiration = new Date(now.getTime() + this.expirationInMillis);
		return Jwts.builder().setIssuer("Caelum Eats").setSubject(Long.toString(user.getId())).setIssuedAt(now)
				.setExpiration(expiration).signWith(SignatureAlgorithm.HS256, this.secret).compact();
	}

	public boolean isValid(String jwt) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(jwt);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}

	public Long getUserIdFromToken(String jwt) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(jwt).getBody();
		return Long.parseLong(claims.getSubject());
	}

}
