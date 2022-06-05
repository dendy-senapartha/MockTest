package org.bddExample;

/**
 * @author dendy
 * @Date 31/05/2022
 * @Time 10.21
 * Description :
 */
public class IsItFriday {

    static String isItFriday(String today) {
        if(today.equalsIgnoreCase("friday")){
            return "TGIF";
        }
        else {
            return "Nope";
        }
    }
}
