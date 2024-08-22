package com.learningspring.BuildingApp.FirstWebApp.HelloController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
@Controller // Telling Spring that this is an Controller
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody //Help to return the string as it is!! as spring will look for a view
    public String sayHello(){
        return "Hello! What are you learning today - updated";
    }

    @RequestMapping("say-hello-Html")
    @ResponseBody
    public String sayHelloHtml(){
        StringBuffer sb = new StringBuffer();// to append we need a string buffer
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My First HTML Page - Changed</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first html page with body - Changed");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();

        // Things will be really complex with this method, that's why we use views!

        // Earlier and most famous for Views is JSP

        // "Say-hello-jsp" -  JSp page
    }

    @RequestMapping("say-hello-jsp")
    //@ResponseBody //Help to return the string as it is!! as spring will look for a view
    public String sayHelloJsp(){
        //src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
        return "sayHello";
    }

}
*/
@Controller
public class SayHelloController {

    //"say-hello" => "Hello! What are you learning today?"

    //say-hello
    // http://localhost:8080/say-hello
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello! What are you learning today?";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My First HTML Page - Changed</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first html page with body - Changed");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    //
    // "say-hello-jsp" => sayHello.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/welcome.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/todos.jsp
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }
}