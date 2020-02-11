package com.cts.bao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.cts.vo.SignUpVO;

@Component
public class SignUpValidation implements Validator {
	public boolean supports(Class clazz) {
		return SignUpVO.class.isAssignableFrom(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors) sign-up data empty validation
	 */
	public void validate(Object target, Errors errors) {
		SignUpVO obj1 = (SignUpVO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "signupname", "required.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "signuppassword", "required.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "signupid", "required.id");
		String regex = "^[a-zA-Z]{3,16}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(obj1.getSignupname());
		if (m.matches() == false) {
			errors.rejectValue("signupname", "required.signupnamevalidate");
		}
	}

	/**
	 * @param target
	 * @param errors
	 *            sign-up data user name and password validation
	 */
	public void validateIDAndPasswordSignUp(Object target, Errors errors) {
		SignUpVO obj1 = (SignUpVO) target;
		try {
			int id = Integer.parseInt(obj1.getSignupid());
			if ((id > 100000) && (id < 800000)) {
				String regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(obj1.getSignuppassword());
				if (m.matches() == false) {
					errors.rejectValue("signuppassword", "required.passwordvalidate");
				}
			} else {
				errors.rejectValue("signupid", "required.namevalidate");
			}
		} catch (Exception e) {
			errors.rejectValue("signupid", "required.namevalidate");
		}
	}
}