package new_lab;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TextEditor extends JFrame implements ActionListener 
{
	private JTextArea textArea;
	private JLabel statusBar;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem openItem, saveItem, clearItem, exitItem;
	private JFileChooser fileChooser;

	public TextEditor() 
	{

		setTitle("Text Editor");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);


		textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.PLAIN, 16));
		textArea.setBackground(new Color(240, 248, 255));
		textArea.setForeground(Color.DARK_GRAY);

		statusBar = new JLabel(" Characters: 0 | Lines: 0 ");
		statusBar.setFont(new Font("Arial", Font.PLAIN, 14));
		statusBar.setBorder(BorderFactory.createEtchedBorder());

		fileChooser = new JFileChooser();

		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		openItem = new JMenuItem("Open");
		saveItem = new JMenuItem("Save");
		clearItem = new JMenuItem("Clear");
		exitItem = new JMenuItem("Exit");


		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		fileMenu.add(clearItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);


		menuBar.add(fileMenu);
		setJMenuBar(menuBar);


		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		clearItem.addActionListener(this);
		exitItem.addActionListener(this);
		textArea.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent e) 
			{
				updateStatus();
			}
		});

		// Add components to frame
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		add(statusBar, BorderLayout.SOUTH);
	}

	// Handle menu actions
	public void actionPerformed1(ActionEvent e)
	{
		if (e.getSource() == openItem) 
		{
			openFile();
		} else if (e.getSource() == saveItem) 
		{
			saveFile();
		} else if (e.getSource() == clearItem) 
		{
			textArea.setText("");
			updateStatus();
		} else if (e.getSource() == exitItem) 
		{
			System.exit(0);
		}
	}


	private void openFile() 
	{
		int option = fileChooser.showOpenDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) 
		{
			File file = fileChooser.getSelectedFile();
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
			{
				textArea.read(reader, null);
				updateStatus();
			} 
			catch (IOException ex) 
			{
				showError("Error opening file: " + ex.getMessage());
			}
		}
	}


	private void saveFile() 
	{
		int option = fileChooser.showSaveDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) 
		{
			File file = fileChooser.getSelectedFile();
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) 
			{
				textArea.write(writer);
			} catch (IOException ex) 
			{
				showError("Error saving file: " + ex.getMessage());
			}
		}
	}


	private void updateStatus() 
	{
		String text = textArea.getText();
		int charCount = text.length();
		int lineCount = text.split("\n").length;
		statusBar.setText(" Characters: " + charCount + " | Lines: " + lineCount + " ");
	}

	
	private void showError(String message) 
	{
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
	}


	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(() -> 
		{
			new TextEditor().setVisible(true);
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	    if (e.getSource() == openItem) 
	    {
	        int option = fileChooser.showOpenDialog(this);
	        if (option == JFileChooser.APPROVE_OPTION) 
	        {
	            File file = fileChooser.getSelectedFile();
	            try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
	            {
	                textArea.read(reader, null);
	                updateStatus();
	            } 
	            catch (IOException ex) 
	            {
	                JOptionPane.showMessageDialog(this, "Error opening file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    } 
	    else if (e.getSource() == saveItem) 
	    {
	        int option = fileChooser.showSaveDialog(this);
	        if (option == JFileChooser.APPROVE_OPTION) 
	        {
	            File file = fileChooser.getSelectedFile();
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) 
	            {
	                textArea.write(writer);
	            } 
	            catch (IOException ex) 
	            {
	                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    } 
	    else if (e.getSource() == clearItem) 
	    {
	        textArea.setText("");
	        updateStatus();
	    } 
	    else if (e.getSource() == exitItem) 
	    {
	        System.exit(0);
	    }
	}

}
