package poe.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poe.spring.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	//Spring genere du code avec la signature de cette methode, en meme temps que la requete sql
	public User findByLogin(String login);
}
