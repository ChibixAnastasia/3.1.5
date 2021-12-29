package web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.ReestConfig;
import web.controller.ConsumeWebService;
import web.model.User;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ReestConfig.class);
        ConsumeWebService restTemplate = applicationContext.getBean("consumeWebService", ConsumeWebService.class);

        User userSave = new User(3L, "James", "Brown", (byte) 34);

        User userEdit = new User(3L, "Thomas", "Shelby", (byte) 34);

        User deleted = new User();
        deleted.setId(3L);

        String JSESSIONID = restTemplate.getAllUsers().getHeaders().getValuesAsList("Set-Cookie").get(0);
        String first = restTemplate.createUser(userSave, JSESSIONID).getBody();
        String second = restTemplate.edit(userEdit, JSESSIONID).getBody();
        String third = restTemplate.delitUser(deleted, JSESSIONID).getBody();

        System.out.println("Я дебил");
        System.out.println(first+second+third);



    }
}
