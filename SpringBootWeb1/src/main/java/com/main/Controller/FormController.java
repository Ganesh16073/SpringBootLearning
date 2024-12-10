package com.main.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.main.entity.Alieen;

@Controller
public class FormController {

	@RequestMapping("/Form")
	public String openForm()
	{
		System.out.println("FormController.openForm()");
		return "form";
	}
	
//	@RequestMapping("add")
//	public String add(HttpServletRequest req,HttpSession session) // using servlet
//	{
//		int num1=Integer.parseInt(req.getParameter("num1"));
//		int num2=Integer.parseInt(req.getParameter("num2"));
//		int result=num1+num2;
//		
//		session.setAttribute("result",result);
//		return "result.jsp";
//	}
	

//	@RequestMapping("add")
//	public String addByAnnotation(int num,int num2,HttpSession session) // need to use same id and variable name if not its give(type=Internal Server Error, status=500).
//	{
//		int result=num+num2;
//		session.setAttribute("result",result);
//		return "result.jsp";
//	}
	
//	@RequestMapping("add")
//	public String addByAnnotation(@RequestParam("num1")int num,int num2,HttpSession session) // @RequstParam("// here we pass the id to get value") // by using this formate we can declare java varable any
//	{
//		int result=num+num2;
//		session.setAttribute("result",result); 
//		return "result.jsp";  // if we do not want work wit Session then we have Model with additional advantages
//	}
	
//	@RequestMapping("add")
//	public String addByAnnotation(@RequestParam("num1")int num,int num2,Model model) // @RequstParam("// here we pass the id to get value") // by using this formate we can declare java varable any
//	{
//		int result=num+num2;
//		model.addAttribute("result",result);
//		return "result.jsp"; 
//		//iam returning jsp file but imagin if there is any another file type such as jsx then we need to cahange evey time to solve this we ust suffix and for path prefix 
//	}
	
//	@RequestMapping("add")
//	public String addByAnnotation(@RequestParam("num1")int num,int num2,Model model) // @RequstParam("// here we pass the id to get value") // by using this formate we can declare java varable any
//	{
//		int result=num+num2;
//		model.addAttribute("result",result); 
//		return "result";  // IF I DONT WANT TO USE MODEL VIEW CONTROLLER THEN WE HAVE ModelAndView
//	}
	
	@RequestMapping("add")
	public ModelAndView addByAnnotation(@RequestParam("num1")int num,int num2,ModelAndView model) // @RequstParam("// here we pass the id to get value") // by using this formate we can declare java varable any
	{
		int result=num+num2;
		model.addObject("result",result);
		model.setViewName("result");
		return model; 
	}
	
	@RequestMapping("/FormAlieen") // request for form of alieen add
	public String openAlieenForm()
	{
		System.out.println("FormController.openForm()");
		return "AddAlieen";
	}
	
//	@RequestMapping("/AddAlien")
//	public ModelAndView addAlieenByAnnotation(@RequestParam("aid")int eid,@RequestParam("aname")String ename,ModelAndView model) 
//	{
//		System.out.println("Received - Aid: " + eid + ", Aname: " + ename);
//		Alieen al=new Alieen();
//		al.setEid(eid);
//		al.setEname(ename);
//		
//		model.addObject("alieen",al);  // "alieen is the variable in jsp page which is called session.alieen" and al is object data pased in it
//		model.setViewName("ResultAlieen"); // display form mane ResultAlieen.jsp
//		
//		return model; 
//	}
	
//	@RequestMapping("/AddAlien")
//	public String addAlieenByAnnotation(@ModelAttribute Alieen al) {
//	    System.out.println(al.getAid() + "  " + al.getAname()); // (form id), (class_variable) and Getter setter shoule be same other wise it pass the null avalue
//	    return "ResultAlieen"; // calling result page 
//	}
	
	@RequestMapping("/AddAlien")
	public String addAlieenByAnnotation(Alieen al) {
	    System.out.println(al.getAid() + "  " + al.getAname()); // (form id), (class_variable) and Getter setter shoule be same other wise it pass the null avalue
	    return "ResultAlieen"; // calling result page 
	}
	
	
}
