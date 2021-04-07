package org.mockExample.messangerExample;

/**
 * Project: MockTest
 * Package: org.mockExample.messangerExample
 * <p>
 * User: dendy
 * Date: 07/04/2021
 * Time: 8:52
 * <p>
 * Description : TemplateEngine mock class
 */
public interface TemplateEngine {
    String prepareMessage(Template template, Client client);
}
