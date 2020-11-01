package poo;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import td3.Addition;
import td3.ConstEntiere;
import td3.ConstRationnelle;
import td3.ExpressionArithmetique;
import td3.Multiplication;
import td3.Soustraction;
import td3.VarSymbolique;
import td3.Puissance;
/**
 * Unit test for simple App.
 */
public class AppTest {

	/*@Test
	public void simpleSum() {

		ConstEntiere neuf = new ConstEntiere(9);
		ConstEntiere deux = new ConstEntiere(2);
		Addition racine = new Addition(neuf, deux);

		assertEquals(11, ((ConstEntiere) racine.simplifier()).getEntier());

	}*/

	@Test
	public void classExample() {

		ExpressionArithmetique neuf = new ConstEntiere(9);
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		ExpressionArithmetique cr = new ConstRationnelle(4, 8);
		ExpressionArithmetique vs = new VarSymbolique('x');


		ExpressionArithmetique plus = new Addition(neuf, deux);
		ExpressionArithmetique minus = new Soustraction(trois, cr);
		ExpressionArithmetique times = new Multiplication(plus, minus);
		ExpressionArithmetique testp = new Puissance(deux, trois);
		ExpressionArithmetique pui = new Puissance(cr, deux);
		ExpressionArithmetique expoCR = new Puissance(deux, cr);
		
		
		

		//assertEquals(550, ((ConstRationnelle) times.simplifier()).getNumerateur());
		//assertEquals(17, ((ConstRationnelle) times.simplifier()).getDenominateur());
		assertEquals('x',((VarSymbolique) vs.simplifier()).getVariable());
		assertEquals(8,((ConstEntiere) testp.simplifier()).getEntier());
		assertEquals(1,((ConstRationnelle) pui.simplifier()).getNumerateur());
		assertEquals(4,((ConstRationnelle) pui.simplifier()).getDenominateur());
		//assertEquals((int)1.4142,((ConstEntiere) expoCR.simplifier()).getEntier());
		System.out.println(expoCR.calculer());
		int a =(int) 1.4142;
		System.out.println(a);
		

	}
	
	@Test
	public void exempleCalculer() {

		ExpressionArithmetique neuf = new ConstEntiere(9);
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		ExpressionArithmetique cr = new ConstRationnelle(1, 17);

		ExpressionArithmetique plus = new Addition(neuf, deux);
		ExpressionArithmetique minus = new Soustraction(trois, cr);
		ExpressionArithmetique times = new Multiplication(plus, minus);
		ExpressionArithmetique puis = new Puissance(deux, trois);

		//ExpressionArithmetique results = new ConstRationnelle(550, 17);

		
		//assertEquals(550/17.0, times.calculer(),0.00001);
		assertEquals(8, puis.calculer(),0.00001);

	}
}
