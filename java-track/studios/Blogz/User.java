package Blogz;

import java.util.regex.Pattern;

public class User extends Entity{
	
	private String username;
	private static String hashedPassword;
	
	public User(String un, String pw){
		super();
		if(IsValidUsername(un) == false){
			throw new IllegalArgumentException();
		}
		this.username = un;
		hashedPassword = hashPassword(pw);		
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return hashedPassword;
	}
	
	private static String hashPassword(String password){
		//TODO: implement password hashing
		return password;
	}
	
	private Boolean isHashedPassword(){
		//TODO implement check for valid password
		//		4-12 characters long
		//		starts with a letter
		//		contains only letters, numbers, -, and _
		return true;
	}
	
	private Boolean IsValidPassword(String pw){
		//TODO: verify a password against its hash
		return true;
	}
	
	private Boolean IsValidUsername(String username){
		return Pattern.matches("[a-zA-Z][a-zA-Z0-9_-]{4,11}", username);
	}

}
