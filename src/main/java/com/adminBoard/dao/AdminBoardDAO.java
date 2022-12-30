package com.adminBoard.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adminBoard.bean.AdminBoardDTO;

@Repository
public interface AdminBoardDAO  extends JpaRepository<AdminBoardDTO,Long>{

//	Optional<AdminBoardDTO> findByGetAdminBoard(int adminboard_seq);
	
	@Transactional
	void deleteByAdminBoardSeq(int adminboardSeq);

	
	
}
