package springproject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springproject.data.MessageRepository;
import springproject.model.Message;

@Controller
@RequestMapping("/messages")
public class MessageController {
	private MessageRepository messageRepository;
	
	@Autowired
	public MessageController(MessageRepository messageRepository){
		this.messageRepository = messageRepository;
	}
	/*
	@RequestMapping(method=RequestMethod.GET)
	public String messages(Model model){
		model.addAttribute(
				"messageList",
				messageRepository.findMessage(Long.MAX_VALUE, 20)
		);
		return "messages";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String messages(Map model){
		model.put(
				"messageList", 
				messageRepository.findMessage(Long.MAX_VALUE, 20));
		return "messages";
	}
	*/
	@RequestMapping(method=RequestMethod.GET)
	public List<Message> messages(
		@RequestParam(value = "max"  , defaultValue = "238900" ) 	long max,
		@RequestParam(value = "count", defaultValue = "20") 		int count
			){
		return messageRepository.findMessage(max, count);
	}
	
	@RequestMapping(value="/{messageId}", method=RequestMethod.GET)
	public String showMessage(
			@PathVariable("messageId") long messageId,
			Model model
			){
		model.addAttribute(messageRepository.showOne(messageId));
		return "message";		
	}
}
