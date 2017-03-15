package test;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import springproject.data.UserRepository;
import springproject.model.User;
import springproject.web.UserController;

public class RegisterFormTest {

	@Test
	public void test() throws Exception {
		
		UserRepository mockRepository = mock(UserRepository.class);
		
		UserController controller = new UserController(mockRepository);
		
		User preUser  = new User("P","W","PW","WP");
		User postUser = new User("P","W","PW","WP");
		
		when(mockRepository.addNewUser(preUser))
			.thenReturn(postUser);
		
		MockMvc mockMvc = standaloneSetup(controller)
				.build();
		
		mockMvc.perform(post("/user/register")
			.param("firstName","P")
			.param("lastName","W")
			.param("userName","PW")
			.param("password","WP"))
			.andExpect(redirectedUrl("/user/"+postUser.getUserName()));
		
		verify(mockRepository, atLeastOnce()).addNewUser(preUser);
		
	}

}
