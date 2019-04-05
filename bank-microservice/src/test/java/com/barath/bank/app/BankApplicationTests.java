package com.barath.bank.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties= {"spring.cloud.discovery.enabled = false"})
public class BankApplicationTests {

	@Test
	public void contextLoads() {
	}

}
