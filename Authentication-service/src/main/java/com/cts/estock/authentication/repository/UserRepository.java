package com.cts.estock.authentication.repository;

import com.cts.estock.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //@Query(value="Select * from user_details where email_id=?1", nativeQuery = true)
    public User findByEmailId(String emailId);

    @Query(value="Select count(*) from user_details", nativeQuery = true)
    public int getCount();
}
