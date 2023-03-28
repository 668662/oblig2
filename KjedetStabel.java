package no.hvl.dat102.kjedet;

import java.util.ArrayList;

import no.hvl.dat102.adt.StabelADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class KjedetStabel<T> implements StabelADT<T>, Iparentessjekker {
	private LinearNode<T> topp;
	
	@Override
	public  boolean erVenstreparentes(char p) {
		boolean Pvenstre = false;

		if (p == '(' || p == '[' || p == '{') {
			Pvenstre = true;
		}
		return Pvenstre;
	}

	@Override
	public boolean erHogreparentes(char p) {
		boolean Phogre = false;

		if (p == ')' || p == ']' || p == '}') {
			Phogre = true;
		}
		return Phogre;
	}

	@Override
	public boolean erParentes(char p) {
		boolean parantes = false;

		if (p == '(' || p == '[' || p == '{' || p == ')' || p == ']' || p == '}') {
			parantes = true;
		}
		return parantes;
	}

	@Override
	public boolean erPar(char venstre, char hogre) {
		boolean matcher = false;

		if (venstre == '(' && hogre == ')') {
			matcher = true;
		}
		if (venstre == '[' && hogre == ']') {
			matcher = true;
		}
		if (venstre == '{' && hogre == '}') {
			matcher = true;
		}
		return matcher;
	}


	public KjedetStabel() {
		topp = null;

	}

	@Override
	public void push(T el) {
		LinearNode<T> nynode = new LinearNode<T>(el);
		nynode.setNeste(topp);
		topp = nynode;

	}

	@Override
	public T pop() {
		if (erTom())
			throw new EmptyCollectionException("stabel");
		T resultat = topp.getElement();
		topp = topp.getNeste();

		return resultat;
	}

	@Override
	public T peek() {
		if (erTom())
			throw new EmptyCollectionException("stabel");

		return topp.getElement();
	}

	@Override
	public boolean erTom() {
		return (topp == null);
	}
	
	@Override
	public boolean erBalansert(String s) {
        KjedetStabel<Character> stabel = new KjedetStabel<>();
        char[] chars = s.toCharArray();

        int errors = 0;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (erVenstreparentes(c)) {
                stabel.push(c);
            } else if (erHogreparentes(c)) {
            	if (stabel.erTom()) {
            		System.out.println("Ingen matchende åpnende paranteser");
            		errors++;
            	} else if (!erPar(stabel.peek(), c)) {
                    System.out.println(" plass " + i + ", ikke matchende parantes."+"\n" + "fikk:" + stabel.peek());
	                errors++;
                } else {
                	stabel.pop();
                }
            }
        }

        if (!stabel.erTom( )) {
        	System.out.println("Ingen matchende Lukkende paranteser");
        	errors++;
        }
        
        return errors == 0;
    }
	 

}