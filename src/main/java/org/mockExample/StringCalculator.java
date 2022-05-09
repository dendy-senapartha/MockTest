package org.mockExample;

/**
 * Project: MockTest
 * Package: org.mockExample
 * <p>
 * User: dendy
 * Date: 14/04/2021
 * Time: 8:00
 * <p>
 * Description : StringCalculator
 */
public class StringCalculator {

    public int Add(String input) {
/*
        if (input.contains(",")) {
//            int index=input.indexOf(",");
//            int a=Integer
//                    .parseInt(input.substring(0,index));
//            int b=Integer.parseInt(input.substring(index+1,input.length()));

            String[] split = input.split(",", 2);
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);


            if (a < 0) {
                throw new IllegalArgumentException("Bilangan tidak boleh negatif");
            }
            try {

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


            return a + b;
        }
        return 0;
*/
        if(!input.isEmpty()){
            input = input.replace(" ", "");
            int angka1 = Integer.parseInt(input.split(",")[0]);
            int angka2 = Integer.parseInt(input.split(",")[1]);
            if(angka1 < 0){
                throw new IllegalArgumentException("Bilangan tidak boleh negatif");
            }
            if(angka1 > 1000) {
                return angka2;
            }
            return angka1 + angka2;
        }
        return 0;
    }
}
