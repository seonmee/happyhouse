package com.ssafy.house.dao;

import java.util.List;

import com.ssafy.house.dto.ApartDto;
import com.ssafy.house.dto.CityDto;
import com.ssafy.house.dto.SearchCondition2;

public interface ApartDao {
	public List<CityDto> listGu(String cityCode);
	public List<CityDto> listDong(String guCode);
	public List<ApartDto> apartInfo(ApartDto apartDto);
	public List<ApartDto> apartDetail(SearchCondition2 searchCondition);
	public List<ApartDto> apartList(String searchWord);
	public List<CityDto> listSido();
}
