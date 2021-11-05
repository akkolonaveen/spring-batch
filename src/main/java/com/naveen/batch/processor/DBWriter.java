package com.naveen.batch.processor;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naveen.batch.model.User;
import com.naveen.batch.repository.UserRepository;
@Component
public class DBWriter  implements ItemWriter<User>{
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void write(List<? extends User> users) throws Exception {
		
		userRepository.saveAll(users);
		
	}
	

}
