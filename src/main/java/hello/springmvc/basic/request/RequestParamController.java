package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        log.info("username={}, age={}", username, age);

        resp.getWriter().write("ok");
    }

    @ResponseBody // 이걸 붙이면 return 값이 response body에 들어간다.
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {
        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }
    @ResponseBody // 이걸 붙이면 return 값이 response body에 들어간다.
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }
    @ResponseBody // 이걸 붙이면 return 값이 response body에 들어간다.
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("username={}, age={}", username, age);
        return "ok";
    }
    @ResponseBody // 이걸 붙이면 return 값이 response body에 들어간다.
    @RequestMapping("/request-param-required")
    // required = true 를 사용해 값이 안 들어오는 것을 방지하지만
    // ""가 들어오면 ""가 들어간다.
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody // 이걸 붙이면 return 값이 response body에 들어간다.
    @RequestMapping("/request-param-default")
    // defaultValue 를 사용하면 ""이 들어와도 default 값이 들어간다.
    public String requestParamDefault(
            @RequestParam(defaultValue = "guest") String username,
            @RequestParam(defaultValue = "-1") int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }
    @ResponseBody // 이걸 붙이면 return 값이 response body에 들어간다.
    @RequestMapping("/request-param-map")
    // defaultValue 를 사용하면 ""이 들어와도 default 값이 들어간다.
    public String requestParamMap(
            @RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

}

