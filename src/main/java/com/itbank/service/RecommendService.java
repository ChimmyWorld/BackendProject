package com.itbank.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.RecommendDAO;
import com.itbank.model.vo.AccountVO;
import com.itbank.model.vo.RecommendVO;

@Service
public class RecommendService {
	
	@Autowired private RecommendDAO dao;

	public int getGood(RecommendVO input) {
		return dao.countGood(input);
	}

	public int userCheck(RecommendVO input, HttpSession session) {
		if(input.getRecommender() == null) {
			input.setRecommender("");
		}
		
		Integer good = dao.userRec(input);
		
		good = (good != null) ? good : 0;
		
		if(good == 1) {
			input.setIsCheck(1);
		}
		else if (good == 2) {
			input.setIsCheck(2);
		}
		else {
			input.setIsCheck(0);
		}
		
		System.out.println(input.getBoard_idx());
		System.out.println(input.getRecommender());
		System.out.println(input.getIsCheck());
		
		session.setAttribute("recommend", input);
		
		return input.getIsCheck();
	}

	public int userCheck(int idx, HttpSession session) {
		AccountVO user = (AccountVO) session.getAttribute("user");
		RecommendVO input = new RecommendVO();
		
		if(user == null) {
			input.setRecommender("");
		}
		else {
			input.setRecommender(user.getNick());
		}
		
		input.setBoard_idx(idx);
		
		Integer good = dao.userRec(input);
		
		good = (good != null) ? good : 0;
		
		if(good == 1) {
			input.setIsCheck(1);
		}
		else if (good == 2) {
			input.setIsCheck(2);
		}
		else {
			input.setIsCheck(0);
		}
		
		System.out.println(input.getBoard_idx());
		System.out.println(input.getRecommender());
		System.out.println(input.getIsCheck());
		
		session.setAttribute("recommend", input);
		
		return input.getIsCheck();
	}

	public int processGood(RecommendVO input, HttpSession session) {
		Integer good = dao.userRec(input);
		good = good == null ? 0 : good;
		input.setGood(good);
		
		System.out.println("프로세스 부분 출력");
		System.out.println(input.getIsCheck());
		System.out.println(input.getGood());
		
		// isCheck가 0이고 good이 0이면 insert(input)
        if (input.getIsCheck() == 0 && input.getGood() == 0) {
        	input.setGood(1);
            int row = dao.insertRecommend(input);
            
            if(row == 1) {
            	userCheck(input, session);
            }
            
            return row;
        }
        // isCheck가 1이고 good이 1이면 delete(input)
        else if (input.getIsCheck() == 1 && input.getGood() == 1) {
            int row = dao.deleteRecommend(input);
            
            if(row == 1) {
            	userCheck(input, session);
            }
            
            return row + 1;
        }
        else {
        	userCheck(input, session);
        	int row = 0;
        	return row;
        }
	}

	public int processBad(RecommendVO input, HttpSession session) {
		Integer good = dao.userRec(input);
		good = good == null ? 0 : good;
		input.setGood(good);
		
		System.out.println("프로세스 부분 출력");
		System.out.println(input.getIsCheck());
		System.out.println(input.getGood());
		
		// isCheck가 0이고 good이 0이면 insert(input)
        if (input.getIsCheck() == 0 && input.getGood() == 0) {
        	input.setGood(2);
            int row = dao.insertRecommend(input);
            
            if(row == 1) {
            	userCheck(input, session);
            }
            
            return row;
        }
        // isCheck가 1이고 good이 1이면 delete(input)
        else if (input.getIsCheck() == 2 && input.getGood() == 2) {
            int row = dao.deleteRecommend(input);
            
            if(row == 1) {
            	userCheck(input, session);
            }
            
            return row + 1;
        }
        else {
        	userCheck(input, session);
        	int row = 0;
        	return row;
        }
	}

}
