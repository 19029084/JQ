package com.jq.security.repository;

import com.jq.entity.JQUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface JQUserRepository extends JpaRepository<JQUser,String> 
{

	@Query("select u from JQUser u where LOWER(u.username)=lower(:username)")
	JQUser findByUsernameCaseInsensitive(@Param("username") String username);

}
