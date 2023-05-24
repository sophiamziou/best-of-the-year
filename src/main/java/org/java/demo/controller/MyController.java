package org.java.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MyController {
	@GetMapping("/hello")
	public String sayHelloToName(Model model,
		@RequestParam(name = "name") String name) {
		model.addAttribute("name", name);
		return "index";
	}
}
