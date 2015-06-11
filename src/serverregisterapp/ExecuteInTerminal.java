/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverregisterapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Ivan
 */
public class ExecuteInTerminal {
    
    public static void execute(){
        String s;
        Process p;
        try {
            p = Runtime.getRuntime().exec("ls -aF");
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();
            System.out.println ("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e) {}
    }
    
}
