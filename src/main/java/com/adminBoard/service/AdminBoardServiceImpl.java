package com.adminBoard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.adminBoard.bean.AdminBoardDTO;
import com.adminBoard.dao.AdminBoardDAO;

@Service
public class AdminBoardServiceImpl implements AdminBoardService {

	@Autowired
	private AdminBoardDAO adminBoardDAO;
	
	@Override
	public void adminBoardWrite(AdminBoardDTO adminBoardDTO) { // 관리자 게시판 글쓰기
		adminBoardDAO.save(adminBoardDTO);
		
	}

	@Override
	public List<AdminBoardDTO> adminBoardList() { // 관리자 게시판 글 리스트
		
		return adminBoardDAO.findAll();
	}
	
//	@Override
//	public Optional<AdminBoardDTO> getAdminBoard(int adminboard_seq) { //뭐로잡는지?
//		
////		return adminBoardDAO.findById(adminboard_seq);
//		return adminBoardDAO.findByGetAdminBoard(adminboard_seq);
//	}

	
	@Override
	public void adminBoardUpdate(AdminBoardDTO adminBoardDTO) { //관리자 게시판 글 수정
		adminBoardDAO.save(adminBoardDTO);
	}

	@Override
	public void adminBoardDelete(int dminBoardSeq) { //관리자 게시판 글 삭제
//		adminBoardDAO.deleteById(adminboard_seq);
		adminBoardDAO.deleteByAdminBoardSeq(dminBoardSeq);
	}


}
