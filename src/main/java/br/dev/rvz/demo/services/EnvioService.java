package br.dev.rvz.demo.services;

import br.dev.rvz.demo.domains.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class EnvioService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    public void enviarEmail(Email email) throws MessagingException {
        MimeMessage mensagem = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensagem,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        helper.setTo(email.getPara());
        helper.setSubject(email.getAssunto());
        helper.setFrom("raindev.r@gmail.com");

        Context context = new Context();
        context.setVariable("assunto", email.getAssunto());
        context.setVariable("texto", email.getTexto());

        try {
            String htmlTemplate = springTemplateEngine.process("mail", context);
            helper.setText(htmlTemplate, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        javaMailSender.send(mensagem);
    }
}
