package com.test.demo.controller;

import com.sendgrid.Response;
import com.test.demo.dbo.EmailRequest;
import com.test.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/sendmail")
    public ResponseEntity<String> sendmail(@RequestBody EmailRequest emailrequest){
        Response response=emailService.sendemail(emailrequest);
        if(response.getStatusCode()==200||response.getStatusCode()==202)
            return new ResponseEntity<>("send successfully", HttpStatus.OK);
        return new ResponseEntity<>("failed to sent", HttpStatus.NOT_FOUND);
    }
}
