package ch.vd.spring.web;

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

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.Assert.*;

/**
 * Created by mourad on 03/05/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootRestController.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BootRestControllerTest {

    // ---  initialisation du MockMVC avec le context Web

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void initTests(){
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    // ---  initialisation du MockMVC avec le context Web

    public static final String helloURI = "/hello";

    private final Logger logger = LoggerFactory.getLogger(BootRestControllerTest.class);

    @Test
    public void testSayHello() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get(helloURI))
                .andExpect(status().isOk())

                .andReturn();

        assertEquals(mvcResult.getResponse().getContentAsString(), "[\"Hello Spring Boot !\"]");
    }
}
