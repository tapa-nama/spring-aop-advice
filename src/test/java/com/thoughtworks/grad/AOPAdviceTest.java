package com.thoughtworks.grad;

import com.thoughtworks.grad.concretepage.Logger;
import com.thoughtworks.grad.concretepage.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AOPAdviceTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Autowired
    UserService userService;

    @Test
    void should_execute_before_joinPint() {
        userService.multiply(2, 3);
        Assert.assertEquals(Arrays.asList("@Before:", "2 * 3 = 6"), Logger.getLogs());
    }
}
