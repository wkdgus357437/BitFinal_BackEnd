package com.adminBoard.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adminBoard.bean.AdminBoardDTO;
import com.adminBoard.service.AdminBoardService;

@CrossOrigin
@RestController 
@RequestMapping(value = "adminBoard")
public class AdminBoardController {
	
	@Autowired
	private AdminBoardService adminBoardService;
	
	@PostMapping(path = "adminBoardWrite") // 관리자 글쓰기
	public void adminBoardWrite(@ModelAttribute AdminBoardDTO adminBoardDTO ) {
		adminBoardService.adminBoardWrite(adminBoardDTO);
	}

	@GetMapping(path = "adminBoardList") //관리자 글 리스트
	public List<AdminBoardDTO> adminBoardList(){
		return adminBoardService.adminBoardList();
	}
//	
//	@GetMapping(path = "getAdminBoard") //관리자 글 쓰기 유효성 필요한건지?
//	public Optional<AdminBoardDTO> getAdminBoard(@RequestParam int adminboard_seq){
//		return adminBoardService.getAdminBoard(adminboard_seq);
//	}
//	
	
	@PutMapping(path = "adminBoardUpdate") //관리자 글 수정
	public void adminBoardUpdate(@ModelAttribute AdminBoardDTO adminBoardDTO) {
		adminBoardService.adminBoardUpdate(adminBoardDTO);
	}
	
	@DeleteMapping(path = "adminBoardDelete")
	public void adminBoardDelete(@RequestParam int dminBoardSeq) {
		adminBoardService.adminBoardDelete(dminBoardSeq);
	}
}

