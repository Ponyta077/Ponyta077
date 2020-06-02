package cool.ddn.service;

import cool.ddn.dao.UserRespository;
import cool.ddn.po.User;
import cool.ddn.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRespository userRespository;

    @Override
    public User checkUser(String username, String password) {

        User user = userRespository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}