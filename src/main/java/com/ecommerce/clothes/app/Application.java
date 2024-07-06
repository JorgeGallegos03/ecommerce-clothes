package com.ecommerce.clothes.app;

import com.ecommerce.clothes.app.services.contracts.IUploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class Application implements CommandLineRunner {
    private final Logger log = LoggerFactory.getLogger(Application.class.getName());
    private final BCryptPasswordEncoder passwordEncoder;
    private final IUploadFileService fileService;

    public Application(final BCryptPasswordEncoder passwordEncoder, final IUploadFileService fileService) {
        this.passwordEncoder = passwordEncoder;
        this.fileService = fileService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //this.fileService.deleteAll();
        //this.fileService.init();
        String data = "12345";
        for (int i = 0; i < 2; i++) {
            String bcryptPassword = passwordEncoder.encode(data);
            log.info("bcryptPassword {}", bcryptPassword);
        }
    }
}