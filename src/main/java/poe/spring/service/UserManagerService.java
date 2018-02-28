package poe.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.domain.User;
import poe.spring.repository.UserRepository;

@Service
public class UserManagerService {

	@Autowired
	private UserRepository userRepository;

	public User signup(String login, String password) {

		User user = null;
		
		if(!isExist(login)) {
			user = new User();
			user.setLogin(login);
			user.setPassword(password);
			userRepository.save(user);
		}		

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