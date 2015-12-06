package BeerPreference;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

// Kasutatud on koodiridu saidilt http://java.worldbestlearningcenter.com/2013/04/quiz-program.html
// Koodiread võtsin eeskujuks, mille alusel koostasin enda user inputi ja vastavad vahemikud

class Beer extends JFrame implements ActionListener {
	JPanel background;
	JRadioButton choice1;
	JRadioButton choice2;
	JRadioButton choice3;
	ButtonGroup buttonSelection;
	JLabel setLabel;
	JButton nextButton;
	String[][] beerQuestion;
	int questionAmount;

	int pointCollection = 0;

	Beer() {
		initializedata();
		setTitle("Õllesoovitaja");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(430, 350);
		setLocation(300, 100);
		setResizable(false);
		Container setScene = getContentPane();
		setScene.setLayout(null);
		setScene.setBackground(Color.BLACK);
		buttonSelection = new ButtonGroup();
		choice1 = new JRadioButton("Choice1", true);
		choice2 = new JRadioButton("Choice2", true);
		choice3 = new JRadioButton("Choice3", true);

		buttonSelection.add(choice1);
		buttonSelection.add(choice2);
		buttonSelection.add(choice3);

		setLabel = new JLabel();
		setLabel.setForeground(Color.BLACK);
		setLabel.setFont(new Font("Berlin Sans FB", Font.BOLD, 15));
		nextButton = new JButton("Next");
		nextButton.setForeground(Color.BLACK);
		nextButton.addActionListener(this);
		background = new JPanel();
		background.setBackground(Color.LIGHT_GRAY);
		background.setLocation(10, 10);
		background.setSize(400, 300);
		background.setLayout(new GridLayout(6, 2));
		background.add(setLabel);
		background.add(choice1);
		background.add(choice2);
		background.add(choice3);

		background.add(nextButton);
		setScene.add(background);
		setVisible(true);
		questionAmount = 0;
		calculate(questionAmount);

	}

	public void actionPerformed(ActionEvent e) {

		if (nextButton.getText().equals("Next")) {
			if (questionAmount < 6) {

				pointCollection = pointCollection + getPoints();
				questionAmount++;
				calculate(questionAmount);
			} else {
				pointCollection = pointCollection + getPoints();
				nextButton.setText("Ihaldusobjektiks on ...");

			}
		} else if (nextButton.getText().equals("Ihaldusobjektiks on ..."))
			new Report();

	}

	public void initializedata() {
		beerQuestion = new String[10][5];

		beerQuestion[0][0] = "Palun märkige oma vanus";
		beerQuestion[0][1] = "18-30";
		beerQuestion[0][2] = "31-49";
		beerQuestion[0][3] = "50-75";

		beerQuestion[1][0] = "Palun valige enda maitse järgi õlule sobiv aroom";
		beerQuestion[1][1] = "Lõhnatu on mu teine nimi";
		beerQuestion[1][2] = "Parajalt humalane ja hää";
		beerQuestion[1][3] = "Külmade talveõhtute nauding";

		beerQuestion[2][0] = "Palun valige õlule sobiv värvus";
		beerQuestion[2][1] = "Naeratav blondiin";
		beerQuestion[2][2] = "Õhetav punapea";
		beerQuestion[2][3] = "Naudisklev brünett";

		beerQuestion[3][0] = "Palun valige õllele sobiv tugevus";
		beerQuestion[3][1] = "Kärbes/sulgkaal";
		beerQuestion[3][2] = "Isa soovitusel midagi hääd!";
		beerQuestion[3][3] = "Sink the Bismarck!";

		beerQuestion[4][0] = "Palun valige õllele sobiv maitse";
		beerQuestion[4][1] = "Oot...see maitseb ju nagu....vesi?!";
		beerQuestion[4][2] = "Päris hea humalane ettevõtmine";
		beerQuestion[4][3] = "Oleme me kindlad, et tegu on lahja alkoholiga??";

		beerQuestion[5][0] = "Palun valige õllele sobiv tüüp";
		beerQuestion[5][1] = "Malbe ja tagasihoidlik";
		beerQuestion[5][2] = "Põhimõtteliselt olen valmis seikluseks, vist";
		beerQuestion[5][3] = "Don't care, don't want to know!";

		beerQuestion[6][0] = "Palun valige õlle päritolu piirkond";
		beerQuestion[6][1] = "A mul on jummala ükskõik ää";
		beerQuestion[6][2] = "Euroopast saab hääd kraami";
		beerQuestion[6][3] = "EESTI!";

	}

	public int getPoints() {
		int points = 0;
		Enumeration<AbstractButton> buttons = buttonSelection.getElements();
		while (buttons.hasMoreElements()) {
			JRadioButton temp = (JRadioButton) buttons.nextElement();
			points = points + 1;
			if (temp.isSelected()) {
				break;
			}
		}

		return points;
	}

	public void calculate(int score) {
		setLabel.setText("  " + beerQuestion[score][0]);
		choice1.setText(beerQuestion[score][1]);
		choice2.setText(beerQuestion[score][2]);
		choice3.setText(beerQuestion[score][3]);

		choice1.setSelected(true);
	}

	public void reset() {
		questionAmount = 0;

		calculate(questionAmount);
		nextButton.setText("Next");
	}

	public class Report extends JFrame {
		Report() {
			setTitle("Õllesoovitus");
			setSize(1200, 250);
			setBackground(Color.WHITE);
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
					reset();
				}
			});
			Draw d = new Draw();
			add(d);
			setVisible(true);
		}

		class Draw extends Canvas {
			public void paint(Graphics g) {

				int x = 150;
				int y = 120;

				g.setFont(new Font("Arial", Font.BOLD, 36));

				if (pointCollection < 10) {
					g.drawString("Madis Raaper (IA17) soovitab: Lindemans Kriek  3,5%", x, y);
				} else if (pointCollection >= 10 && pointCollection <= 13) {
					g.drawString("Madis Raaper (IA17) soovitab: Brewdog Punk IPA  5,6%", x, y);
				} else if (pointCollection >= 14 && pointCollection <= 17) {
					g.drawString("Madis Raaper (IA17) soovitab: Rochefort Trappistes 8  9,2%", x, y);
				} else {
					g.drawString("Madis Raaper (IA17) soovitab: Boneyard Baltic Notorious IPA3  12%", x, y);
				}

			}
		}

	}

}

// Iga küsimuse vastamise korral väljendub sisend punktides.
// Sõltuvalt vastustest ja akumuleerunud punktidest tuleneb ka õllesoovitus.
// Vahemikke on 4: 0-9p, 10p-13p, 14-17p, 18-21p.
// I kategooria soovitus: Lindemans Kriek 3,5%
// II kategooria soovitus: Brewdog Punk IPA 5,6%
// III kategooria soovitus: Rochefort Trappistes 8 9,2%
/// IV kategooria soovitus: Boneyard Baltic Notorious IPA3 12%
