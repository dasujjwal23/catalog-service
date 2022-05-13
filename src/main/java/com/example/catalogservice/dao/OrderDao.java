package com.example.catalogservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.catalogservice.entity.Catagory;

public interface OrderDao extends JpaRepository<Catagory, Integer>{

	@Query("select u from Catagory u where u.catagory= :catagory")
	public List<Catagory> findByCatagory(@Param("catagory") String catagory);
}
