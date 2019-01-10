package com.victor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class JavaFonts implements ComponentListener{
	JFrame frame;
	public static void main(String[] args) {
		new JavaFonts();
		
	}
	public JavaFonts() {
		/*
		 * This line of code was written by Alvin Alexander from the page
		 * https://alvinalexander.com/blog/post/jfc-swing/swing-faq-list-fonts-current-platform
		 *///---------------------------------------------------------------------------------------------//
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); //
		//------------------------------------------------------------------------------------------------//
		int entryHeight = 40;
		
		frame = new JFrame("All Java Fonts");
		frame.addComponentListener(this);
		JPanel scrollPanel = new JPanel();
		
		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.PAGE_AXIS));
		scrollPanel.setBackground(new Color(0xf1f1f1));
		//scrollPanel.setPreferredSize(new Dimension(frame.getWidth(),entryHeight * fonts.length));
		

		JTextField fontSample;
		Font font;
		
		for (int i = 0; i < fonts.length; i++) {
			fontSample = new JTextField(fonts[i]);
			fontSample.setEditable(false); 
			fontSample.setHorizontalAlignment(JTextField.CENTER);
			fontSample.setPreferredSize(new Dimension(frame.getWidth(), entryHeight));
			fontSample.setBorder(BorderFactory.createEmptyBorder());
			fontSample.setOpaque(true);
			
			font = new Font(fonts[i], Font.CENTER_BASELINE, 18);
			fontSample.setFont(font);
			
			if(i % 2 == 0) {
				fontSample.setBackground(new Color(0xdbdbdb));
			}
			else {
				fontSample.setBackground(new Color(0xf1f1f1));
			}
			scrollPanel.add(fontSample);
		}
		
		JScrollPane scroll = new JScrollPane(scrollPanel, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setMinimumSize(new Dimension(0, 0));
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		frame.add(scroll);
		frame.setSize(400, 700);
		frame.setVisible(true);
	}
	@Override
	public void componentResized(ComponentEvent e) {
		if(frame.getWidth() > 500) {
			frame.setBounds(frame.getX(), frame.getY(), 500, frame.getHeight());
		}
		if(frame.getHeight() < 80) {
			frame.setBounds(frame.getX(), frame.getY(), frame.getWidth(), 80);
		}
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}