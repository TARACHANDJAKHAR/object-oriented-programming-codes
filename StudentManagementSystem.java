package new_lab;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class StudentManagementSystem extends JFrame 
{
	private JTextField txtId, txtName, txtAge, txtGender, txtDepartment;
	private JTable table;
	private DefaultTableModel tableModel; 
	
	public StudentManagementSystem() 
	{
		setTitle("Student Management System");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		txtId = new JTextField(10);
		txtName = new JTextField(10);
		txtAge = new JTextField(10);
		txtGender = new JTextField(10);
		txtDepartment = new JTextField(10);


		JButton btnAdd = new JButton("Add");
		JButton btnUpdate = new JButton("Update");
		JButton btnDelete = new JButton("Delete");
		JButton btnView = new JButton("View");


		String[] columnNames = { "Student ID", "Name", "Age", "Gender", "Department" };
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);


		add(new JLabel("Student ID:"));
		add(txtId);
		add(new JLabel("Name:"));
		add(txtName);
		add(new JLabel("Age:"));
		add(txtAge);
		add(new JLabel("Gender:"));
		add(txtGender);
		add(new JLabel("Department:"));
		add(txtDepartment);
		add(btnAdd);
		add(btnUpdate);
		add(btnDelete);
		add(btnView);
		add(scrollPane);


		btnAdd.addActionListener(e -> addStudent());
		btnUpdate.addActionListener(e -> updateStudent());
		btnDelete.addActionListener(e -> deleteStudent());
		btnView.addActionListener(e -> viewStudents());

		setVisible(true);
	}


	private Connection getConnection() 
	{
		Connection connection = null;
		try 
		{
			String url = "jdbc:mysql://localhost:3306/student_management";
			String user = "root";
			String password = "Tarachand@2005";
			connection = DriverManager.getConnection(url, user, password);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return connection;
	}


	private void addStudent() 
	{
		try (Connection connection = getConnection()) 
		{
			String sql = "INSERT INTO students (name, age, gender, department) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, txtName.getText());
			statement.setInt(2, Integer.parseInt(txtAge.getText()));
			statement.setString(3, txtGender.getText());
			statement.setString(4, txtDepartment.getText());
			statement.executeUpdate();
			
			JOptionPane.showMessageDialog(this, "Student added successfully!");
			clearFields();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error adding student: " + e.getMessage());
		}
	}


	private void updateStudent() 
	{
		try 
		{
			int studentId = Integer.parseInt(txtId.getText());
			if (studentId <= 0) 
			{
				JOptionPane.showMessageDialog(this, "Please enter a valid Student ID.");
				return;
			}

			try (Connection connection = getConnection()) 
			{
				String sql = "UPDATE students SET name=?, age=?, gender=?, department=? WHERE student_id=?";
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, txtName.getText());
				statement.setInt(2, Integer.parseInt(txtAge.getText()));
				statement.setString(3, txtGender.getText());
				statement.setString(4, txtDepartment.getText());
				statement.setInt(5, studentId);
				int rowsUpdated = statement.executeUpdate();
				
				if (rowsUpdated > 0) 
				{
					JOptionPane.showMessageDialog(this, "Student updated successfully!");
				} 
				else 
				{
					JOptionPane.showMessageDialog(this, "No student found with the given ID.");
				}
				clearFields();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error updating student: " + e.getMessage());
		} 
		catch (NumberFormatException e) 
		{
			JOptionPane.showMessageDialog(this, "Please enter a valid number for Age and Student ID.");
		}
	}


	private void deleteStudent() 
	{
		try 
		{
			int studentId = Integer.parseInt(txtId.getText());
			if (studentId <= 0) 
			{
				JOptionPane.showMessageDialog(this, "Please enter a valid Student ID.");
				return;
			}

			try (Connection connection = getConnection()) 
			{
				String sql = "DELETE FROM students WHERE student_id=?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, studentId);
				int rowsDeleted = statement.executeUpdate();
				
				if (rowsDeleted > 0) 
				{
					JOptionPane.showMessageDialog(this, "Student deleted successfully!");
				} 
				else 
				{
					JOptionPane.showMessageDialog(this, "No student found with the given ID.");
				}
				clearFields();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error deleting student: " + e.getMessage());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Please enter a valid number for Student ID.");
		}
	}


	private void viewStudents() 
	{
		try (Connection connection = getConnection()) 
		{
			String sql = "SELECT * FROM students";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();


			tableModel.setRowCount(0);

			while (resultSet.next()) 
			{
				int id = resultSet.getInt("student_id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String department = resultSet.getString("department");
				tableModel.addRow(new Object[] { id, name, age, gender, department });
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error retrieving students: " + e.getMessage());
		}
	}


	private void clearFields() 
	{
		txtId.setText("");
		txtName.setText("");
		txtAge.setText("");
		txtGender.setText("");
		txtDepartment.setText("");
	}


	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(() -> new StudentManagementSystem());
	}
}