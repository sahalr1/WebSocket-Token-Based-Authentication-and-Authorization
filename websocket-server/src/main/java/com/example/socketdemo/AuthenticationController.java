package com.example.socketdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
@RequestMapping("/api/token")
public class AuthenticationController {
	@Autowired
	private SimpMessagingTemplate messageSender;

	@Autowired
	private AuthenticationService authService;
@Autowired
private UserService userService;
	@RequestMapping(value = "/generate-token", method = RequestMethod.POST)
	public ResponseEntity<AuthToken> register(@RequestBody LoginUser loginUser)
			throws AuthenticationException{

		AuthToken authToken = authService.generateToken(loginUser);

		
		return ResponseEntity.ok().body(authToken);
	}

	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public User getUser()
			throws AuthenticationException{

	User user=userService.findByUsername("sahal");


		return user;
	}

	@RequestMapping(value = "/invoke", method = RequestMethod.GET)
	public String sendActivity( Principal principal) {

		System.out.println("Current User  ::::"+principal);
		messageSender.convertAndSendToUser("sahal","/topic/reply","working++++++++++++++++++++");

		return "Heeeeeeeeeeeeeeeeeeeeeyyyyyyyyyyyyy";
	}


}
