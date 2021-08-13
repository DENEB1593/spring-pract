package com.study.mapper;

import com.study.config.RootConfig;
import com.study.domain.Criteria;
import com.study.domain.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootConfig.class})
@Log4j
public class ReplayMapperTests {
    @Setter(onMethod_ = {@Autowired})
    private ReplyMapper mapper;

    private Long[] bnoArr = {6L, 7L, 8L, 9L, 10L};

    @Test
    public void testMapper( ) {
        log.info(mapper);
    }

    @Test
    @Ignore
    public void testCreate() {
            ReplyVO vo = new ReplyVO();

            vo.setBno(6L);
            vo.setReply("댓글 테스트 ");
            vo.setReplyer("replyer");
            mapper.insert(vo);
    }

    @Test
    @Ignore
    public void testList() {
        Criteria cri = new Criteria();
        List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
        replies.forEach(reply->log.info(reply));
    }

    @Test
    public void testList2() {
        Criteria cri = new Criteria(2, 10);
        List<ReplyVO> replies = mapper.getListWithPaging(cri, 6L );

        replies.forEach(reply -> log.info(reply));
    }
}
