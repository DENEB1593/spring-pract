package com.study.service;

import com.study.config.RootConfig;
import com.study.domain.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class BoardServiceTests {
    @Setter(onMethod_ = @Autowired)
    private BoardService service;

    @Ignore
    @Test
    public void testExist() {
        log.info(service);
        assertNotNull(service);
    }

    @Ignore
    @Test
    public void testRegister() {
        BoardVO board = new BoardVO();
        board.setTitle("게시글 제목 등록 테스트");
        board.setContent("게시글 내용 등록 테스트");
        board.setWriter("데네브");
        log.info("Register Test: " + board.toString());
        service.register(board);
    }

    @Ignore
    @Test
    public void testGetList() {
//        service.getList().stream().forEach(board -> {
//            log.info(board.toString());
//        });
    }

    @Test
    public void testUpdate() {
        long bno = 21L;
        BoardVO updateBoard = BoardVO.builder()
                .title("업데이트 된 제목 (Service)")
                .content("업데이트 된 않는 내용 (Service)")
                .writer("작성자")
                .bno(21L)
                .build();
        boolean result = service.modify(updateBoard);
        assertTrue(result);

    }

    @Ignore
    @Test
    public void testDelete() {

    }
}
