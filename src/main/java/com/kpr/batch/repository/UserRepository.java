/**
 * 
 */
package com.kpr.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kpr.batch.model.User;

/**
 * @author PushkarRajuKoppanath
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
