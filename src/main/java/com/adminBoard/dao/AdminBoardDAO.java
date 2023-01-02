package com.adminBoard.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adminBoard.bean.AdminBoardDTO;

@Repository
public interface AdminBoardDAO  extends JpaRepository<AdminBoardDTO,Long>{
	
	@Transactional
	void deleteByAdminBoardSeq(int adminboardSeq);

	@Query("select adminBoardDTO from AdminBoardDTO adminBoardDTO where adminBoardDTO.adminBoardSeq=:adminBoardSeq")
	public Optional<AdminBoardDTO> findByGetAdminBoard(@Param("adminBoardSeq") int adminBoardSeq);
	//관리자 게시판 글 수정 전 찾기
	
}
