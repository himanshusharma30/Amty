package test.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import test.db.TestDB;
import test.entity.Admin;
import test.entity.Property;
import test.entity.RoomModel;
import test.entity.User;

@Controller
public class TestController {

	@RequestMapping("/")
	public ModelAndView getIndex() {
		return new ModelAndView("index");
	}

	@RequestMapping("/adminlogin")
	public ModelAndView login(@ModelAttribute Admin admin,Model model,HttpServletRequest req) {
		ModelAndView m = new ModelAndView();
		System.out.println(admin.getPassword());
		String pwd1 = TestDB.encryptedPwd(admin.getPassword());
		String pwd2=TestDB.getPassword(admin);
		System.out.println(pwd2);
		if(pwd2.equals(pwd1))
		{
			model.addAttribute("property", new Property());	
			model.addAttribute("admin", new Admin());
			m.addObject("prop", TestDB.getProperty());
			m.setViewName("rootAdmin");
			HttpSession session=req.getSession();
			session.setAttribute("adminEmail", session.getAttribute("adminEmail"));
			m.addObject("adminEmail", admin.getEmail());
		}
		else
		{
			m.addObject("error","You have entered incorrect password");
			m.setViewName("admin");
		}			
		return m;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signUp(@ModelAttribute User u, HttpServletRequest req) {
		ModelAndView m = new ModelAndView();
		if(TestDB.checkUser(u.getEmail()))
		{
			String pwd = TestDB.encryptedPwd(u.getPassword());
			u.setPassword(pwd);
			TestDB.insertUser(u);
			HttpSession session=req.getSession();
			session.setAttribute("currentUser", u);
			if(u.getType().equals("Seller"))
			{
				m.setViewName("sellerDashboard");
			}				
			else
			{
				m.setViewName("buyerDashboard");
			}
		}
		else
		{
			m.addObject("error", "This user already exists! Kindly login to your account.");
			m.setViewName("signupform");
		}
		return m;
	}

	@RequestMapping("/signupform")
	public ModelAndView signupform(Model model) {
		model.addAttribute("user", new User());
		return new ModelAndView("signupform");
	}

	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public ModelAndView checkIfExists(@RequestParam("email") String email, HttpServletRequest req) {
		ModelAndView m = new ModelAndView();
		m.addObject("email", email);
		if (TestDB.checkUser(email)) {
			req.getSession().setAttribute("email", email);
			m.setViewName("loginform");

		} else
			m.setViewName("signupform");

		return m;
	}

	@RequestMapping("/owner")
	public ModelAndView getOwner(Model theModel) {
		ArrayList<Property> propertyType=TestDB.getProperty();
		ModelAndView m=new ModelAndView();
		m.addObject("property", propertyType);
		theModel.addAttribute("RoomModel", new RoomModel());
		m.setViewName("owner");
		return m;
	}
	
	@RequestMapping("/admin")
	public ModelAndView getAdmin(Model model)
	{
		ModelAndView m=new ModelAndView();
		Admin admin=new Admin();
		admin.setEmail("admin@amtica.com");
		admin.setPassword(TestDB.encryptedPwd("admin"));
		if(TestDB.checkAdmin(admin)==false)
		{			
			TestDB.addAdmin(admin);
			m.addObject("info", "Please enter admin@amtica.com as password and admin as password");
		}
		model.addAttribute("admin", new Admin());
		m.setViewName("admin");
		return m;
	}

	@RequestMapping(value="/postAdvertisement",method=RequestMethod.POST)
	public ModelAndView postAdvertisement(@ModelAttribute RoomModel room) 
	{
		int x;
		System.out.println(room);
		try
		{
			x=TestDB.getNextRoomId();
			room.setId(x);
			System.out.println(room);
			TestDB.insertRoom(room);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ModelAndView("dashboard");
	}
	
	@RequestMapping("/addProperty")
	public ModelAndView addProperty(@ModelAttribute Property property,Model model,HttpServletRequest req)
	{
		ModelAndView m=new ModelAndView();
		System.out.println(property.getProperty_name());
		try
		{
			TestDB.insertProperty(property);
			model.addAttribute("property", new Property());	
			m.addObject("prop", TestDB.getProperty());
			model.addAttribute("admin", new Admin());
		}
		catch(NullPointerException e)
		{
			m.addObject("error","The property you entered is already present.");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		m.setViewName("rootAdmin");
		return m;
	}
	
	@RequestMapping("/deleteProperty")
	public ModelAndView deleteProperty(@ModelAttribute Property property,Model model)
	{
		
		System.out.println(property);
		ModelAndView m=new ModelAndView();
		try
		{
			TestDB.deleteProperty(property);
			model.addAttribute("property", new Property());	
			m.addObject("prop", TestDB.getProperty());
			model.addAttribute("admin", new Admin());
		}
		catch(Exception e)
		{
			m.addObject("error","The property you entered is already present.");
		}
		m.setViewName("rootAdmin");
		return m;
	}
	@RequestMapping("/loginuser")
	public String dsadf()
	{
		return null;
	}
	
	@RequestMapping("/changepassword")
	public ModelAndView changePassword(@ModelAttribute Admin admin,Model model)
	{
		ModelAndView m=new ModelAndView();
		String pwd=TestDB.encryptedPwd(admin.getPassword());
		System.out.println(admin.getEmail());
		System.out.println(admin.getPassword());
		admin.setPassword(pwd);
		TestDB.updateAdminPassword(admin);
		model.addAttribute("property", new Property());	
		m.addObject("prop", TestDB.getProperty());
		model.addAttribute("admin", new Admin());
		m.setViewName("rootAdmin");
		return m;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(Model model,HttpServletRequest req)
	{
		HttpSession session=req.getSession();
		session.invalidate();
		ModelAndView m=new ModelAndView();
		model.addAttribute("admin", new Admin());
		m.setViewName("admin");
		return m;
	}
	
	@RequestMapping("/addAdmin")
	public ModelAndView addAdmin(@ModelAttribute Admin admin,Model model,HttpSession session)
	{
		ModelAndView m=new ModelAndView();
		admin.setPassword(TestDB.encryptedPwd(admin.getPassword()));
		if(TestDB.checkAdmin(admin)==false)
		{
			TestDB.addAdmin(admin);
		}
		else
		{
			m.addObject("errorAdmin","This admin already exists!");
		}
		model.addAttribute("property", new Property());	
		model.addAttribute("admin", new Admin());
		m.addObject("prop", TestDB.getProperty());
		m.setViewName("rootAdmin");
		m.addObject("adminEmail", session.getAttribute("adminEmail"));
		return m;
	}

}
