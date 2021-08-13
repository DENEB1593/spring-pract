package com.study.controller;

import com.study.domain.BoardVO;
import com.study.domain.Criteria;
import com.study.domain.PageDTO;
import com.study.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j
@RequestMapping(value = {"/board/*"})
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

//    @GetMapping("/list")
//    public void list(Model model) {
//        log.info("list");
//        model.addAttribute("list", service.getList());
//    }

    @GetMapping("/list")
    public void list(Criteria cri, Model model) {
        log.info("list");
        model.addAttribute("list", service.getList(cri));
//        model.addAttribute("pageMaker", new PageDTO(cri, 123));

        int total = service.getTotal(cri);

        log.info("total : " + total);

        model.addAttribute("pageMaker", new PageDTO(cri, total));
    }

    @GetMapping("/register")
    public void register() {

    }

    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes rttr) {
        log.info("register: " + board);
        service.register(board);
        rttr.addFlashAttribute("result", board.getBno());
        return "redirect:/board/list";
    }

    @GetMapping({"/get", "/modify"})
    public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
        log.info("/get or /modify");
        model.addAttribute("board", service.get(bno));
    }

    @PostMapping("/modify")
    public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
        log.info("modify :  " + board);

        if(service.modify(board)) {
            rttr.addFlashAttribute("result", "success");
        }

//        rttr.addAttribute("pageNum", cri.getPageNum());
//        rttr.addAttribute("amount", cri.getAmount());
//        rttr.addAttribute("type", cri.getType());
//        rttr.addAttribute("keyword", cri.getKeyword());

        return "redirect:/board/list" + cri.getListLink();
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
        log.info("remove :  " + bno);

        if(service.remove(bno)) {
            rttr.addFlashAttribute("result", "success");
        }

//        rttr.addAttribute("pageNum", cri.getPageNum());
//        rttr.addAttribute("amount", cri.getAmount());
//        rttr.addAttribute("type", cri.getType());
//        rttr.addAttribute("keyword", cri.getKeyword());

        return "redirect:/board/list" + cri.getListLink();
    }

}
