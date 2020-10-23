package net.appen.weather.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.appen.weather.model.DayWeather;
import net.appen.weather.services.GetLiveWeather;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class UserController {
	
	@Autowired
	private GetLiveWeather liveWeather;
	
	
	@PostMapping("getWeather")
	public List<List<DayWeather>> getWeather(@RequestBody Map<String, String> coords) throws Exception{
		return liveWeather.getWeather(coords);
	}
}
