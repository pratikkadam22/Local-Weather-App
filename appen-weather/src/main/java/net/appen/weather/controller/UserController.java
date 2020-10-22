package net.appen.weather.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.appen.weather.repository.DayWeather;
import net.appen.weather.services.GetLocation;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class UserController {
	
	@Autowired
	private GetLocation location;
	
//	@GetMapping("users")
//	public List<User> getUsers(){
//		return this.userRepository.findAll();
//	}
	
	@PostMapping("getWeather")
	public List<DayWeather> getWeather(@RequestBody Map<String, String> coords) throws Exception{
		return location.getWeather(coords);
		
	}
}
