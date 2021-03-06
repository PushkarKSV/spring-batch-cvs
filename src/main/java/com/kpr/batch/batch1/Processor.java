/**
 * 
 */
package com.kpr.batch.batch1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.kpr.batch.model.User;

/**
 * @author PushkarRajuKoppanath
 *
 */
@Component
public class Processor implements ItemProcessor<User, User>{
	
	private static final Map<String, String> DEPT_NAMES = new HashMap<String, String>();
	
	Processor(){
		DEPT_NAMES.put("001", "Technology");
		DEPT_NAMES.put("002", "Innovation");
		DEPT_NAMES.put("003", "General");
	}

	@Override
	public User process(User user) throws Exception {
		 	String deptCode = user.getDept();
	        String dept = DEPT_NAMES.get(deptCode);
	        user.setDept(dept);
	        System.out.println(String.format("Converted from [%s] to [%s]", deptCode, dept));
	        return user;
	}

	
	
}
