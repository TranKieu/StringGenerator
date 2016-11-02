package io.github.tranvd2010.ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CellRenderer extends JLabel implements ListCellRenderer<Object> {

    private static final long serialVersionUID = 2010L;

	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
    	this.setOpaque(true);
        setBorder(new EmptyBorder(3, 10, 3, 10));
        
        setText(value.toString());
        
        

        
        if(isSelected){
            this.setForeground(UIManager.getColor("List.selectionForeground"));
           
            this.setBackground(UIManager.getColor("List.selectionBackground"));
          } else{
        	  if (index % 2 == 0) {
        		  this.setForeground(UIManager.getColor("List.foreground"));
        		  setBackground( new Color(235, 235, 235));
        	  }else {
        		  this.setBackground(UIManager.getColor("List.background"));
        		  this.setForeground(UIManager.getColor("List.foreground"));
        	  }
              	
           }
        
        
        return this;
    }
}