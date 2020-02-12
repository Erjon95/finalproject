package com.perscholas.nov2019.philly.capstone.finalproject;

import com.perscholas.nov2019.philly.capstone.finalproject.controllers.EventController;
import com.perscholas.nov2019.philly.capstone.finalproject.controllers.TicketBuyerController;
import com.perscholas.nov2019.philly.capstone.finalproject.controllers.TicketSellerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FinalprojectApplicationTests {

	@Autowired
	TicketBuyerController ticketBuyerController;
	@Autowired
	TicketSellerController ticketSellerController;
	@Autowired
	EventController eventController;

	@Test
	void contextLoads() {
		assertThat(ticketBuyerController).isNotNull();
		assertThat(ticketSellerController).isNotNull();
		assertThat(eventController).isNotNull();
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}

}
