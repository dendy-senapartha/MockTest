package org.mockExample;

import org.mockExample.messangerExample.*;

import static org.mockito.Mockito.*;
import org.junit.Test;
/**
 * Project: MockTest
 * Package: org.mockExample
 * <p>
 * User: dendy
 * Date: 07/04/2021
 * Time: 9:02
 * <p>
 * Description : MessangerTest
 */
public class MessangerTest {
    //create dummy object
    Template template = mock(Template.class);
    Client client = mock(Client.class);

    //mock object
    MailServer mailServer = mock(MailServer.class);
    TemplateEngine templateEngine = mock(TemplateEngine.class);

    final  String CLIENT_EMAIL = "dendy.prtha@ti.ukdw.ac.id";
    final  String CLIENT_MSG = "Hello World!";
    @Test
    public void shouldSendEmail(){
        //prepare SUT
        Messanger sut = new Messanger(mailServer, templateEngine);
        when(client.getEmail())
                .thenReturn(CLIENT_EMAIL);
        when(templateEngine.prepareMessage(template, client))
                .thenReturn(CLIENT_MSG);

        //ACT
        sut.sendMessage(client, template);

        //verfy
        verify(mailServer).send(CLIENT_EMAIL, CLIENT_MSG);
    }

}
