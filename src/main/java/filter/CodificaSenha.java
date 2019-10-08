package filter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CodificaSenha {
	
	public static final BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();

}
