package com.global.common.framework.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPassEncoder {
	public static void main(String[] args) 
	{
        String password = "milan123";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(password));
	}
}