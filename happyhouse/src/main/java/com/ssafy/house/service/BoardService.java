package com.ssafy.house.service;

import java.util.List;

import com.ssafy.house.dto.BoardDto;

public interface BoardService {
	public List<BoardDto> findAllBoard() throws Exception;
	public BoardDto detailBoard(int bid) throws Exception;
	public int addBoard(BoardDto board) throws Exception;
	public boolean updateBoard(BoardDto board) throws Exception;
	public boolean deleteBoard(int bid) throws Exception;
	public List<BoardDto> searchBoard(BoardDto board) throws Exception;
}
