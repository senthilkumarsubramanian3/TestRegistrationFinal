package com.cts.controller;

import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.bao.DisplayList;
import com.cts.bao.InputDataValidation;
import com.cts.bao.LoginValiddation;
import com.cts.bao.SignInDataValidation;
import com.cts.bao.SignInNameFetch;
import com.cts.bao.SignUpValidation;
import com.cts.dao.DataInsert;
import com.cts.dao.DataInsertSignUp;
import com.cts.vo.BookDetailsVO;
import com.cts.vo.LoginVO;
import com.cts.vo.SignUpVO;

@Controller
public class ExamRegistrationController {

	/**
	 * @param model
	 * @return htm for book page
	 */
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String showBookPage(Model model) {
		model.addAttribute("bookmodel", new BookDetailsVO());
		return "book";
	}

	/**
	 * @param model
	 * @return htm for login page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(Model model) {
		model.addAttribute("login", new LoginVO());
		return "login";
	}

	/**
	 * @param model
	 * @return htm for signup
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String showSignUpPage(Model model) {
		model.addAttribute("signup", new SignUpVO());
		return "signup";
	}

	/**
	 * @param model
	 * @param e
	 * @param br
	 * @return controller for signup page
	 */
	@RequestMapping(value = "/signuppage", method = RequestMethod.POST)
	public String signUpValidation(Model model, @ModelAttribute("signup") SignUpVO e, BindingResult br) {
		SignUpValidation ob = new SignUpValidation();
		DataInsertSignUp ob1 = new DataInsertSignUp();
		boolean flag = false;
		ob.validate(e, br);
		if (br.hasErrors()) {
			return "signup";
		} else {
			ob.validateIDAndPasswordSignUp(e, br);
			if (br.hasErrors()) {
				return "signup";
			} else {
				flag = ob1.insertIntoDBSignup(e);
				if (flag == true) {
					return "signupsuccess";
				} else {
					return "errorsignup";
				}
			}
		}
	}

	/**
	 * @param model
	 * @param request
	 * @return redirect for session timeout
	 */
	@RequestMapping(value = "/login1", method = RequestMethod.GET)
	public String sessionTimeoutController(Model model, HttpServletRequest request) {
		model.addAttribute("sent", "you have been logged out due to inactivity for login time");
		model.addAttribute("login", new LoginVO());
		return "login";
	}

	/**
	 * @param model
	 * @param e
	 * @param br
	 * @return Controller for login page
	 */
	@RequestMapping(value = "/loginSubmit", method = RequestMethod.POST)
	public String loginValidate(Model model, @ModelAttribute("login") LoginVO e, BindingResult br) {
		LoginValiddation ob = new LoginValiddation();
		boolean flag = false;
		ob.validate(e, br);
		if (br.hasErrors()) {
			return "login";
		} else {
			ob.validateIDAndPassword(e, br);
			if (br.hasErrors()) {
				return "login";
			} else {
				SignInDataValidation ob3 = new SignInDataValidation();
				flag = ob3.validate(e);
				if (flag == true) {
					SignInNameFetch od = new SignInNameFetch();
					String namefetch = od.fetch(e);
					model.addAttribute("a", namefetch);
					return "home";
				} else {
					model.addAttribute("passwordwrong",
							"Given credentials does not match please check and try again, For signup visit home");
					return "login";
				}
			}
		}
	}

	/**
	 * @param e
	 * @param br
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException
	 *             Controller for book page
	 */
	@RequestMapping(value = "/booked", method = RequestMethod.POST)
	public String bookController(@ModelAttribute("bookmodel") BookDetailsVO e, BindingResult br, Model model,
			HttpServletRequest request, HttpServletResponse response) throws ParseException {
		boolean flag = false;
		DataInsert ob = new DataInsert();
		InputDataValidation ob2 = new InputDataValidation();
		ob2.validate(e, br);

		if (br.hasErrors()) {
			return "book";
		} else {
			ob2.validatedate(e, br);
			if (br.hasErrors()) {
				return "book";
			} else {
				flag = ob.insertIntoDB(e);
				if (flag == true) {
					return "success";
				} else {
					return "error";
				}
			}
		}
	}

	/**
	 * @return Session Timeout Controller
	 */
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String sessionTimeOut() {
		return "home";
	}

	/**
	 * @param model
	 * @return controller for display
	 */
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String displayPage(Model model) {
		ArrayList p = new ArrayList();
		DisplayList ob = new DisplayList();
		p = ob.display();
		System.out.println(p);
		if (p.get(0).equals("No test registered")) {
			model.addAttribute("error", "No test registered");
			return "display";
		} else {
			model.addAttribute("Id", p.get(0));
			model.addAttribute("Date", p.get(1));
			model.addAttribute("Place", p.get(2));
			model.addAttribute("Slot", p.get(3));
			model.addAttribute("Level", p.get(4));
			return "display";
		}
	}
}
