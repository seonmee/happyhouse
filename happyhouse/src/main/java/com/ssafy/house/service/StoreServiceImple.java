package com.ssafy.house.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.house.dao.StoreDao;
import com.ssafy.house.dto.StoreDto;
import com.ssafy.house.util.PageNavigation;
@Service
public class StoreServiceImple implements StoreService {
	
	@Autowired
	private StoreDao storeDao;

	/* 상권 정보 검색 
	 * input : StoreDto
	 * output : List<StoreDto>
	 * */
	@Override
	public List<StoreDto> searchByCode(StoreDto storeDto) throws Exception {
		return storeDao.searchByCode(storeDto);
	}
	
	/* 주변 상권 검색 (카테고리별)
	 * input : MAP
	 * output : List<StoreDto>
	 * */
	@Override
	public List<StoreDto> findAroundStore(Map map) throws Exception {
		return storeDao.findAroundStore(map);
	}
	
//	@Override
//	public PageNavigation makePageNavigation(StoreDto storeDto) throws Exception {
//		 int naviSize = 10;
//	     int currentPage = storeDto.getCurPage();
//	     int sizePerPage = storeDto.getSpp();
//	     PageNavigation pageNavigation = new PageNavigation();
//	     pageNavigation.setCurrentPage(currentPage);
//	     pageNavigation.setNaviSize(naviSize);
//	     int totalCount = storeDao.getTotalCount(storeDto);
//	     pageNavigation.setTotalCount(totalCount);
//	     int totalPageCount = (totalCount - 1) / sizePerPage + 1;
//	     pageNavigation.setTotalPageCount(totalPageCount);
//	     boolean startRange = currentPage <= naviSize;
//	     pageNavigation.setStartRange(startRange);
//	     boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
//	     pageNavigation.setEndRange(endRange);
//	     pageNavigation.makeNavigator();
//	     return pageNavigation;
//	}

}
