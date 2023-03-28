package no.hvl.dat102.kjedet;

import java.util.Scanner;
import java.lang.Integer.*;

import no.hvl.dat102.adt.StabelADT;
import no.hvl.dat102.kjedet.KjedetStabel;

public class MainTest extends KjedetStabel<String> {



	public static void main(String[] args) {
		String aktuell = null;
		
		Scanner scan = new Scanner(System.in);
		
		boolean valid = false;
		
		while (!valid) {
			System.out.println("velg en string fra 1 til 6");
			int trykt = Integer.parseInt(scan.nextLine());
			int i = 1;
			
			valid = true;
			switch (trykt) {
			case 1:
				aktuell = "Hei alle sammen";
				break;
			case 2:
				aktuell = "He(i dere r(aringer";
				break;
			case 3:
				aktuell = "Hei (albert) aaberg";
				break;
			case 4:
				aktuell = "Hva kaller man en mexicaner som har mistet bilen?";
				break;
			case 5:
				aktuell = ")";
				break;
			case 6:
				aktuell = "Carlos";
				break;

			default:
				System.out.println("prov igjen");
				valid = false;
			}
		}
		
		
		Iparentessjekker parser = new KjedetStabel<>();
		
		if (parser.erBalansert(aktuell)) {
			System.out.print("Koden fungerer");
		}
		
		
		

		
	}

}
