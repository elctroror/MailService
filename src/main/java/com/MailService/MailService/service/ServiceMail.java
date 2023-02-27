package com.MailService.MailService.service;

import com.MailService.MailService.dao.MailDao;
import com.MailService.MailService.entity.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceMail {

@Autowired
private MailDao mailDao;

    public List<Mail> findAll() {

        return (List<Mail>)mailDao.findAll();

    }

    public ResponseEntity finById(Long id) {

        try {
            Optional<Mail> mail = mailDao.findById(id);
            if(mail.isPresent()==true){
                return new ResponseEntity( mail, HttpStatus.ACCEPTED);
            }
            return new ResponseEntity ("there are not Mails that match this id" , HttpStatus.BAD_REQUEST);

        }catch (RuntimeException e){

            System.out.println("Exception: "+e);
            return new ResponseEntity ("something go bad" , HttpStatus.BAD_REQUEST);
        }

    }
}
