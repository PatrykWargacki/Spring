package springproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springproject.data.UserRepository;
import springproject.model.User;

@Controller
@RequestMapping(value="/user")
public class UserController {

	private UserRepository userRepository;
	
	@Autowired
	public UserController(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm(){
		return "registerForm";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistrationForm(User user){
		userRepository.addNewUser(user);
		return "redirect:/user/" + user.getUserName();
	}
	
	@RequestMapping(value="/{userName}", method=RequestMethod.GET)
	public User showUser(
			@RequestParam(value="userName") String userName
			){
		return userRepository.findUser(userName);
	}
}
