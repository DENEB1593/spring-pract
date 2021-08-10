package com.study.controller;

import com.study.config.RootConfig;
import com.study.config.ServletConfig;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;

// Controller 테스트용(ServletContext를 사용하기 위함)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@Log4j
public class BoardControllerTests {
    @Setter(onMethod_ = {@Autowired})
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    //mockMvc는 가짜 mvc를 지칭함
    //mockMvcBuilder로 웹 서비스 호출이 가능함
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    @Ignore
    public void testList() throws Exception {
        log.info(
                mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
                        .andReturn()
                        .getModelAndView()
                        .getModelMap());
    }

    @Test
    @Ignore
    public void testRegister() throws Exception {
        /*
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
                .param("title", "테스트 새글 제목")
                .param("content", "테스트 새글 내용")
                .param("writer", "데네브_테스트")
        ).andReturn().getModelAndView().getViewName();
         */
        ModelAndView model = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
                .param("title", "테스트 새글 제목11")
                .param("content", "테스트 새글 내용222")
                .param("writer", "데네브_테스트22")
        ).andReturn().getModelAndView();

        //redirect:/board/list
        log.info("Return ViewName" + model.getViewName());
        log.info("Return Values: " + model.getModel());
    }


    @Ignore
    @Test
    public void testGet() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders
                        .get("/board/get")
                        .param("bno", "21"))
                .andReturn()
                .getModelAndView().getModelMap());
    }

    @Ignore
    @Test
    public void testModify() throws Exception{
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
                        .param("bno", "1")
                        .param("title", "수정 테스트용 타이틀")
                        .param("content", "수정 테스트용 내용")
                        .param("writer", "deneb12234"))
                .andReturn().getModelAndView().getViewName();
        log.info(resultPage);
    }

    @Ignore
    @Test
    public void testRemove() throws Exception{
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
                        .param("bno", "1")
                )
                .andReturn().getModelAndView().getViewName();
        log.info(resultPage);
    }

    @Test
    public void testListPaging() throws Exception {
        log.info(mockMvc.perform(
                MockMvcRequestBuilders.get("/board/list")
                        .param("pageNum", "2")
                        .param("amount", "5")
        ).andReturn().getModelAndView().getModelMap());
    }
}
