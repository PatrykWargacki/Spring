package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

import springproject.data.MessageRepository;
import springproject.model.Message;
import springproject.web.MessageController;

public class MsgRepoTest{

	@Test
	public void test() throws Exception {
		List<Message> expectedMessages = createMessageList(50);
		MessageRepository mockRepository = mock(MessageRepository.class);
		
		when(mockRepository.findMessage(238900, 50))
			.thenReturn(expectedMessages);
		
		MessageController controller = new MessageController(mockRepository);
		
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(
						new InternalResourceView("/WEB-INF/views/messages.jsp"))
				.build();
		mockMvc.perform(get("/messages?max=238900&count=50"))
			.andExpect(view().name("messages"))
			.andExpect(model().attributeExists("messageList"))
			.andExpect(model().attribute("messageList", hasItems(expectedMessages.toArray())));
		
	}

	private List<Message> createMessageList(int count){
		List<Message> messages = new ArrayList<Message>();
		for(int i=0;i<count;i++){
			messages.add(new Message("MSG " + i));
		}
		return messages;
	}
}
