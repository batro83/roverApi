package com.walla.rover.api.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpStatus.OK;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration Test
 * 
 * @author roger
 *
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoverControllerTest {

	private static final String PATH = "/mars/{command}";

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void test1_moveLeftTest() {
		final ResponseEntity<String> response = post("l");
		assertEquals(OK, response.getStatusCode());
		assertEquals("(10,1,N)", response.getBody());
	}

	@Test
	public void test2_moveRightTest() {
		final ResponseEntity<String> response = post("r");
		assertEquals(OK, response.getStatusCode());
		assertEquals("(1,1,N)", response.getBody());
	}

	@Test
	public void test3_moveForwardTest() {
		final ResponseEntity<String> response = post("f");
		assertEquals(OK, response.getStatusCode());
		assertEquals("(1,2,N)", response.getBody());
	}

	@Test
	public void test4_moveBackwardTest() {
		final ResponseEntity<String> response = post("b");
		assertEquals(OK, response.getStatusCode());
		assertEquals("(1,1,N)", response.getBody());
	}

	@Test
	public void test5_moveWithObstacles() {
		final ResponseEntity<String> response = post("rrffb");
		assertEquals(OK, response.getStatusCode());
		assertEquals("(3,2,N) Obstacle(3,3)", response.getBody());
	}

	private ResponseEntity<String> post(String command) {
		return restTemplate.exchange(PATH, HttpMethod.POST, HttpEntity.EMPTY, String.class, command);
	}

}
