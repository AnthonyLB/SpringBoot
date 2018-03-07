package poe.spring.api;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.aop.Chrono;
import poe.spring.domain.User;
import poe.spring.exception.DuplicateLoginBusinessException;
import poe.spring.service.UserManagerService;

@RestController
@RequestMapping("/api/user")
public class UserRestController{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	UserManagerService userManagerService;
	
	@PostMapping("/save")
	@Chrono //Annotation precedement cree
	public User save(@RequestBody(required=true) User user, HttpServletResponse response) {
		User savedUser = null;
		try {
			savedUser = userManagerService.signup(user.getLogin(), user.getPassword());
		} catch (DuplicateLoginBusinessException e) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		}
		return savedUser;
	}
	
	@PostMapping("/delete")
	public User delete(@RequestBody(required=true) User user) {
		userManagerService.delete(user);
		LOG.debug("user deleted id: " + user);
		return user;
	}
	
	@PostMapping("/exist")
	public boolean isExist(@RequestBody(required=true) User user) {
		return userManagerService.isExist(user.getLogin());
	}
	
	@PostMapping("/all")
	public Iterable<User> findAll(){
		return userManagerService.findAll();
	}
}
