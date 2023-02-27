package com.MailService.MailService.activeMq;

import com.MailService.MailService.dao.MailDao;
import com.MailService.MailService.entity.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Component
@Service
public class Receive {
    @Autowired
    private MailDao mailDao;

    @JmsListener(destination = "UserQueue")
    public void receiveMessage(String message){
        try {

            JSONObject userJson = new JSONObject(message);
            System.out.println(userJson.toString());

             Mail mail= new Mail(userJson.get("email").toString(), userJson.get("name").toString(),  userJson.get("secondName").toString(),  userJson.get("dni").toString(),  "User Created Correct");
             mailDao.save(mail);
        }catch (Exception f){
            System.out.println(f);
            throw f;
        }


    }
}
