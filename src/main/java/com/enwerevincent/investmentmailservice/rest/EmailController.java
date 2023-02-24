package com.enwerevincent.investmentmailservice.rest;
import com.enwerevincent.investmentmailservice.service.NotificationService;
import com.enwerevincent.investmentmailservice.vo.AppResponse;
import com.enwerevincent.investmentmailservice.vo.MailRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("mail")
public class EmailController extends BaseController {

    NotificationService service;


    public EmailController(NotificationService service) {
        this.service = service;
    }


    @PostMapping
    public AppResponse<Boolean> sendEmail( @RequestBody MailRequest mail) {
        return getResponse(service.sendEmail(mail));
    }
    
}
