package new_lab;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class QuizApplication extends JFrame
{
    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup optionsGroup;
    private JButton nextButton;
    private JButton finishButton;

    private int currentQuestionIndex = 0;
    private int score = 0;

    private String[] questions = 
    	{
        "Who painted the famous artwork \"The Scream\"?",
        "What is the largest country in the world by land area?",
        "Who painted the Mona Lisa?",
        "What is the chemical symbol for gold?",
        "Which planet is known as the Red Planet?",
        "What is the capital of Australia?",
        "Who wrote the Harry Potter series?",
        "What is the largest ocean in the world?",
        "Who invented the light bulb?",
        "What is the tallest mountain in the world?",
        "What is the national animal of India?",
        "Which gas do plants need to perform photosynthesis?",
        "Who is the author of the book \"Pride and Prejudice\"?",
        "What is the currency of Japan?",
        "Which country is known as the Land of the Rising Sun?",
        "What is the largest desert in the world?",
        "Who is the father of modern physics?",
        "What is the smallest country in the world?",
        "What is the largest organ in the human body?",
        "Who was the first person to walk on the moon?",
        "What is the capital of France?",
        "What is the fastest land animal?",
        "Which is the only metal that is liquid at room temperature?",
        "Which element is essential for making nuclear energy?",
        "Who discovered penicillin?"
    };

    private String[][] optionsText = 
    	{
        {"Vincent van Gogh", "Leonardo da Vinci", "Edvard Munch", "Pablo Picasso"},
        {"China", "Canada", "Russia", "United States"},
        {"Vincent van Gogh", "Leonardo da Vinci", "Pablo Picasso", "Michelangelo"},
        {"Au", "Ag", "Fe", "Hg"},
        {"Mars", "Venus", "Jupiter", "Saturn"},
        {"Sydney", "Melbourne", "Canberra", "Perth"},
        {"J.R.R. Tolkien", "Stephen King", "J.K. Rowling", "Dan Brown"},
        {"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"},
        {"Thomas Edison", "Nikola Tesla", "Albert Einstein", "Marie Curie"},
        {"Mount Kilimanjaro", "Mount Everest", "Mount Fuji", "Aconcagua"},
        {"Tiger", "Lion", "Elephant", "Peacock"},
        {"Oxygen", "Carbon dioxide", "Nitrogen", "Hydrogen"},
        {"Jane Austen", "Charlotte Brontë", "Emily Brontë", "Virginia Woolf"},
        {"Yen", "Won", "Rupee", "Dollar"},
        {"China", "India", "Japan", "South Korea"},
        {"Gobi Desert", "Sahara Desert", "Arabian Desert", "Antarctic Desert"},
        {"Isaac Newton", "Albert Einstein", "Galileo Galilei", "Marie Curie"},
        {"Vatican City", "Monaco", "Liechtenstein", "Maldives"},
        {"Heart", "Lungs", "Liver", "Skin"},
        {"Neil Armstrong", "Buzz Aldrin", "Yuri Gagarin", "Alan Shepard"},
        {"Paris", "Rome", "London", "Berlin"},
        {"Cheetah", "Leopard", "Lion", "Tiger"},
        {"Mercury", "Lead", "Gallium", "Tin"},
        {"Uranium", "Helium", "Carbon", "Plutonium"},
        {"Alexander Fleming", "Marie Curie", "Joseph Lister", "Edward Jenner"}
    };

    private int[] correctAnswers = 
    	{
        2, 2, 1, 0, 0, 2, 2, 3, 0, 1, 0, 1, 0, 0, 2, 3, 1, 0, 3, 0, 0, 0, 0, 0, 0
    };

    public QuizApplication() 
    {
        setTitle("Simple Quiz Application");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        questionLabel = new JLabel();
        options = new JRadioButton[4];
        optionsGroup = new ButtonGroup();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        add(questionLabel, gbc);

        for (int i = 0; i < options.length; i++) 
        {
            options[i] = new JRadioButton();
            optionsGroup.add(options[i]);
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.WEST;
            add(options[i], gbc);
        }

        nextButton = new JButton("Next");
        gbc.gridx = 0;
        gbc.gridy = options.length + 1;
        add(nextButton, gbc);

        finishButton = new JButton("Finish");
        finishButton.setVisible(false);
        gbc.gridx = 1;
        add(finishButton, gbc);

        nextButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                checkAnswer();
                currentQuestionIndex++;
                
                if (currentQuestionIndex < questions.length) 
                {
                    loadQuestion();
                } 
                else 
                {
                    nextButton.setVisible(false);
                    finishButton.setVisible(true);
                }
            }
        });

        finishButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                JOptionPane.showMessageDialog(null, "Your final score is: " + score + "/" + questions.length);
                System.exit(0);
            }
        });

        loadQuestion();
        setVisible(true);
    }

    private void loadQuestion() 
    {
        questionLabel.setText(questions[currentQuestionIndex]);
        
        for (int i = 0; i < options.length; i++) 
        {
            options[i].setText(optionsText[currentQuestionIndex][i]);
            options[i].setSelected(false);
        }
    }

    private void checkAnswer() 
    {
        int selectedOption = -1;
        
        for (int i = 0; i < options.length; i++) 
        {
            if (options[i].isSelected()) 
            {
                selectedOption = i;
                break;
            }
        }
        if (selectedOption == correctAnswers[currentQuestionIndex]) 
        {
            score++;
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new QuizApplication());
    }
}
