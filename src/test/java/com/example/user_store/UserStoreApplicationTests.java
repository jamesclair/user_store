package com.example.user_store;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class UserStoreApplicationTests extends AbstractBaseControllerMock {
	@Test
	public void testGetUnauthenticatedPath() throws Exception {
		String uri = "/public";
		MvcResult mvcResult = super.getMvc().perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@SneakyThrows
	@Test
	@WithMockUser(username = "user1",roles = {"USER"})
	public void testGetAuthenticatedPath() throws Exception {
		super.getMvc().perform(MockMvcRequestBuilders.get("/private")
						.header("Authorization", "Basic " + Base64.getEncoder().encodeToString("user1:password".getBytes())))
				.andExpect(ResultMatcher.matchAll(status().isOk()))
				.andDo(print());
	}

}
