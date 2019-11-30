package com.bmv.main;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class appController {

	
	@RequestMapping("/")
	public String index() {
		System.out.println("Index page reached");
		return "index.html";
}
	
	@Controller
	public class loginController{
	@GetMapping("/login")
	public String login() {
		System.out.println("Index page reached");
		return "login.html";
}
	@Controller
	public class signupController{
	@GetMapping("/signup")
	public String login() {
		System.out.println("signup page reached");
		return "signup.html";
}
	
	@PostMapping("/login")
	public String loginDetails(Model model,loginDetails obj) {
		model.addAttribute("obj",obj);
		String p=obj.getUsername();
		String q=obj.getPassword();
		System.out.println("username=" + p + "  password="+ q);
		try {
			checkLogin.verifyPwd(p,q,'u');
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(checkLogin.flag==true) {
			System.out.println("CORRECT DETAILS");
			return "redirect:/dashboard";
		}else {
			System.out.println("CORRECT DETAILS");
			return "redirect:/";
		}
		
		
	}
	
	
	}
	


	@RequestMapping("/dashboard")
	public String dashboard() {
		System.out.println("Login successful");
		return "Success";
	}
}
}


