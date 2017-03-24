package springproject.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String showRegistrationForm(Model model){
		model.addAttribute(new User());
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistrationForm(
			@Valid User user, 
			Errors errors
			){
		if(errors.hasErrors()){
			return "registerForm";
		}
		return "redirect:/user/" + userRepository.addNewUser(user).getUserName();
	}
	
	@RequestMapping(value="/{userName}", method=RequestMethod.GET)
	public String showUser(
			@PathVariable String userName,
			Model model
			){
		model.addAttribute(userRepository.findUser(userName));
		return "profile";
	}
}
