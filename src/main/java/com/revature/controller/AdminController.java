package com.revature.controller;

import static com.revature.util.ClientMessageUtil.*;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Medicine;
import com.revature.service.AdminService;
import com.revature.util.ClientMessage;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/updateUser")
	public @ResponseBody <T>  ClientMessage updateUser(@RequestBody T user) {
		return (adminService.updateUser(user)) ? SUCCESSFUL_UPDATE : FAILED_UPDATE;
	}
	
	@GetMapping("/getAllMeds")
	public @ResponseBody List<Medicine> getAllMedicines() {
		return adminService.getAllMedicines();
	}
	
	@PostMapping("/order")
	public @ResponseBody ClientMessage orderMeds(HashMap<Medicine, Integer> orderList) {
		return (adminService.orderMeds(orderList)) ? ORDER_PLACED : ORDER_FAILED;
	}

}
