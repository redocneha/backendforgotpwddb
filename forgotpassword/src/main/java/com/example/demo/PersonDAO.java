package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonDAO extends CrudRepository<Person,Long> {
	  @Query("SELECT ques1,ques2 FROM Person p WHERE p.email=:email")
    ArrayList<String> findQuestionsById(String email);
	  @Query("SELECT ans1,ans2 FROM Person p WHERE p.email=:email")
    ArrayList<String> findAnswersById(String  email);
    @Query("SELECT count(*) FROM Person p WHERE p.email=:email")
    public int findByEmail(@Param("email") String email);
    @Query("UPDATE Person SET password=password  WHERE p.email=:email")
    public int setPassword(@Param("password") String password,@Param("email") String email);
}
