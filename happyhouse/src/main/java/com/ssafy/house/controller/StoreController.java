package com.ssafy.house.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.house.dto.StoreDto;
import com.ssafy.house.service.StoreService;
import com.ssafy.house.util.PageNavigation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value="house", description="Happy house")
public class StoreController {
	
	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
	@Autowired
	private StoreService storeService;
	
	@ApiOperation(value = "Code(시/군구/동)에 속하는 상점 정보를 반환한다.(페이지당 10개)", response = List.class)
	@RequestMapping(value = {"/storeList/{currentPage}","/storeList/{currentPage}/{sidoCode}","/storeList/{currentPage}/{sidoCode}/{gugunCode}","/storeList/{currentPage}/{sidoCode}/{gugunCode}/{dongCode}"},method=RequestMethod.GET)
	public ResponseEntity<List<StoreDto>> searchByCode(@PathVariable int currentPage,@PathVariable(required = false) String sidoCode,@PathVariable(required = false) String gugunCode,@PathVariable(required = false) String dongCode) throws Exception {
		logger.info("1-------------searchByCode-----------------------------"+new Date());
		StoreDto store = new StoreDto(sidoCode,gugunCode,dongCode,currentPage,10);
		List<StoreDto> stores = storeService.searchByCode(store);
//		PageNavigation pageNavigation = storeService.makePageNavigation(store);
		if (stores.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<StoreDto>>(stores, HttpStatus.OK);
	}
	
	@ApiOperation(value = "동네(dongCode)의 카테고리별(category)상점 정보를 반환한다.", response = List.class)
	@RequestMapping(value = {"/aroundStore/{dongCode}/{category}"},method=RequestMethod.GET)
	public ResponseEntity<List<StoreDto>> findAroundStore(@PathVariable String category,@PathVariable String dongCode) throws Exception {
		logger.info("1-------------findAroundStore-----------------------------"+new Date());
		Map paramMap = new HashMap();
		paramMap.put("dongCode", dongCode);
		paramMap.put("smallCategoryCode", category);
		List<StoreDto> stores = storeService.findAroundStore(paramMap);
		if (stores.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<StoreDto>>(stores, HttpStatus.OK);
	}
	

}
