package org.mockExample.messangerExample;

/**
 * Project: MockTest
 * Package: org.mockExample.messangerExample
 * <p>
 * User: dendy
 * Date: 07/04/2021
 * Time: 8:54
 * <p>
 * Description : MailServer mock class
 */
public interface MailServer {
    void send(String email, String msgContent);
}
