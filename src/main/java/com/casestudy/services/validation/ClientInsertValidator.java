package com.casestudy.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.casestudy.model.enums.TipeBusiness;
import com.casestudy.repositories.ClientRepository;
import com.casestudy.resouces.dto.NewClientDTO;
import com.casestudy.resouces.exeption.FieldMessage;
import com.casestudy.services.validation.utils.US;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, NewClientDTO> {
	
	@Autowired
	ClientRepository cr;
	
	@Override
	public void initialize(ClientInsert cli) {
	}

	@Override
	public boolean isValid(NewClientDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(objDto.getTipe().equals(TipeBusiness.PRIVATEINDIVIDUAL.getCod()) && !US.isValidSSN(objDto.getSsnOrItin())) {
			list.add(new FieldMessage("ssnOrItin", "SSN Invalid"));
		}
		
		if(objDto.getTipe().equals(TipeBusiness.LEGALENTITY.getCod()) && !US.isValidTIN(objDto.getSsnOrItin())) {
			list.add(new FieldMessage("ssnOrItin", "Itin Invalid"));
		}
		
		if(cr.findByEmail(objDto.getEmail()) != null) {
			list.add(new FieldMessage("Email", "Email already exist!"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
