package com.example.catalogservice;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogservice.dao.OrderDao;
import com.example.catalogservice.entity.Catagory;

@SpringBootApplication
@RestController
public class CatalogServiceApplication {

	@Autowired
	private OrderDao orderDao;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}
	
	@PostConstruct
	public void initOrders()
	{
		orderDao.saveAll(
				Stream.of(
						new Catagory(100,"Realme","Black",10000),
						new Catagory(101,"Realme","Red",14500),
						new Catagory(102,"Micromax","Black",11000),
						new Catagory(103,"samsung","Black",12000),
						new Catagory(104,"Redmi","Red",5500),
						new Catagory(105,"poco","Black",13000),
						new Catagory(106,"oneplus","Black",31000)
						).collect(Collectors.toList())
				);
	}
	
	@GetMapping("/pagination/{offset}/{pageSize}")
	public List<Catagory> findCatagorywithPagination(@PathVariable int offset,@PathVariable int pageSize){
		
		Pageable pageable=PageRequest.of(offset, pageSize);
		Page<Catagory> catagory=orderDao.findAll(pageable);
		return catagory.toList();
	}
	
	@GetMapping("/paginationfield/{offset}/{pageSize}/{field}")
	public List<Catagory> findCatagorywithPaginationwithsorting(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
		
		Page<Catagory> catagory=orderDao.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,field)));
		return catagory.toList();
	}
	
	@GetMapping("/orders")
	public List<Catagory> getOrders()
	{
		return orderDao.findAll();
	}
	
	@GetMapping("/findorder/{id}")
	public Catagory getOrdersById(@PathVariable("id") int id) throws Exception{
		return this.orderDao.findById(id).orElseThrow(()-> new Exception("Record not found"));	
	}
	
	@GetMapping("/order/{id}")
	public Optional<Catagory> getOrderById(@PathVariable("id") int id){
		return this.orderDao.findById(id);	
	}
	
	@GetMapping("/orders/{catagory}")
	public List<Catagory> getOrdersByCatgory(@PathVariable("catagory") String catagory)
	{
		return orderDao.findByCatagory(catagory);
	}

}
