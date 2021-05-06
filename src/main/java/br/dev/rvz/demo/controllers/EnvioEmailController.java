package br.dev.rvz.demo.controllers;

import br.dev.rvz.demo.domains.Email;
import br.dev.rvz.demo.services.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("envio/")
public class EnvioEmailController {

    @Autowired
    private EnvioService envioService;

    @PostMapping
    public void enviarEmail(@RequestBody Email email) {
        envioService.enviarEmail(email);
    }
}
