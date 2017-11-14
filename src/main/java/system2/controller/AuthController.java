package system2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import system2.dao.Users;
import system2.model.Auth;
import system2.model.User;
import javax.servlet.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.FormSubmitEvent;

@Controller
public class AuthController {
    @Autowired
    Users users;

    @RequestMapping("/auth")
    ModelAndView auth() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth");
        modelAndView.addObject("auth", new Auth());
        return modelAndView;
    }

    //переход на стартовую страницу, если логин и пароль корректны
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    ModelAndView auth_decision(@ModelAttribute("auth") Auth auth, HttpServletRequest request) {
        for (User user:users.getUsers()
             ) {
            if ((auth.getLogin().equals(user.getLogin())) & (auth.getPassword().equals(user.getPassword()))) {
                request.getSession().setAttribute("login", auth.getLogin());
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("index");
                return modelAndView;
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        return modelAndView;
    }
}

