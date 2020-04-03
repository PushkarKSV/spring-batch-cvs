/**
 * 
 */
package com.kpr.batch.batch1;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpr.batch.model.User;
import com.kpr.batch.repository.UserRepository;

/**
 * @author PushkarRajuKoppanath
 *
 */
@Component
public class DBWriter implements ItemWriter<User> {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void write(List<? extends User> users) throws Exception {
		System.out.println(users);
		userRepository.save(users);
	}
	
}
