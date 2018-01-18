package com.wordpress.sreeharsha.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordpress.sreeharsha.model.ApartmentMember;
import com.wordpress.sreeharsha.repository.ApartmentMemberRepository;


@RestController
@RequestMapping("/apt")
public class ApartmentMemberController {

	private final Logger logger = LoggerFactory
			.getLogger(ApartmentMemberController.class);

	@Autowired
	ApartmentMemberRepository aptRepository;

	/**
	 * POST /create --> Create a new apartment member details and save it in the
	 * database.
	 */
	@CrossOrigin(origins = {})
	@RequestMapping(method = RequestMethod.POST, value = "/createmember")
	public Map<String, Object> createMember(
			@RequestBody ApartmentMember apartmentMember) {

		logger.info("In createMember method:");
		aptRepository.save(apartmentMember);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Member created");
		dataMap.put("status", "success");
		return dataMap;
	}

	

	/**
	 * GET /read --> Read a member by blockNumber from the database.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/displaymember/{blockNumber}")
	public ApartmentMember displayMember(@PathVariable String blockNumber) {
		logger.info("In displaymember method:");
		ApartmentMember apartmentMember = aptRepository.findOne(blockNumber);
		return apartmentMember;
	}

	
}
