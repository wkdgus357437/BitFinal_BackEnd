package com.adminBoard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	
	@Override
	public Optional<AdminBoardDTO> getAdminBoard(int adminBoardSeq) { //관리자 게시판 글 수정 전 찾기
		return adminBoardDAO.findByGetAdminBoard(adminBoardSeq);
	}
	
	@Override
	public void adminBoardUpdate(AdminBoardDTO adminBoardDTO) { //관리자 게시판 글 수정
		adminBoardDAO.save(adminBoardDTO);
	}

	@Override
	public void adminBoardDelete(int adminBoardSeq) { //관리자 게시판 글 삭제
//		adminBoardDAO.deleteById(adminboard_seq);
		adminBoardDAO.deleteByAdminBoardSeq(adminBoardSeq);
	}


}
