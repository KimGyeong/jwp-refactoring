package kitchenpos.ui;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import kitchenpos.application.ProductService;
import kitchenpos.domain.Money;
import kitchenpos.domain.Product;
import kitchenpos.dto.product.ProductCreateRequest;
import kitchenpos.dto.product.ProductCreateResponse;
import kitchenpos.dto.product.ProductFindAllResponse;
import kitchenpos.dto.product.ProductFindAllResponses;

@WebMvcTest(ProductRestController.class)
class ProductRestControllerTest {
	@MockBean
	private ProductService productService;

	private MockMvc mockMvc;

	private ObjectMapper objectMapper;

	private Product product;

	private ProductCreateRequest productCreateRequest;

	private ProductCreateResponse productCreateResponse;

	private ProductFindAllResponse productFindAllResponse;

	private ProductFindAllResponses productFindAllResponses;

	@BeforeEach
	void setUp(WebApplicationContext webApplicationContext) {
		objectMapper = new ObjectMapper();

		this.mockMvc = MockMvcBuilders
			.webAppContextSetup(webApplicationContext)
			.build();

		product = new Product(1L, "김", new Money(1000L));

		productCreateRequest = new ProductCreateRequest(null, product.getName(), product.getPrice().getValue());

		productCreateResponse = new ProductCreateResponse(product);

		productFindAllResponse = new ProductFindAllResponse(product);

		productFindAllResponses = new ProductFindAllResponses(Collections.singletonList(productFindAllResponse));
	}

	@Test
	void create() throws Exception {
		given(productService.create(any(ProductCreateRequest.class))).willReturn(productCreateResponse);

		mockMvc.perform(post("/api/products")
			.content(objectMapper.writeValueAsString(productCreateRequest))
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(header().string("Location", "/api/products/1"));
	}

	@Test
	void list() throws Exception {
		given(productService.findAll()).willReturn(productFindAllResponses);

		mockMvc.perform(get("/api/products")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
}