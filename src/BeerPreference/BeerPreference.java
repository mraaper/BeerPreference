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
	JPanel panel;
	JRadioButton choice1;
	JRadioButton choice2;
	JRadioButton choice3;
	ButtonGroup bg;
	JLabel lblmess;
	JButton btnext;
	String[][] qpa;
	String[][] questionAnswers;
	int qaid;

	int pointCollection = 0;

	Beer() {
		initializedata();
		setTitle("Õllesoovitaja");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(430, 350);
		setLocation(300, 100);
		setResizable(false);
		Container cont = getContentPane();
		cont.setLayout(null);
		cont.setBackground(Color.BLACK);
		bg = new ButtonGroup();
		choice1 = new JRadioButton("Choice1", true);
		choice2 = new JRadioButton("Choice2", true);
		choice3 = new JRadioButton("Choice3", true);

		bg.add(choice1);
		bg.add(choice2);
		bg.add(choice3);

		lblmess = new JLabel("Anna oma sisend");
		lblmess.setForeground(Color.BLACK);
		lblmess.setFont(new Font("Berlin Sans FB", Font.BOLD, 15));
		btnext = new JButton("Next");
		btnext.setForeground(Color.BLACK);
		btnext.addActionListener(this);
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLocation(10, 10);
		panel.setSize(400, 300);
		panel.setLayout(new GridLayout(6, 2));
		panel.add(lblmess);
		panel.add(choice1);
		panel.add(choice2);
		panel.add(choice3);

		panel.add(btnext);
		cont.add(panel);
		setVisible(true);
		qaid = 0;
		readqa(qaid);

	}

	public void actionPerformed(ActionEvent e) {

		if (btnext.getText().equals("Next")) {
			if (qaid < 6) {

				pointCollection = pointCollection + getPoints();
				qaid++;
				readqa(qaid);
			} else {
				pointCollection = pointCollection + getPoints();
				btnext.setText("Ihaldusobjektiks on ...");

			}
		} else if (btnext.getText().equals("Ihaldusobjektiks on ..."))
			new Report();

	}

	public void initializedata() {
		// qpa stores pairs of question and its possible answers
		qpa = new String[10][5];

		qpa[0][0] = "Palun märkige oma vanus";
		qpa[0][1] = "18-30";
		qpa[0][2] = "31-49";
		qpa[0][3] = "50-75";

		qpa[1][0] = "Palun valige enda maitse järgi õlule sobiv aroom";
		qpa[1][1] = "Lõhnatu on mu teine nimi";
		qpa[1][2] = "Parajalt humalane ja hää";
		qpa[1][3] = "Külmade talveõhtute nauding";

		qpa[2][0] = "Palun valige õlule sobiv värvus";
		qpa[2][1] = "Naeratav blondiin";
		qpa[2][2] = "Õhetav punapea";
		qpa[2][3] = "Naudisklev brünett";

		qpa[3][0] = "Palun valige õllele sobiv tugevus";
		qpa[3][1] = "Kärbes/sulgkaal";
		qpa[3][2] = "Isa soovitusel midagi hääd!";
		qpa[3][3] = "Sink the Bismarck!";

		qpa[4][0] = "Palun valige õllele sobiv maitse";
		qpa[4][1] = "Oot...see maitseb ju nagu....vesi?!";
		qpa[4][2] = "Päris hea humalane ettevõtmine";
		qpa[4][3] = "Oleme me kindlad, et tegu on lahja alkoholiga??";

		qpa[5][0] = "Palun valige õllele sobiv tüüp";
		qpa[5][1] = "Malbe ja tagasihoidlik";
		qpa[5][2] = "Põhimõtteliselt olen valmis seikluseks, vist";
		qpa[5][3] = "Don't care, don't want to know!";

		qpa[6][0] = "Palun valige õlle päritolu piirkond";
		qpa[6][1] = "A mul on jummala ükskõik ää";
		qpa[6][2] = "Euroopast saab hääd kraami";
		qpa[6][3] = "EESTI!";

	}

	public int getPoints() {
		int points = 0;
		Enumeration<AbstractButton> buttons = bg.getElements();
		while (buttons.hasMoreElements()) {
			JRadioButton temp = (JRadioButton) buttons.nextElement();
			points = points + 1;
			if (temp.isSelected()) {
				break;
			}
		}

		return points;
	}

	public void readqa(int qid) {
		lblmess.setText("  " + qpa[qid][0]);
		choice1.setText(qpa[qid][1]);
		choice2.setText(qpa[qid][2]);
		choice3.setText(qpa[qid][3]);

		choice1.setSelected(true);
	}

	public void reset() {
		qaid = 0;

		readqa(qaid);
		btnext.setText("Next");
	}

	public class Report extends JFrame {
		Report() {
			setTitle("Õllesoovitus");
			setSize(900, 250);
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
					g.drawString("Soovitus: Lindemans Kriek  3,5%", x, y);
				} else if (pointCollection >= 10 && pointCollection <= 13) {
					g.drawString("Soovitus: Brewdog Punk IPA  5,6%", x, y);
				} else if (pointCollection >= 14 && pointCollection <= 17) {
					g.drawString("Soovitus: Rochefort Trappistes 8  9,2%", x, y);
				} else {
					g.drawString("Soovitus: Boneyard Baltic Notorious IPA3  12%", x, y);
				}

			}
		}

	}

}

public class BeerPreference {

	public static void main(String args[]) {
		new Beer();

	}

}

// Iga küsimuse vastamise korral on väljendub sisend punktides.
// Sõltuvalt vastustest ja akumuleerunud punktidest tuleneb ka õllesoovitus.
// Vahemikke on 4: 0-9p, 10p-13p, 14-17p, 18-21p.
// I kategooria soovitus: Lindemans Kriek 3,5%
// II kategooria soovitus: Brewdog Punk IPA 5,6%
// III kategooria soovitus: Rochefort Trappistes 8 9,2%
/// IV kategooria soovitus: Boneyard Baltic Notorious IPA3 12%
