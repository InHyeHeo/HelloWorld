package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service //BoardServiceImpl클래스에서 가장 중요. 비즈니스 영역을 담당하는 객체임을 표시.
@AllArgsConstructor //파라미터를 이용하는 생성자를 만듦.
public class BoardServiceImpl implements BoardService{
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper; //BoardServiceImpl클래스가 정상적으로 동작하기 위해서 BoardMapper객체 필요.
								// 1) @Autowired로 직접 설정
								// 2) @Setter이용(lombok)
						
	
	@Override
	public void register(BoardVO board) { //BoardVO타입의 객체를 BoardMapper를 통해 처리
		log.info("register......."+board);
		mapper.insertSelectKey(board); //나중에 생성된 게시문읠 번호 확인
		
	}

	
	
	@Override
	public BoardVO get(Long bno) { //조회작업 구현
		log.info("get..........."+bno);
		return mapper.read(bno);
	}

	
	
	
	@Override
	public boolean modify(BoardVO board) {
		log.info("modify....."+board);
		return mapper.update(board) == 1; //수정 구현
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove....."+bno);
		return mapper.delete(bno) == 1; //삭제 구현
	}

	
	
	@Override
	public List<BoardVO> getList() { //목록작업 구현
		log.info("get list..........");
		return mapper.getList();
	}

	

	
}
