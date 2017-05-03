package ch.vd.spring.rest;

import ch.vd.spring.ApplicationConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientRestControllerTest {

    // ---  initialisation du MockMVC avec le context Web

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void initTests(){
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    // ---  initialisation du MockMVC avec le context Web

    public static final String clientUri = "/client";

    private final Logger logger = LoggerFactory.getLogger(ClientRestControllerTest.class);

    @Test
    public void testClientList() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get(clientUri))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].nom").value("Client1 nom"))
                .andExpect(jsonPath("$[1].nom").value("Client2 nom"))
                .andReturn();

        logger.info("List de des clients {}", mvcResult.getResponse().getContentAsString());
    }
}
