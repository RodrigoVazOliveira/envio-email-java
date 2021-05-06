package br.dev.rvz.demo.services;

import br.dev.rvz.demo.domains.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnvioService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarEmail(Email email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("raindev.r@gmail.com");
        simpleMailMessage.setTo(email.getPara());
        simpleMailMessage.setSubject(email.getAssunto());
        simpleMailMessage.setText(email.getTexto());
        javaMailSender.send(simpleMailMessage);
    }
}
