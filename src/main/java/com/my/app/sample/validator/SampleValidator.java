package com.my.app.sample.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.my.app.sample.dto.RequestBodySampleDto;

@Component
public class SampleValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RequestBodySampleDto.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user.user", "field.required");
	}

}
