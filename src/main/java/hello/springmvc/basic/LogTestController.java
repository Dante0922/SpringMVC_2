package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    // Slf4j를 사용하면 아래 코드를 생략할 수 있다.
    // private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";
        System.out.println("name is = " + name);
        // log level: trace < debug < info < warn < error
        log.trace(" info log = {}", name);
        log.debug(" info log = {}", name);
        log.info(" info log = {}", name);
        log.warn(" info log = {}", name);
        log.error(" info log = {}", name);
        return "ok";
    }
}
