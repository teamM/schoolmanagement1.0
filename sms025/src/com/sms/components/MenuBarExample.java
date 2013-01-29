package com.sms.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarExample extends JFrame
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public MenuBarExample()
{

setTitle("MenuBarExample");
setSize(200, 350);


JMenuBar menuBar = new JMenuBar();

setJMenuBar(menuBar);


JMenu fileMenu = new JMenu("File");
JMenu editMenu = new JMenu("Edit");
JMenu viewMenu = new JMenu("View");
menuBar.add(fileMenu);
menuBar.add(editMenu);
menuBar.add(viewMenu);


JMenuItem newAction =   new JMenuItem("New");
JMenuItem openAction =  new JMenuItem("Open");
JMenuItem exitAction =  new JMenuItem("Exit");
JMenuItem cutAction =   new JMenuItem("Cut");
JMenuItem copyAction =  new  JMenuItem("Copy");
JMenuItem pasteAction =  new JMenuItem("Paste");
JMenuItem toolbarsAction= new JMenuItem("toolbarsAction");
fileMenu.add(newAction);
fileMenu.add(openAction);
fileMenu.addSeparator();
fileMenu.add(exitAction);
editMenu.add(cutAction);
editMenu.add(copyAction);
editMenu.add(pasteAction);
editMenu.addSeparator();
viewMenu.add(toolbarsAction);

newAction.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent arg0)

{
System.out.println("You clicked on the new action");
} 

});

}



public static void main(String[] args) 

{
MenuBarExample mba = new MenuBarExample();
mba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
mba.setVisible(true);
}
}

