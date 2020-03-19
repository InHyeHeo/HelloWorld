package org.zerock.mapper;

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
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	//create(insert)처리 테스트
	@Test
	public void testInsert() {
		BoardVO board =  new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		mapper.insert(board);
		log.info(board); //lombok이 만들어주는 toString()를 이용해서 bno 멤버변수의 값을 알아보기 위함
		//BoardVO(bno=null, title=새로 작성하는 글, content=새로 작성하는 내용, writer=newbie, regdate=null, updateDate=null)
	}
	@Test
	public void testInsertSelectKey() {
		BoardVO board =  new BoardVO();
		board.setTitle("새로 작성하는 글 select key");
		board.setContent("새로 작성하는 내용 select key");
		board.setWriter("newbie");
		mapper.insertSelectKey(board);
		log.info(board); 
		//BoardVO(bno=1284, title=새로 작성하는 글 select key, content=새로 작성하는 내용 select key, writer=newbie, regdate=null, updateDate=null)
	}
	
	
	//read(select)처리 테스트
	@Test
	public void testRead() {
		BoardVO board = mapper.read(5L);
		log.info(board);
		//BoardVO(bno=5, title=테스트 제목, content=테스트 내용, writer=user00, regdate=Sat Mar 14 21:53:08 KST 2020, updateDate=Sat Mar 14 21:53:08 KST 2020)
	}
	
	
	
	//delete처리 테스트
	@Test
	public void testDelete() {
		log.info("DELETE COUNT: "+mapper.delete(4L)); //bno=4 정보 삭제
	}
	
	
	
	//update처리 테스트
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(5L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: "+count);
		//UPDATE COUNT: 1
	}
	
}
