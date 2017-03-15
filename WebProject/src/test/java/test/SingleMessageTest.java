package test;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import springproject.data.MessageRepository;
import springproject.model.Message;
import springproject.web.MessageController;

public class SingleMessageTest {

	@Test
	public void test() throws Exception {
		Message expectedMessage = new Message("MSG");
		MessageRepository mockRepository = mock(MessageRepository.class);
		
		when(mockRepository.showOne(12345))
				.thenReturn(expectedMessage);
		
		MessageController controller = new MessageController(mockRepository);
		
		MockMvc mockMvc = standaloneSetup(controller)
				.build();
		
		mockMvc.perform(get("/messages/12345"))
			.andExpect(view().name("message"))
			.andExpect(model().attributeExists("message"))
			.andExpect(model().attribute("message", hasItems(expectedMessage)));
	}

}
