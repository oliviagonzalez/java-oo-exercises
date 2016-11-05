package Blogz;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PostAndUserTest {
	
	@Test
	public void testUserInit() {
		User u = new User("username", "password");
		assertEquals("username", u.getUsername());
		assertEquals("password", u.getPassword());
	}
	
	@Test
	public void invalidPasswordToIsValidPassword(){
		fail("Not yet implemented");
	}
	
	@Test
	public void validPasswordToIsValidPassword(){
		fail("Not yet implemented");
	}

	@Test
	public void shouldNotThrowExceptionWhenUsernameIsValid() {
		try{
			User u = new User("username", "password");
			assertTrue(true);
		}
		catch(Exception e){
			fail("An exception was thrown for a valid input");
		}
	}
	
	@Test
	public void shouldThrowExceptionWhenUsernameIsTooLong() {
		try{
			User u = new User("abcdef123456789", "password");
			fail("Exception was not thrown for invalid username");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void shouldThrowExceptionWhenUsernameIsTooShort() {
		try{
			User u = new User("abc", "password");
			fail("Exception was not thrown for invalid username");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void shouldThrowExceptionWhenUsernameStartsWithNumber() {
		try{
			User u = new User("123456789", "password");
			fail("Exception was not thrown for invalid username");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
		
	}
	
	@Test
	public void shouldThrowExceptionWhenUsernameContainsSymbol() {
		try{
			User u = new User("abcd!", "password");
			fail("Exception was not thrown for invalid username");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void shouldNotThrowExceptionWhenUsernameContainsUnderscore() {
		try{
			User u = new User("ab_cd", "password");
			assertTrue(true);
		}
		catch(Exception e){
			fail("An exception was thrown for a valid input");
		}
	}
	
	@Test
	public void shouldNotThrowExceptionWhenUsernameContainsDash() {
		try{
			User u = new User("ab-cd", "password");
			assertTrue(true);
		}
		catch(Exception e){
			fail("An exception was thrown for a valid input");
		}
	}
	
	@Test
	public void multipleUsers() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testPostInit() {
		Post p = new Post("title", "body", "author");
		Date created = new Date();
		assertEquals("title", p.getTitle());
		assertEquals("body", p.getBody());
		assertEquals("author", p.getAuthor());
		assertEquals(created, p.getCreatedDate());
	}
	
	@Test
	public void createdTimeForPostDoesNotUpdate() {
		Post p = new Post("title", "body", "author");
		Date originalCreatedDate = p.getCreatedDate();
		p.setTitle("newTitle");
		assertEquals(originalCreatedDate, p.getCreatedDate());
		p.setBody("newBody");
		assertEquals(originalCreatedDate, p.getCreatedDate());
	}
	
	@Test
	public void modifiedTimeForPostUpdates() {
		Post p = new Post("title", "body", "author");
		p.setTitle("newTitle");
		Date modifiedTitleDate = new Date();
		assertEquals(modifiedTitleDate, p.getModifiedDate());
		p.setBody("newBody");
		Date modifiedBodyDate = new Date();
		assertEquals(modifiedBodyDate, p.getModifiedDate());
	}

}
