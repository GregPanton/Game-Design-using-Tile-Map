/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jamesgames.ui;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author James
 */
public class AboutBox extends JDialog
{
    private JButton okButton;
    private JLabel aboutLabel;
    
    public AboutBox()
    {
        okButton = new JButton("OK");
        aboutLabel = new JLabel("Created by J Bloggs (c) 2019");
        
        okButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               AboutBox.this.setVisible(false);
               AboutBox.this.dispose();
            }
        });
        
        this.setLayout(new BorderLayout());
        this.add(aboutLabel, BorderLayout.CENTER);
        this.add(okButton, BorderLayout.SOUTH);
        setModal(true);
        setLocationRelativeTo(null);
        setSize(100,100);
        setVisible(true);
    }
    
    
}
