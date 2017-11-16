package system.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.UserDao;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List getAllUsers(){
        return userDao.getPolzovatels();
    }
}
