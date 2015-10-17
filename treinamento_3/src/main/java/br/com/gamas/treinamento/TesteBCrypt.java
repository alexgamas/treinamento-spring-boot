package br.com.gamas.treinamento;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TesteBCrypt {
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("password"));
	}
}
