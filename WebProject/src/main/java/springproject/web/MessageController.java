package springproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springproject.model.MessageRepository;

@Controller
@RequestMapping("/messages")
public class MessageController {
	private MessageRepository messageRepository;
	
	@Autowired
	public MessageController(MessageRepository messageRepository){
		this.messageRepository = messageRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String messages(Model model){
		model.addAttribute(
				messageRepository.findMessage(Long.MAX_VALUE, 20)
		);
		return "messages";
	}
}
