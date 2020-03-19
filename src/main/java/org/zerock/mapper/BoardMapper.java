package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {

	//@Select("select * from tbl_board where bno<6")
	public List<BoardVO> getList();
	
	
	
	//create(insert)처리
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board); //MyBatis의 @SelectKey사용
												//@SelectKey는 PK값을 미리 SQL을 통해 처리 및 보관하는 방식
	

	//read(select)처리
	public BoardVO read(Long bno); //MyBatis는 mapper인터페이스의 리턴타입에 맞게 <select>의 결과 처리
	
	
	
	//delete처리
	public int delete(Long bno); //수정된 데이터의 개수 파악을 위해 int타입으로 설계
	
	
	
	//update처리
	public int update(BoardVO board); //수정된 데이터의 개수 파악을 위해 int타입으로 설계
}
