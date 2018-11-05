package com.learn.concurrency.threadLocal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenjian
 * 2018/11/4 20:44
 */
@Slf4j
@Controller
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    @RequestMapping(value = "/test")
    @ResponseBody
    public Long test() {
        return RequestHolder.getId();
    }
}
