package com.ssafy.house.dao;

import java.util.List;

import com.ssafy.house.dto.BoardDto;

public interface IBoardDao {
	public List<BoardDto> findAllBoard() throws Exception;
	public BoardDto detailBoard(int bid) throws Exception;
	public void addBoard(BoardDto board) throws Exception;
	public boolean updateBoard(BoardDto board) throws Exception;
	public boolean deleteBoard(int bid) throws Exception;
	public List<BoardDto> searchBoard(BoardDto board) throws Exception;
}
