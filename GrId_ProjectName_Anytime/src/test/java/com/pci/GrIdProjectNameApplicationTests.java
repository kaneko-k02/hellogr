package com.pci;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pci.security.UserAccountService;

@SpringBootTest
class GrIdProjectNameApplicationTests {
	@Autowired
	private UserAccountService sv;
	
	@Test
	void contextLoads() {
		sv.registerMgr("1001", "mgr", "江戸　一郎", true);
		sv.registerUser("1003", "user", "平川　太郎", true);
		sv.registerUser("1004", "user", "大手　二郎", true);
		sv.registerUser("1005", "user", "桔梗　花子", true);
	}

}
