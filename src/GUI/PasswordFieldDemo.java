/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author phatl
 */
import javax.swing.*;

public class PasswordFieldDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Field Demo");
        JPanel panel = new JPanel();
        
        JPasswordField passwordField = new JPasswordField(20);
        panel.add(passwordField);
        
        // Enable the "show password" button
        UIManager.put("PasswordField.showRevealButton", true);
        
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

