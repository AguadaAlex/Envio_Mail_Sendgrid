package com.test.demo.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.test.demo.dbo.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {


    @Autowired
    SendGrid sendGrid;

    public Response sendemail(EmailRequest emailrequest){
        //SE CREA REMITENTE CON EL ASUNTO Y DESTINO DINAMICO
        Mail mail= new Mail(new Email("alex.aguada@snoopconsulting.com"),emailrequest.getSubject(),new Email(emailrequest.getTo()),new Content("text/plain", emailrequest.getBody()));
       //SIRVE PARA QUE DENTRO DE CADA MAIL APAREZCA A QUIEN SE DEBE CONTESTAR EL MISMO
        mail.setReplyTo(new Email("alex.david.aguada.jura@gmail.com"));
        Request request = new Request();
        Response response= null;
        try{
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response=this.sendGrid.api(request);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return response;
    }
}
