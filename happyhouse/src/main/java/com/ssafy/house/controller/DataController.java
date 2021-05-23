package com.ssafy.house.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@RestController
public class DataController {

	private static final Logger logger = LoggerFactory.getLogger(DataController.class);

	@GetMapping("/getData")
	public void showApiData() {
		StringBuffer result = new StringBuffer();
		try {
			String urlstr = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?" +
	        "LAWD_CD=11110" +
			"&DEAL_YMD=201502" +
	        "&serviceKey=5QaPpa8kkge2Dl4XoYO54r8EPZ8Kg%2BPGsJtjuF36TSTQZf3eryNQP6f4sElP%2BcPANncLbM6FkGAubmuXrhGkDA%3D%3D";
			URL url = new URL(urlstr);
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(urlstr);
			// root tag
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("item");
			
			for(int i = 0; i<nList.getLength();i++) {
				Node nNode = nList.item(i);
				if(nNode.getNodeType() == Node.ELEMENT_NODE){
									
					Element eElement = (Element) nNode;
					
					logger.info(getTagValue("거래금액",eElement));
					logger.info(getTagValue("건축년도",eElement));
					logger.info(getTagValue("도로명",eElement));
					logger.info(getTagValue("법정동시군구코드",eElement)); 
					logger.info(getTagValue("법정동읍면동코드",eElement)); //군구 + 덩먕 = 번덩동 
					logger.info(getTagValue("아파트",eElement));
					logger.info(getTagValue("월",eElement));
					logger.info(getTagValue("일",eElement));
					logger.info(getTagValue("년",eElement));
					logger.info(getTagValue("전용면적",eElement));
					
				}
					
			}
			
//			
//			
//			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
//			urlConnection.setRequestMethod("GET");
//		    
//			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
//		    
//			String returnLine;
//		    result.append("<xmp>");
//		    
//		    while((returnLine = br.readLine())!=null) { 	
//		    	result.append(returnLine + "\n");
//		    }
//			urlConnection.disconnect();
		}catch(Exception e){
			e.printStackTrace();
		}
		//return result + "</xmp>";
	}
	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}

}
