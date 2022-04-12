package com.ine.sge.v1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UniversoController {

@RequestMapping("/universo")
		public String provincia(){		 
			return "provincia";
		}

}
