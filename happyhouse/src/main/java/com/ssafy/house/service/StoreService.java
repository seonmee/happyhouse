package com.ssafy.house.service;

import java.util.List;
import java.util.Map;

import com.ssafy.house.dto.StoreDto;

public interface StoreService {;
	/* 상권 정보 검색 
	 * input : StoreDto
	 * output : List<StoreDto>
	 * */
	public List<StoreDto> searchByCode(StoreDto storeDto)throws Exception;
	/* 주변 상권 검색 (카테고리별)
	 * input : MAP
	 * output : List<StoreDto>
	 * */
	public List<StoreDto> findAroundStore(Map paramMap) throws Exception;
	

//	public PageNavigation makePageNavigation(StoreDto storeDto)throws Exception;

}
