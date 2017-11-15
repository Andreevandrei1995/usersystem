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
        return modelAndView;
    }

    //переход на стартовую страницу, если логин и пароль корректны
    @RequestMapping(value = "/auth_decision", method = RequestMethod.POST)
    @ResponseBody boolean auth_decision(@RequestBody Auth auth, HttpServletRequest request) {
        for (User user:users.getUsers()
             ) {
            if ((auth.getLogin().equals(user.getLogin())) & (auth.getPassword().equals(user.getPassword()))) {
                request.getSession().setAttribute("login", auth.getLogin());
                return true;
            }
        }
        return false;
    }


    @RequestMapping(value = "/change", method = RequestMethod.POST)
    @ResponseBody void change(HttpServletRequest request) {
        request.getSession().removeAttribute("login");
    }

}

