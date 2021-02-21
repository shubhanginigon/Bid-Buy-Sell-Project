package com.SAD.Main_Project.facade;

import com.SAD.Main_Project.model.User;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailFacade {

    /*
    @Autowired
    private static ConfirmationTokenService ctokenService;

    public EmailFacade(ConfirmationTokenService ctokenService) {
        this.ctokenService = ctokenService;
    }
    */

    public static enum EmailType {
        REGISTER_CONFIRM, REGISTER_SUCCESS, NOTIFICATION
    }

    public static SimpleMailMessage generateEmailFor(EmailType emailType, User user) {
        String subject = null;
        String from = "admin@bbs.com";
        String to = user.getEmail();
        String text = null;
        SimpleMailMessage msg = null;

        switch (emailType) {
            case REGISTER_CONFIRM:
                subject = "AIT-Bid Buy Sell: Confirm Email";
                from = "admin@bbs.com";
                to = user.getEmail();

                //String token = user.getToken().getToken();
                String token = "TBD";
                //String token = ctokenService.findByUserId(user.getUid()).getToken();
                text = "Welcome to our platform. Please click on link below to complete your registration.\n" +
                        "http://localhost/confirm-account?token=" + token;

            case REGISTER_SUCCESS:
                break;

            case NOTIFICATION:
                break;
        }
        msg = createMailMessage(subject, from, to, text);
        return msg;
    }

    private static SimpleMailMessage createMailMessage(String subject,
                                                       String from,
                                                       String to,
                                                       String text) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setSubject(subject);
        msg.setFrom(from);
        msg.setTo(to);
        msg.setText(text);

        return msg;
    }
}
