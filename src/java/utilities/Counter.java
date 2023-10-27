/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

/**
 *
 * @author cld
 */
public class Counter {
    private static int count;

    public static synchronized int getCount() throws InterruptedException {
        /*int temp = count;
        temp++;
        Thread.sleep(new Random().nextInt(5000));
        count = temp;*/
        count++;
        return count;
    }
}
