package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests { 
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	
	
	@Test
	public void testExit() { //BoardService객체가 생성되고, BoardMapper가 주입되었는지 확인하는 메서드.
		log.info(service); //org.zerock.service.BoardServiceImpl@74960bfa
		assertNotNull(service); //service객체가 null이 아님을 확인
	}
	
	
	
	@Test
	public void testRegister() { //등록작업 테스트
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호: "+board.getBno());
	}
	
	
	
	@Test
	public void testGetList() { //목록작업 테스트
		service.getList().forEach(board -> log.info(board));
	}
	
	
	
	@Test
	public void testGet() { //조회작업 테스트
		log.info(service.get(1L));
	}
	
	
	
	@Test
	public void testDelete() {
		log.info(service.remove(5L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = service.get(1L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("제목 수정할게요.");
		log.info("MODIFY RESULT"+service.modify(board));
	}
	
	
	
}
