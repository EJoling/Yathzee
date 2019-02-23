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
import java.util.Arrays;
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
	static int[] blokkeerArray = {0, 0, 0, 0, 0};
	
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
					System.out.println("12345 (nummmer dobbelsteen)");
					for (Dobbelsteen steen:Dobbelstenen)
						System.out.print(steen.werpen());
					System.out.println("");
					for (Dobbelsteen steen:Dobbelstenen)
						System.out.print(steen.vasthouden());
					
					
					
				
					break;
				case "q":
					System.out.println("Spel is gestopt");
					stoppen ++;
					break;
			
				}//end switch
		}//end while
	}//end methode spelen
	
}//end class YahtzeeSpel

class Dobbelsteen {
	
	int aantalOgen;
	
	int werpen(){
		for(int i =0; i<YahtzeeSpel.blokkeerArray.length; i++) {
			if(YahtzeeSpel.blokkeerArray[i] == 0) {
			Random random = new Random();
			aantalOgen = random.nextInt(6)+1;	
			}//end if
		}//end for loop
		return aantalOgen;
	}//end werpen
	
	
	
	
	//Deze methode moet nog restricties kennen: er moet een 1,2,3,4 of 5 worden ingevoerd, anders moet er een foutcode gegeven worden.
	//De vastgehouden dobbelstenen worden niet weergegeven 
	//Ook returnt hij op dit moment de locatie van de YahtzeeSpel.blokkeerArray
	
	int[] vasthouden() {
		System.out.println("Welke posities wilt u vasthouden? 0 voor geen anders bv 124: ");
		Scanner scanner2 = new Scanner(System.in);
		String inputVasthouden = scanner2.nextLine();
	
	//	Speler geeft aan welke dobbelsteen hij wil vasthouden. Dat wordt een 1 in de blokkeerArray.	
		for (int i=0; i < inputVasthouden.length(); i++) {
			int blokkeren = Integer.parseInt(inputVasthouden.substring(i, i+1)) -1;
			YahtzeeSpel.blokkeerArray[blokkeren] = 1;
		}//end for loop	
		
	//	Uitprinten welke dobbelsteen vastgehouden wordt
		for(int i=0;i<YahtzeeSpel.Dobbelstenen.size();i++) {
			if(YahtzeeSpel.blokkeerArray[i] == 1) {
				System.out.println("vastgehouden dobbelstenen: " + Arrays.toString(YahtzeeSpel.blokkeerArray));
			}//end if loop
		}//end for loop
		
		return YahtzeeSpel.blokkeerArray;
	}//end methode vasthouden
		
	
}//end class Dobbelsteen
	

