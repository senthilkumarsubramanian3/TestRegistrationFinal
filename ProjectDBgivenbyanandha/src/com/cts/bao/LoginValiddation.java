package com.cts.bao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.cts.vo.LoginVO;

@Component
public class LoginValiddation implements Validator {
	public boolean supports(Class clazz) {
		return LoginVO.class.isAssignableFrom(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)\ Sign-in page empty data
	 * validation
	 */
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password");
	}

	/**
	 * @param target
	 * @param errors
	 *            sign-in date and password validation
	 */
	public void validateIDAndPassword(Object target, Errors errors) {
		LoginVO obj1 = (LoginVO) target;
		try {
			int id = Integer.parseInt(obj1.getName());
			if ((id > 100000) && (id < 800000)) {
				String regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(obj1.getPassword());
				if (m.matches() == false) {
					errors.rejectValue("password", "required.passwordvalidate");
				}
			} else {
				errors.rejectValue("name", "required.namevalidate");
			}
		} catch (Exception e) {
			errors.rejectValue("name", "required.namevalidate");
		}
	}
}