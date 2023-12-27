package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.components.Paging;
import com.itbank.model.BoardDAO;
import com.itbank.model.vo.AccountVO;
import com.itbank.model.vo.BoardVO;
import com.itbank.model.vo.Board_Count_ListVO;
import com.itbank.model.vo.Board_ListVO;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;
	@Value("file:C:/img_folder/board")
	private Resource dir;

	// 게시판 CRUD
	public List<Board_Count_ListVO> getPreview(int idx) {
		return dao.selectPreview(idx);
	}

	public Map<String, Object> getList(Integer idx, Integer type, String order, String keyword, String search) {
		idx = idx == null ? 1 : idx;

		// 페이징 코드
		Paging p = new Paging(idx, dao.totalBoard(type), type, order, keyword, search);
		System.out.println(order);
		List<Board_Count_ListVO> list = dao.selectList(p);
		
		Map<String, Object> result = new HashMap<>();

		result.put("p", p);
		result.put("list", list);

		return result;
	}

	public Board_ListVO getBoard(int idx) {
		return dao.selectOne(idx);
	}

	public int writeBoard(BoardVO input) throws IOException {
		MultipartFile file = input.getUpload();

		// 파일이 업로드되었을 때만 아래 로직을 수행
		if (file != null && !file.isEmpty()) {

			// 1. DB에 저장할 파일 이름 저장
			input.setArticle_img(file.getOriginalFilename());

			// 2. insert 후 작성된 글 번호 (idx) 가져오기
			int row = dao.insert(input);
			//TODO int row 변수는 활용 예정 없는 경우 삭제
			int new_idx = dao.selectIdx();
			String idx = String.valueOf(new_idx);

			// 3. 해당 번호의 폴더 생성
			File newDir = new File(dir.getFile(), idx);
			newDir.mkdir();

			// 4. 3번의 폴더에 이미지를 업로드
			File dst = new File(newDir, file.getOriginalFilename());
			file.transferTo(dst);

			return new_idx;
		} else {
			// 파일이 업로드되지 않았을 때의 로직 (폴더를 생성하지 않음)
			int row = dao.insert(input);
			//TODO int row 변수는 활용 예정 없는 경우 삭제
			int new_idx = dao.selectIdx();
			return new_idx;
		}
	}

	public int updateBoard(BoardVO input) throws IOException {
		MultipartFile file = input.getUpload();
		// 파일이 업로드되었을 때만 아래 로직을 수행
		if (file != null && !file.isEmpty()) {

			// 1. DB에 저장할 파일 이름 저장
			input.setArticle_img(file.getOriginalFilename());

			// 2. insert 후 작성된 글 번호 (idx) 가져오기
			int row = dao.update(input);
			String idx = String.valueOf(input.getIdx());

			// 3. 해당 번호의 폴더 생성
			File newDir = new File(dir.getFile(), idx);
			newDir.mkdir();
			
			// 4. 폴더에 파일이 존재하는 경우 삭제
			deleteExistingFile(newDir);

			// 5. 3번의 폴더에 이미지를 업로드
			File dst = new File(newDir, file.getOriginalFilename());
			file.transferTo(dst);

			return row;
		} else {
			// 파일이 업로드되지 않았을 때의 로직 (폴더를 생성하지 않음)
			int row = dao.update(input);
			return row;
		}
	}
	
	public void deleteExistingFile(File directory) {
	    File[] files = directory.listFiles();
	    if (files != null) {
	        for (File file : files) {
	            if (file.isFile()) {
	                file.delete(); // 파일 삭제
	            }
	        }
	    }
	}

	public int deleteBoard(int idx) {
		return dao.delete(idx);
	}

	public int updateViewCount(int idx) {
		return dao.countUp(idx);
	}

	// 마이페이지 기능
	public Map<String, Object> getMyBoardList(Integer idx, Integer type, String order, 
			String keyword, String search, AccountVO user) {
		idx = idx == null ? 1 : idx;

		// 페이징 코드
		Paging p = new Paging(idx, dao.totalMyBoard(user), type, order, keyword, search);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("user", user);
		param.put("p", p);
		
		List<BoardVO> list = dao.selectMyBoardList(param);
		
		Map<String, Object> result = new HashMap<>();

		result.put("p", p);
		result.put("list", list);
		
		return result;
	}

}
