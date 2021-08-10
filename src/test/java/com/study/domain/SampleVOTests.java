package com.study.domain;

import com.study.config.RootConfig;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//XML 기반
//@ContextConfiguration("file:src/web/WEB-INF/root-context.xml")
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class SampleVOTests {

    @Test
    public void makeSampleVOTest() {
        log.info("make sampleVO...");
        SampleVO vo = new SampleVO();
        vo.setKey("k1"); vo.setValue("v1");
        log.info("vo: " + vo.toString());
        assertNotNull(vo);
    }

}
