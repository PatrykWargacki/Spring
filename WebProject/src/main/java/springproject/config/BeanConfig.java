package springproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springproject.model.Message;
import springproject.model.MessageRepository;

@Configuration
public class BeanConfig {

	@Bean
	public Message message(){
		return new Message(null, null);
	}
	
	@Bean
	public MessageController messageController(){
		return new MessageController(messageRepository());
	}
	
	@Bean
	public MessageRepository messageRepository(){
		//return new MessageRepository();
		return null;
	}
}
