/**
 * Yathzeespel waarbij O.O.P. een vereiste is. 
 * Bij het aanmaken van een nieuw spel worden er 5 dobbelstenen aangemaakt, waarmee geworpen kan worden. 
 * 
 * 
 * 
 * 
 * @author Emiel
 */


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Yathzee {

	public static void main(String[] args) {
		
		YahtzeeSpel spel = new YahtzeeSpel();
		spel.spelen();
		
		
		
	}//end main	
}//end class Yathzee

class YahtzeeSpel {
	// Elk spel start met 5 dobbelstenen
	static ArrayList<Dobbelsteen> Dobbelstenen = new ArrayList<>();
	
	YahtzeeSpel(){
			for(int i =0; i<5; i++) {
			Dobbelsteen dobbelsteen = new Dobbelsteen();
			Dobbelstenen.add((i), dobbelsteen);
			}//end for loop		
	}//end constructor YahtzeeSpel
	
	static void spelen() {
		int stoppen = 0;
		
		while(stoppen == 0) {
			System.out.println("Druk op Enter om te spelen, q om te stoppen");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();	
			 //	Een speler kan spelen(werpen) of het spel stoppen  
				switch(input) {
				case "":
					System.out.println("De worp is:");
					for (Dobbelsteen steen:Dobbelstenen)
						System.out.print(steen.werpen());
					System.out.println("");
						System.out.println("Plek 0 : " + Dobbelstenen.get(0));
						System.out.println("Plek 0 waarde: " + Dobbelstenen.get(0).aantalOgen);
					
					break;
				case "q":
					System.out.println("Spel is gestopt");
					stoppen ++;
					break;
			
				}//end switch
		}//end while
	}//end methode spelen
	
	
class Dobbelsteen {
	
	int aantalOgen;
	
	int werpen(){
		Random random = new Random();
		aantalOgen = random.nextInt(6)+1;
		return aantalOgen;
		
		
		
	}//end werpen
	
}//end class Dobbelsteen
	
}//end class YahtzeeSpel
