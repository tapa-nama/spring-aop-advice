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
        Logger.clear();
    }

    @Autowired
    UserService userService;

    @Test
    void should_execute_before_joinPint() {
        userService.add(2, 3);
        Assert.assertEquals(Arrays.asList("@Before", "2 + 3 = 5"), Logger.getLogs());
    }

    @Test
    void should_execute_after_joinPoint() {
        userService.subtract(3, 2);
        Assert.assertEquals(Arrays.asList("3 - 2 = 1", "@After"), Logger.getLogs());
    }

    @Test
    void should_execute_around_joinPint() {
        userService.multiply(3, 3);
        Assert.assertEquals(Arrays.asList("@Around: Before calculation-", "3 * 3 = 9", "@Around: After calculation-"), Logger.getLogs());

    }
}
