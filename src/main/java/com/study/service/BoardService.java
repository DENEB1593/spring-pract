package com.study.service;

import com.study.domain.BoardVO;
import com.study.domain.Criteria;

import java.util.List;
/*
    비즈니스 계층
    실제 업무에 이용되는 서비스에 대한 로직을 작성 한다.
 */
public interface BoardService {
    public void register(BoardVO board);

    public BoardVO get(Long bno);

    public boolean modify(BoardVO board);

    public boolean remove(Long bno);

//    public List<BoardVO> getList();

    public List<BoardVO> getList(Criteria criteria);

    public int getTotal(Criteria criteria);
}
