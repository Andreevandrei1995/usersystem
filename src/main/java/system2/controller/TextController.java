package system2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import system2.dao.Users;
import system2.model.Text;
import system2.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class TextController {
    @Autowired
    Users users;

    @RequestMapping("/index2")
    @ResponseBody
    List<Text> index_2(@RequestBody Text text, HttpServletRequest request)throws Exception{
        String login = (String)request.getSession().getAttribute("login");
        users.addText(login,text);
        return users.getListText(login);
    }

    @RequestMapping("/index3")
    @ResponseBody
    Text index_3(@RequestBody Text text, HttpServletRequest request)throws Exception{
        return text;
    }

    @RequestMapping("/index4")
    @ResponseBody
    List<Text> index_4(@RequestBody Text text, HttpServletRequest request)throws Exception{
        String login = (String)request.getSession().getAttribute("login");
        return users.getListText(login);
    }

    @RequestMapping("/index5")
    @ResponseBody
    String index_5(HttpServletRequest request)throws Exception{
        return "101";
    }

}
