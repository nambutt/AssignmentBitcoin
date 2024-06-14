package com.example.assignment;

import com.example.assignment.controller.BitcoinController;
import com.example.assignment.service.BitcoinService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {BitcoinController.class, BitcoinService.class})
@WebMvcTest
public class BitcoinControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private BitcoinService bitcoinService;

    @DisplayName("JUnit test for fetchAndSaveBitcoinPrices method")
    @Test
    public void testFetchAndSaveBitcoinPrices() throws Exception {
        ResultActions response = mockmvc.perform(MockMvcRequestBuilders.get("/api/fetch-and-save"));
        response.andExpect(status().isOk());
    }

    @DisplayName("JUnit test for showData method")
    @Test
    public void testShowData() throws Exception {
        ResultActions response = mockmvc.perform(MockMvcRequestBuilders.get("/api/show-data"));
        assertNotNull(response);
    }
}
