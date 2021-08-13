package com.study.service;

import com.study.domain.BoardVO;
import com.study.domain.Criteria;
import com.study.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        log.info("register.... " + board);
        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {
        log.info("get BoardVO..");
        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
        log.info("modify board: " + board.toString());
        return mapper.update(board) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        log.info("remove bno: " + bno);
        return mapper.delete(bno) == 1;
    }

    @Override
    public List<BoardVO> getList(Criteria criteria) {
        log.info("getList()..");
        return mapper.getListWithPaging(criteria);
    }

    @Override
    public int getTotal(Criteria criteria) {
        log.info("get Total Count");
        return mapper.getTotalCount(criteria);
    }


}
