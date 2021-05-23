package com.ssafy.house.dto;
/* 거래내역 */
public class DealDto {
	/* 공통 */
	private String name;            // 주택
	private String buildYear;       // 건축 년도 
	private String dealYear;        // 거래 년
	private String dealMonth;       // 거래 월 
	private String dealDay;         // 거래 일 
	private String floor;           // 층 
	private String jibun;           // 지번 
	private String dong;            // 법정동 명 
	private String gunguCode;       // 군구 코드 
	private String area;            // 면적 
	private String lat;             //          
	private String lng;             // 
	/* 전월세 */
	private String deposit;         // 보증금 
	private String rentMoney;       // 월세
	/* 매매 */
	private String dealAmount;      // 매매
	
	public DealDto() {
		super();
	}


	public DealDto(String name, String buildYear, String dealYear, String dealMonth, String dealDay, String floor,
			String jibun, String dong, String gunguCode, String area, String lat, String lng, String deposit,
			String rentMoney, String dealAmount) {
		super();
		this.name = name;
		this.buildYear = buildYear;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.floor = floor;
		this.jibun = jibun;
		this.dong = dong;
		this.gunguCode = gunguCode;
		this.area = area;
		this.lat = lat;
		this.lng = lng;
		this.deposit = deposit;
		this.rentMoney = rentMoney;
		this.dealAmount = dealAmount;
	}



	public String getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDealYear() {
		return dealYear;
	}
	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}
	public String getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}
	public String getDealDay() {
		return dealDay;
	}
	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getJibun() {
		return jibun;
	}
	public void setJibun(String jibun) {
		this.jibun = jibun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getGunguCode() {
		return gunguCode;
	}
	public void setGunguCode(String gunguCode) {
		this.gunguCode = gunguCode;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getRentMoney() {
		return rentMoney;
	}
	public void setRentMoney(String rentMoney) {
		this.rentMoney = rentMoney;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	
	

}
