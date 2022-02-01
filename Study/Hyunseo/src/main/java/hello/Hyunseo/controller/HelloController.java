package hello.Hyunseo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!!!");
        return "hello";
    }

    @GetMapping("hello-mvc") // localhost:8080/hello-mvc
    /* 파라메터 정보볼때 -> command + p */
    public String helloMvc(@RequestParam("name") String name, Model model){
        //localhost:8080/hello-mvc?name=spring
        // name= spring으로 넘김
        model.addAttribute("name", name);
        return "hello-template";// hello-template.html 로 이동
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();  // 자동완성: command+shift+Enter
        hello.setName(name);
        return hello;
        //json 방식
    }
    static class Hello{
        private String name;
        //생성자 만들때 : control + Enter
        //프로퍼티 접근 방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
