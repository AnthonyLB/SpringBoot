package poe.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import poe.spring.domain.User;
import poe.spring.repository.UserRepository;
import poe.spring.service.UserManagerService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerServiceTests {

	@Autowired
	UserManagerService userManagerService;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void checkUserCreation() {
		assertThat("toto").isEqualTo("toto");
		
		//Enregistre un utilisateur en BDD
		String login = "bob";
		String pwd = "bob";		
		User createdUser = userManagerService.signup(login,pwd);
		
		//Recupere l'utilisateur precedement cree fen BDD
		long createdUserId = createdUser.getId();
		User user = userRepository.findOne(createdUserId);
		
		//Verification
		assertThat(user).isNotNull();
		assertThat(user.getLogin()).isEqualTo(login);
		
		//Verification qu'on n'a pas pu créer un user avec le meme login
		User duplicateUser = userManagerService.signup(login, "secret");
		assertThat(duplicateUser).isNull();
		
		//Verification qu'on puisse toujours créer d'autre user
		assertThat(userManagerService.signup(login+"notTheSame", "secret")).isNotNull();
		
	}
}
