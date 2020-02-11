package com.cts.bao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.cts.vo.BookDetailsVO;

@Component
public class InputDataValidation implements Validator {
	public boolean supports(Class clazz) {
		return BookDetailsVO.class.isAssignableFrom(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors) Empty data validation
	 */
	public void validate(Object target, Errors errors) {
		BookDetailsVO obj1 = (BookDetailsVO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "required.date");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "place", "required.place");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "slot", "required.slot");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "level", "required.level");

	}

	/**
	 * @param target
	 * @param errors
	 * @throws ParseException
	 *             Date validation
	 */
	@SuppressWarnings("deprecation")
	public void validatedate(Object target, Errors errors) throws ParseException {
		BookDetailsVO obj1 = (BookDetailsVO) target;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		java.util.Date date1 = sdf.parse(obj1.getDate());
		java.util.Date date2 = sdf.parse(sdf.format(date));
		sdf.format(date1);
		sdf.format(date2);
		if ((date1.compareTo(date2) < 0) || (date1.getYear() > 121)) {
			errors.rejectValue("date", "required.date1");
		}
	}
}
