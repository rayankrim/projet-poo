package poo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import td3.Addition;
import td3.ConstEntiere;
import td3.ConstRationnelle;
import td3.ConstanteSymbolique;
import td3.Cos;
import td3.Division;
import td3.ExpressionArithmetique;
import td3.Ln;
import td3.Multiplication;
import td3.Sin;
import td3.Soustraction;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void simpleSum() {

		ConstEntiere neuf = new ConstEntiere(9);
		ConstEntiere deux = new ConstEntiere(2);
		Addition racine = new Addition(neuf, deux);

		assertEquals(11, ((ConstEntiere) racine.simplifier()).getEntier());

	}

	@Test
	public void classExample() {

		ExpressionArithmetique neuf = new ConstEntiere(9);
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		ExpressionArithmetique cr = new ConstRationnelle(1, 17);

		ExpressionArithmetique plus = new Addition(neuf, deux);
		ExpressionArithmetique minus = new Soustraction(trois, cr);
		ExpressionArithmetique times = new Multiplication(plus, minus);
		
		ExpressionArithmetique pi = new ConstanteSymbolique("e");
		
		ExpressionArithmetique cosinus = new Cos(trois);
		ExpressionArithmetique sinus = new Sin(deux);
	   
	    ExpressionArithmetique ln = new Ln(deux);
	    
	    System.out.println(ln.calculer());
	    
	    assertEquals(-0.9899924966004454, cosinus.calculer(),0.0001);
	    assertEquals(0.9092974268256817, sinus.calculer(),0.0001);
	    
		assertEquals(550, ((ConstRationnelle) times.simplifier()).getNumerateur());
		assertEquals(17, ((ConstRationnelle) times.simplifier()).getDenominateur());

	}
	
	@Test
	public void exempleCalculer() {

		ExpressionArithmetique neuf = new ConstEntiere(9);
		ExpressionArithmetique six = new ConstEntiere(6);
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		ExpressionArithmetique cr = new ConstRationnelle(1, 17);
		ExpressionArithmetique plus = new Addition(neuf, deux);
		
		
		ExpressionArithmetique minus = new Soustraction(trois, cr);
		
		ExpressionArithmetique times = new Multiplication(plus, minus);

		ExpressionArithmetique results = new ConstRationnelle(550, 17);
		
		ExpressionArithmetique divide = new Division(six,cr);
		
		//System.out.println(divide.calculer());
		
		assertEquals(550/17.0, times.calculer(),0.00001);

	}
}
