package com.malhi.springsjdbc;

import com.malhi.springsjdbc.domain.User;
import com.malhi.springsjdbc.domain.UserDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringsjdbcApplication {

    public static void main(String[] args) {

        ApplicationContext run = SpringApplication.run(SpringsjdbcApplication.class, args);
        UserDAO bean = run.getBean(UserDAO.class);
       // bean.readAndWrite();
        //bean.addUser(new User(15,"Raminder","Sharma"));
       //User users = bean.findById(15);
      // users.setLastName("Panch");
       //bean.updateUser(users);
       bean.findAllByLastName("Malhi").forEach(System.out::println);

    }

}
