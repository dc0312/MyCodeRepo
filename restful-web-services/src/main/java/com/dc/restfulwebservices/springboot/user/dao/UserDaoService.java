package com.dc.restfulwebservices.springboot.user.dao;

import com.dc.restfulwebservices.springboot.user.bean.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount =3;



    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(++usersCount);
        }

        users.add(user);
        return user;
    }

    public User findById(int id){
        for (User user: users) {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public boolean deleteById(int id){
        Iterator<User> itr = users.iterator();
        while(itr.hasNext()){
            User user = itr.next();
            if(user.getId()==id){
                itr.remove();
                return true;
            }
        }
        return false;
    }
}
