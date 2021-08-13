package com.study.controller;

import com.study.domain.SampleRestVO;
import lombok.extern.log4j.Log4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/rest")
@Log4j
public class SampleRestController {
    @GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
    public String getText() {
        log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
        return "안녕하세요";
    }

    @GetMapping(value = "/getSample",
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public SampleRestVO getSamples() {
        return new SampleRestVO(112, "안녕", "Hello");
    }

    @GetMapping(value = "/getList")
    public List<SampleRestVO> getList() {
        return IntStream.rangeClosed(1, 10)
                .mapToObj(i -> new SampleRestVO(i, i + " First", i + " Last"))
                .collect(Collectors.toList());
    }

}
