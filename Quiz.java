import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import sun.net.www.content.text.plain;


public class Quiz implements ActionListener{

	
	String[] question = {
							"<html>JAVA est un langage</html>",
							"<html>Toutes les classes héritent de la classe</html>",
							"<html>Par convention une classe</html>",
							"<html>Est-ce que on peut avoir constructeurs pour la même classe</html>",
							"<html>Dans la ligne public class A implements B, B est :</html>",
							"",
							"<html>Après la compilation, un programme écrit en JAVA, il se transforme en programme en bytecode Quelle est l’extension du programme en bytecode ?</html>",
							"<html>Class Test{Public Test () {System.out.println(”Bonjour”);} public Test (int i) {this(); System.out.println(”Nous sommes en ”+i+ ” !”);};} qu’affichera l’instruction suivante? Test t1=new Test (2018);</html>",
							"<html>Voici un constructeur de la classe Employee, y-a t'il un problème ? Public void Employe(String n){Nom=n;}</html>",
							"<html>Pour spécifier que la variable ne pourra plus être modifiée et doit être initialisée dès sa déclaration, on la déclare comme une constante avec le mot réservé</html>",
							"<html>Dans une classe, on accède à ses variables grâce au mot clé</html>",
							"",
							"<html>calculerSalaire(int) / calculerSalaire(int, double) \n La méthode calculerSalaire est : </html>",
							"<html>Une classe qui contient au moins une méthode abstraite doit être déclarée abstraite.</html>",
							"<html>Est-ce qu’une classe peut implémenter plusieurs interfaces ?</html>",
							"<html>La déclaration d'une méthode suivante :public void traitement() throws IOException précise que la méthode propage une exception contrôlée</html>",
							"<html>class Test{public static void main (String[] args) {try {int a =10; System.out.println (a = + a );int b = 0 / a;System.out.println (b = +b);}catch(ArithmeticException e){System.out.println (diviser par 0!); }finally {System.out.println (je suis à l’intérieur de finally);}}</html>"
							
							
						};
	
	String[][] option = {
							{"Compilé","Interprété", "Compilé et interpreté"},
							{"Main","Object", "AWT"},
							{"est en minuscule","commence par une majuscule", "est en majuscules"},
							{"Oui","Non"},
							{"Interfacce","Classe parent", "Package"},
							{},
							{"aucun des choix", ".JAVA", ".Class"},
							{"aucun des choix", "Boujour Nous sommes en 2018", "Nous sommes en 2018"},
							{"vrai", "fuax"},
							{"aucun des choix", "final", "const"},
							{"aucun des choix", "this", "super"},
							{},
							{"aucun des choix", "surchargée", "redéfinie"},
							{"vrai", "faux"},
							{"vrai", "faux"},
							{"vrai", "faux"},
							{"aucun des choix","a=10 b=0 je suis à l’intérieur de finally" ,"a=10 b=0 diviser par 0! je suis à l’intérieur de finally"}
						};
	char[] answers = {
							'A',
							'C',
							'B',
							'A',
							'A',
							' ',
							'A',
							'C',
							'A',
							'C',
							'B',
							' ',
							'A',
							'A',
							'B',
							'A',
							'B'
						};
	
	
	
	
	int ques;
	int index;
	char answer;
	int total_question = question.length;
	int scoore=20;
	int seconds1= 100;
	
	JFrame frame  = new JFrame();
	JTextField textfield = new JTextField();
	JLabel label = new JLabel();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	
	JTextField number_right = new JTextField();
	JLabel timerLabel = new JLabel();
	JProgressBar bar = new JProgressBar();
	JTextField niveau = new JTextField();
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			seconds1-=5;
			bar.setValue(seconds1);
			if(seconds1==0){
				displayquestion();	
			}
		}
	});
	
	Quiz(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLayout(null);
		frame.setResizable(false);
		
		
		
		
		
		//textfield
		textfield.setBounds(50,0,540,50);
		textfield.setBackground(null);
		textfield.setForeground(Color.green);
		textfield.setFont(new Font("MV Boli", Font.BOLD, 25));
		textfield.setEditable(false);
		textfield.setHorizontalAlignment(JTextField.CENTER);
		
		
		//niveau
		niveau.setBounds(255,455,130,50);
		niveau.setBackground(null);
		niveau.setForeground(Color.green);
		niveau.setFont(new Font("MV Boli", Font.BOLD, 50));
		niveau.setEditable(false);
		niveau.setHorizontalAlignment(JTextField.CENTER);
		
		//question
		label.setBounds(10,70,610,150);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("MV Boli", Font.BOLD, 20));
		label.setHorizontalAlignment(JTextField.CENTER);
		
		
		
		//button 
		buttonA.setBounds(50,220,540,70);
		buttonA.setFont(new Font("MV Boli", Font.BOLD, 25));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setBackground(new Color(204, 204, 204));
		buttonA.setText("A");
		buttonA.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
				
		
		buttonB.setBounds(50,300,540,70);
		buttonB.setFont(new Font("MV Boli", Font.BOLD, 25));
		buttonB.setFocusable(false);
		buttonB.setBackground(new Color(204, 204, 204));
		buttonB.addActionListener(this);
		buttonB.setText("B");
		buttonB.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
			
		
		buttonC.setBounds(50,380,540,70);
		buttonC.setFont(new Font("MV Boli", Font.BOLD, 25));
		buttonC.setFocusable(false);
		buttonC.setBackground(new Color(204, 204, 204));
		buttonC.addActionListener(this);
		buttonC.setText("C");
		buttonC.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		
		number_right.setBounds(100,225,400,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		
		//progress bar
		bar.setBounds(50,510,540,70);
		bar.setValue(100);
		bar.setStringPainted(true);
		bar.setFont(new Font("Ink Free", Font.BOLD, 20));
		bar.setForeground(Color.red);
		


		frame.add(niveau);
		frame.add(bar);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(label);
		frame.add(textfield);
		frame.setVisible(true);
		
		
		
		nextQuestion();
		
	}
	
	void nextQuestion(){
		if(index==5 || index==11 || index==17){
			results();
		}else
			
			for (int i = 0; i < question.length; i++) {
				if(option[index].length!=2){
					
					textfield.setText("Question "+(ques + 1)+ "/" + 15);
					label.setText(question[index]);
					buttonA.setText(option[index][0]);
					buttonB.setText(option[index][1]);
					buttonC.setVisible(true);
					buttonC.setText(option[index][2]);
					
					timer.start();
				}else{
					textfield.setText("Question "+(ques + 1)+ "/" + 15);
					label.setText(question[index]);
					buttonA.setText(option[index][0]);
					buttonB.setText(option[index][1]);
					buttonC.setVisible(false);
					timer.start();
			}
			if(index<=5){
				niveau.setText("N1");
			}else if(index<=11){
				niveau.setText("N2");
			}else if(index<=17){
				niveau.setText("N3");
			}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		
		if (e.getSource()==buttonA) {
			answer= 'A';
			if(answer == answers[index]){
				scoore+=20;
			}
		}
		if (e.getSource()==buttonB) {
			answer= 'B';
			if(answer == answers[index]){
				scoore+=20;
			}
		}
		if (e.getSource()==buttonC) {
			answer= 'C';
			if(answer == answers[index]){
				scoore+=20;
			}
		}
		displayquestion();
	}

	
	void displayquestion(){
		timer.stop();
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		
		if(answers[index] !='A'){
			buttonA.setBackground(new Color(255,0,0));
		}else{
			buttonA.setBackground(Color.green);
		}
		if(answers[index] !='B'){
			buttonB.setBackground(new Color(255,0,0));
		}else{
			buttonB.setBackground(Color.green);
		}
		if(answers[index] !='C'){
			buttonC.setBackground(new Color(255,0,0));
		}else{
			buttonC.setBackground(Color.green);
		}
		
		ques++;
		
		
		Timer pause  = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonA.setBackground(new Color(204, 204, 204));
				buttonB.setBackground(new Color(204, 204, 204));
				buttonC.setBackground(new Color(204, 204, 204));
				
				
				answer = ' ';
				seconds1=100;
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				index++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
	
	
	void results(){
		if(index==5 && scoore<40){
			buttonA.setVisible(false);
			buttonB.setVisible(false);
			buttonC.setVisible(false);
			niveau.setVisible(false);
			bar.setVisible(false);
			
			label.setText("");
			number_right.setText("YOU LOST");
			frame.add(number_right);
			
		}else if(index==11 && scoore<60){
			buttonA.setVisible(false);
			buttonB.setVisible(false);
			buttonC.setVisible(false);
			niveau.setVisible(false);
			bar.setVisible(false);
			
			label.setText("");
			number_right.setText("YOU LOST");
			frame.add(number_right);
		}
		else if(index==17){
			if(scoore<80){
				buttonA.setVisible(false);
				buttonB.setVisible(false);
				buttonC.setVisible(false);
				niveau.setVisible(false);
				bar.setVisible(false);
				
				label.setText("");
				number_right.setText("YOU LOST");
				frame.add(number_right);
			}
			else{
				System.out.println(scoore);
				buttonA.setVisible(false);
				buttonB.setVisible(false);
				buttonC.setVisible(false);
				niveau.setVisible(false);
				bar.setVisible(false);
				
				label.setText("");
				number_right.setText("YOU WIN!!");
				frame.add(number_right);
			}
		}
		else{
			
			
			
			
			
			
			scoore=0;
			index++;
			nextQuestion();
		}
		
		
	}
	
	
}
