package com.naveen.batch.processor;
import java.util.HashMap;
import java.util.*;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.naveen.batch.model.User;
@Component
public class Processor implements ItemProcessor<User,User> {
	
	private static final Map<String,String> DEPT_NAMES=new HashMap<>();
	
	public Processor()
	{
		DEPT_NAMES.put("001","Technology");
		DEPT_NAMES.put("002","Operations");
		DEPT_NAMES.put("003","Accounts");
		
	}

	@Override
	public User process(User user) throws Exception {
		
		String deptCode=user.getDept();
		String dept=DEPT_NAMES.get(deptCode);
		
		user.setDept(dept);
		System.out.println(" processor ended dept code ");
		return user;
	}

}
