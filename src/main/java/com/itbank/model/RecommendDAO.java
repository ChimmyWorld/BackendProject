package com.itbank.model;

import com.itbank.model.vo.RecommendVO;

public interface RecommendDAO {

	int countGood(RecommendVO input);

	Integer userRec(RecommendVO input);

	int insertRecommend(RecommendVO input);

	int deleteRecommend(RecommendVO input);

}
