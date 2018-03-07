package poe.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import poe.spring.exception.DuplicateLoginBusinessException;
import poe.spring.domain.User;
import poe.spring.repository.UserRepository;

@Service
public class UserManagerService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private InMemoryUserDetailsManager inMemoryUserDetailsManager;
	
	public User signup(String login, String password) throws DuplicateLoginBusinessException {

		User user = null;
		
		if(!isExist(login)) {
			user = new User();
			user.setLogin(login);
			user.setPassword(password);
			userRepository.save(user);
			inMemoryUserDetailsManager.createUser(new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), new ArrayList<GrantedAuthority>()));
		}else throw new DuplicateLoginBusinessException();

		return user;
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	public boolean isExist(String login) {
		
		boolean isExist = false;
		if(userRepository.findByLogin(login)!=null) isExist=true;
		return isExist;		
	}
	
	public Iterable<User> findAll(){
		return userRepository.findAll();
	}
}