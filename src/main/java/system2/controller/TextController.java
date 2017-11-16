package system2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import system2.dao.Users;
import system2.model.Text;
import system2.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class TextController {
    @Autowired
    Users users;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    ModelAndView index()throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    //при запросе к серверу о добавлении введенного сообщения в базу данных
    @RequestMapping(value="/index2",method = RequestMethod.POST)
    @ResponseBody
    List<Text> index_2(@RequestBody Text text, HttpServletRequest request)throws Exception{
        Enumeration enumeration = request.getSession().getAttributeNames();
        String attribute = "";

        while(enumeration.hasMoreElements()){
            attribute = (String )enumeration.nextElement();
            if(attribute.equals("login")){
                String login = (String)request.getSession().getAttribute("login");
                Pattern pattern = Pattern.compile("[^\\\\:;{}\"']+");
                Matcher matcher = pattern.matcher(text.getText());
                if(matcher.matches()){
                    users.addText(login,text);
                    return users.getListText(login);}
                else {
                    List<Text> response = new ArrayList();
                    response.addAll(users.getListText(login));
                    response.add(new Text("incorrect input"));
                    return response;
                }

            }
        }

        List<Text> no_login = new ArrayList();
        no_login.add(new Text("No login\\"));
        return no_login;
    }
    //для отправки назад сообщения через сервер
    @RequestMapping(value="/index3", method = RequestMethod.POST)
    @ResponseBody
    Text index_3(@RequestBody Text text, HttpServletRequest request)throws Exception{
        return text;
    }


    //для инициализации данных на сайте
    @RequestMapping(value="/index4",method = RequestMethod.POST)
    @ResponseBody
    List<Text> index_4(@RequestBody Text text, HttpServletRequest request)throws Exception{
        Enumeration enumeration = request.getSession().getAttributeNames();
        String attribute = "";

        while(enumeration.hasMoreElements()){
            attribute = (String )enumeration.nextElement();
            if(attribute.equals("login")){
                String login = (String)request.getSession().getAttribute("login");
                return users.getListText(login);
            }
        }

        List<Text> list = new ArrayList();
        Text text_response = new Text();
        text_response.setText("No login\\");
        list.add(text_response);
        return list;
    }



}
