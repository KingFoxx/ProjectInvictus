package com.example.demo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.domain.Crypto;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the MockMvc object
@Sql(scripts = { "classpath:crypto-schema.sql",
		"classpath:crypto-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class CryptoControllerIntegrationTest {

	@Autowired // pull the MockMvc object from context - used instead of postman for requests
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper; // java <-> JSON converter that spring uses

	@Test
	void testCreate() throws Exception {
		Crypto testCrypto = new Crypto(null, "BitCoin", "BTC", 3.1, 15000.34);
		String testCryptoAsJSON = this.mapper.writeValueAsString(testCrypto);
		RequestBuilder req = post("/Create").contentType(MediaType.APPLICATION_JSON).content(testCryptoAsJSON);

		Crypto testCreatedCrypto = new Crypto(4, "BitCoin", "BTC", 3.1, 15000.34);
		String testCreatedCryptoAsJSON = this.mapper.writeValueAsString(testCreatedCrypto);

		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedCryptoAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void getAllTest() throws Exception {
		RequestBuilder req = get("/getAll");

		List<Crypto> testCrypto = List.of(new Crypto(1, "BitCoin", "BTC", 3.1, 15000.34),
				new Crypto(2, "Etherium", "ETH", 5.3, 20000.56), new Crypto(3, "LiteCoin", "LTC", 300.0, 1500.56));
		String json = this.mapper.writeValueAsString(testCrypto);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void getOneCrypto() throws Exception {
		RequestBuilder req = get("/get/1");

		String json = this.mapper.writeValueAsString(new Crypto(1, "BitCoin", "BTC", 3.1, 15000.34));

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testReplace() throws Exception {
		Crypto testCrypto = new Crypto(null, "BitCoin", "BTC", 3.1, 15000.34);
		String testCryptoAsJSON = this.mapper.writeValueAsString(testCrypto);
		RequestBuilder req = put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(testCryptoAsJSON);

		Crypto testUpdatedCrypto = new Crypto(1, "BitCoin", "BTC", 3.1, 15000.34);
		String testUpdatedCryptoAsJSON = this.mapper.writeValueAsString(testUpdatedCrypto);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testUpdatedCryptoAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	public void testDelete() throws Exception {
		this.mvc.perform(delete("/remove/2")).andExpect(status().isNoContent());
	}

	@Test
	void getCryptoName() throws Exception {
		RequestBuilder req = get("/getByName/BitCoin");

		List<Crypto> testCrypto = List.of(new Crypto(1, "BitCoin", "BTC", 3.1, 15000.34));
		String json = this.mapper.writeValueAsString(testCrypto);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void getCryptoABV() throws Exception {
		RequestBuilder req = get("/getByAbbreviation/BTC");

		List<Crypto> testCrypto = List.of(new Crypto(1, "BitCoin", "BTC", 3.1, 15000.34));
		String json = this.mapper.writeValueAsString(testCrypto);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void getCryptoAMT() throws Exception {
		RequestBuilder req = get("/getByAMT/3.1");

		List<Crypto> testCrypto = List.of(new Crypto(1, "BitCoin", "BTC", 3.1, 15000.34));
		String json = this.mapper.writeValueAsString(testCrypto);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void getCryptoCost() throws Exception {
		RequestBuilder req = get("/getByCost/15000.34");

		List<Crypto> testCrypto = List.of(new Crypto(1, "BitCoin", "BTC", 3.1, 15000.34));
		String json = this.mapper.writeValueAsString(testCrypto);

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(json);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

}
