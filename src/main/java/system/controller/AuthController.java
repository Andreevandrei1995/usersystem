package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import system.dao.UserDao;


import system.model.Text;


//import javax.servlet.http.*;


@Controller()
public class AuthController {
    @Autowired
    UserDao userDao;


    @RequestMapping(value = "/index2", method = RequestMethod.POST)
    @ResponseBody public Text index2(@RequestBody Text text) throws Exception{
        return text;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public
    ModelAndView index() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /*@RequestMapping(value = "/auth")
    public @ResponseBody
    ModelAndView cookie() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("auth", new Polzovatel());
        modelAndView.setViewName("auth");
        return modelAndView;

    }

    @RequestMapping(value = "/auth/result", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView getPolzovatel(@ModelAttribute("auth") Polzovatel polzovatel, HttpServletResponse response) {
        for (Polzovatel polzovatel1 : userDao.getPolzovatels()
                ) {
            if (polzovatel.getLogin().equals(polzovatel1.getLogin()))
                if (polzovatel.getPassword().equals(polzovatel1.getPassword())) {//если верный логин и пароль
                    Cookie lgn = new Cookie("lgn", polzovatel.getLogin());
                    lgn.setPath("/");
                    response.addCookie(lgn);
                    Cookie psw = new Cookie("psw", polzovatel.getPassword());
                    psw.setPath("/");
                    response.addCookie(psw);
                    ModelAndView modelAndView = new ModelAndView();
                    modelAndView.setViewName("auth_true");
                    return modelAndView;
                }
        }
        //если неверный логин и пароль, то переходим на страничку с ошибкой
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth_false");
        return modelAndView;
    }


    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView validate(HttpServletRequest request) {
        String textArea = "";
        Cookie[] cookies = request.getCookies();
        for (int y = 0; y < cookies.length; y++) {//получение текстовых полей для пользователей
            if (cookies[y].getName().equals("lgn") == true) {
                textArea = userDao.getAllTextPolz(cookies[y].getValue());
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Strochka1", new Strochka());
        modelAndView.addObject("textArea12", textArea);
        modelAndView.setViewName("1");
        return modelAndView;
    }


    @RequestMapping(value = "/validate/addText", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView validate(@ModelAttribute("Strochka1") Strochka strochka, HttpServletRequest request) throws Exception{
        String[] chars = {"{", "}", ":", ";", "&", "?", "/", "\\"};
        String textArea = "";
        Cookie[] cookies = request.getCookies();

        if (strochka.getStrochka() == null) {
        } else {
            l:
            for (int i = 0; i < chars.length; i++) {
                if (strochka.getStrochka().contains(chars[i])) {//строчка содержит служебные символы, значит, ее не надо выводить
                    break l;
                }
                if (i == chars.length - 1) {//если не один из символов не совпал, значит, мы выводим новую строчку
                    for (int y = 0; y < cookies.length; y++) {
                        if (cookies[y].getName().equals("lgn") == true) {
                            userDao.addText(cookies[y].getValue(), strochka.getStrochka());//добавление строчки по логину, который находится в куки
                            this.marshallExample();
                            break l;
                        }
                    }
                }
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("1_add");
        return modelAndView;
    }

    public void marshallExample() throws Exception{
            JAXBContext context = JAXBContext.newInstance(UserDao.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(this.userDao, new File("D:\\txt.xml"));
    }

    public UserDao unmarshall() throws Exception{
        JAXBContext context = JAXBContext.newInstance(UserDao.class);
        Unmarshaller un = context.createUnmarshaller();
        return (UserDao) un.unmarshal(new File("D:\\txt.xml"));
    }*/




}


