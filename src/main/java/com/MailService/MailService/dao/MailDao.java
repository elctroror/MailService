package com.MailService.MailService.dao;

import com.MailService.MailService.entity.Mail;
import org.springframework.data.repository.CrudRepository;

public interface MailDao extends CrudRepository<Mail, Long> {
}
