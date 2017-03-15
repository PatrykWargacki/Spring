package springproject.data;

import springproject.model.User;

public interface UserRepository {
	public User addNewUser(User user);
	public User findUser(String userName);
}
