package com.shop.service;

import java.util.List;

import com.shop.model.BookVO;
import com.shop.model.CateFilterDTO;
import com.shop.model.CateVO;
import com.shop.model.Criteria;

public interface BookService {
	
	// 상품 검색
	public List<BookVO> getGoodsList(Criteria cri);
		
	// 상품 총 개수
	public int goodsGetTotal(Criteria cri);
	
	// 국내 카테고리 리스트
	public List<CateVO> getCateCode1();
	
	// 국외 카테고리 리스트
	public List<CateVO> getCateCode2();
	
	// 검색결과 카테고리 필터 정보
	public List<CateFilterDTO> getCateInfoList(Criteria cri);

}
