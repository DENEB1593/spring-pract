package com.study.mapper;

import com.study.config.RootConfig;
import com.study.domain.BoardVO;
import com.study.domain.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@Log4j
public class BoardMapperTests {
    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Ignore
    @Test
    public void testGetList() {
        mapper.getList().forEach(board -> {
            log.info(board);
        });
    }

    @Ignore
    @Test
    public void testInsert() {
        BoardVO vo = BoardVO.builder()
                .title("제목입니다.")
                .content("내용입니다.")
                .writer("이강운")
                .build();
        log.info(vo.toString() + " ... insert");
        mapper.insert(vo);
    }

    @Ignore
    @Test
    public void testInsertSelectKey() {
        BoardVO vo = BoardVO.builder()
                .title("새로 작성하는 제목 selectKey11")
                .content("새로 작성하는 내용 selectKey22")
                .writer("newWriter")
                .build();
        log.info(vo.toString() + " ... insert");
        mapper.insertSelectKey(vo);
    }

    @Ignore
    @Test
    public void testRead() {
        long bno = 21L;
        BoardVO vo = mapper.read(bno);
        log.info(vo.toString());
    }

    @Ignore
    @Test
    public void testDelete() {
        long bno = 24L;
        int result = mapper.delete(bno);    // result: 1 (Success), 0 (fail)

//        assertEquals(result, 1);
    }

    @Ignore
    @Test
    public void testUpdate() {
        BoardVO updateBoard = BoardVO.builder()
                .title("업데이트 된 제목")
                .content("업데이트 된 않는 내용")
                .writer("작성자")
                .bno(21L)
                .build();
        log.info("result: " + mapper.update(updateBoard));
    }

    @Test
    public void testPaging() {
        Criteria criteria = new Criteria();
        // 5개 씩 3페이지
        criteria.setPageNum(3);
        criteria.setAmount(5);

        List<BoardVO> list = mapper.getListWithPaging(criteria);

        list.forEach(board -> log.info(board));
    }
}
