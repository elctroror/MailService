package com.MailService.MailService.controller;

import com.MailService.MailService.entity.Mail;
import com.MailService.MailService.service.ServiceMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ControllerMail {

    @Autowired
    private ServiceMail serviceMail;

    @GetMapping("/list")
    public List<Mail> list(){

        return serviceMail.findAll();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity idList(@PathVariable Long id){
        return serviceMail.finById(id);

    }
}
