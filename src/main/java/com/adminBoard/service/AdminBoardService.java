package com.adminBoard.service;

import java.util.List;
import java.util.Optional;

import com.adminBoard.bean.AdminBoardDTO;

public interface AdminBoardService {

	public void adminBoardWrite(AdminBoardDTO adminBoardDTO); //관리자 게시판 글쓰기

	public List<AdminBoardDTO> adminBoardList(); //관리자 게시판 목록

//	public Optional<AdminBoardDTO> getAdminBoard(int adminboard_seq); //관리자 게시판 유효성 이건 필요한지?
	
	public void adminBoardUpdate(AdminBoardDTO adminBoardDTO); //관리자 게시판 글 수정

	public void adminBoardDelete(int adminBoardSeq);// 관리자 게시판 글 삭제



}
