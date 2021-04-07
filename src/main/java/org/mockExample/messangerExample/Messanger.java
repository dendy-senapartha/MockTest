package org.mockExample.messangerExample;

/**
 * Project: MockTest
 * Package: org.mockExample.messangerExample
 * <p>
 * User: dendy
 * Date: 07/04/2021
 * Time: 8:51
 * <p>
 * Description : Messanger mock test
 */
public class Messanger {
    private TemplateEngine templateEngine;
    private MailServer mailServer;
    public Messanger(MailServer mailServer,
                     TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
        this.mailServer = mailServer;
    }

    public void sendMessage(Client client,
                            Template template){
        String msgContent = templateEngine
                .prepareMessage(template, client);
        mailServer.send(client.getEmail(), msgContent);
    }
}
