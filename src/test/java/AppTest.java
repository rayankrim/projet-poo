
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import projet.Addition;
import projet.ConstEntiere;
import projet.ConstRationnelle;
import projet.ConstanteSymbolique;
import projet.Cos;
import projet.Division;
import projet.ExpressionArithmetique;
import projet.Ln;
import projet.Multiplication;
import projet.Puissance;
import projet.Sin;
import projet.Soustraction;
import projet.VarSymbolique;
import projet.RacineCarre;

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

		// Réels
		ExpressionArithmetique zero = new ConstEntiere(0);
		ExpressionArithmetique neuf = new ConstEntiere(9);
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);

		// Rationnelles
		ExpressionArithmetique cr = new ConstRationnelle(1, 17);

		// Variable Symbolique
		ExpressionArithmetique vs = new VarSymbolique("x");
		assertEquals("x", ((VarSymbolique) vs.simplifier()).getVariable());

		// Opération de base
		ExpressionArithmetique plus = new Addition(neuf, deux);
		ExpressionArithmetique minus = new Soustraction(trois, cr);
		ExpressionArithmetique times = new Multiplication(plus, minus);
		// assertEquals(550 / 17.0, times.calculer(), 0.00001);

		// Racine carré de 4
		ExpressionArithmetique quatre = new ConstEntiere(4);
		ExpressionArithmetique testRaC = new RacineCarre(quatre);
		assertEquals(2.0, testRaC.calculer(), 1);

		System.out.println("RacineCarre de 4 = " + testRaC.calculer());

		// Cosinus & Sinus
		ExpressionArithmetique cosinus = new Cos(cr);
		ExpressionArithmetique sinus = new Sin(deux);
		// assertEquals(-0.9899924966004454, cosinus.calculer(), 0.0001);
		assertEquals(0.9092974268256817, sinus.calculer(), 0.0001);
		System.out.println("cos(1/17) = " + cosinus.calculer());

		// ln
		ExpressionArithmetique ln2 = new Ln(deux);
		ExpressionArithmetique ln0 = new Ln(zero);

		assertEquals(0.69314718056, ln2.calculer(), 0.0001);

		// Puissance
		ExpressionArithmetique testp = new Puissance(deux, trois);

		assertEquals(8, ((ConstEntiere) testp.simplifier()).getEntier());

		// 1+sin(pi/2)
		ExpressionArithmetique pi = new ConstanteSymbolique("pi");
		ExpressionArithmetique un = new ConstEntiere(1);
		ExpressionArithmetique div = new Division(pi, deux);
		ExpressionArithmetique testsin = new Sin(div);
		ExpressionArithmetique testadd = new Addition(un, testsin);
		assertEquals(2.0, testadd.calculer(), 1);

		// test 1 + ln(1)
		ExpressionArithmetique ln1 = new Ln(un);
		ExpressionArithmetique additionlnEtUn = new Addition(un, ln1);
		assertEquals(1.0, additionlnEtUn.calculer(), 1);
		System.out.println("ln(1) = " + additionlnEtUn.calculer());

		// x*1
		ExpressionArithmetique UnX = new Multiplication(un, vs);
		// System.out.println("1*x = "+ UnX.calculer());

		// afficher une expression arithmetique
		System.out.println(testadd.afficher());

		// test 1 + e^0

		// premier test, je dois faire l'exponentielle first

		/*
		 * ExpressionArithmetique expo = new Exponentielle(un);
		 * System.out.println(expo.calculer());
		 * 
		 * // puis l'addition :)
		 * 
		 * ExpressionArithmetique expoAndOne = new Addition(un, expo);
		 * System.out.println(expoAndOne.calculer());
		 */

		/*
		 * VarSymbolique vr = new VarSymbolique('x'); vr.setValeur(new ConstEntiere(9));
		 * // x = 9 VarSymbolique oui = (VaSymbolique)vr.simplifier();
		 * System.out.println(oui.getVariable());
		 */
	}

	@Test
	public void exempleCalculer() {

		ExpressionArithmetique neuf = new ConstEntiere(9);
		ExpressionArithmetique six = new ConstEntiere(6);
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		ExpressionArithmetique cr = new ConstRationnelle(1, 17);
		ExpressionArithmetique plus = new Addition(neuf, deux);
		ExpressionArithmetique un = new ConstEntiere(1);

		ExpressionArithmetique minus = new Soustraction(trois, cr);

		ExpressionArithmetique times = new Multiplication(plus, minus);

		ExpressionArithmetique results = new ConstRationnelle(550, 17);

		ExpressionArithmetique divide = new Division(six, cr);
		ExpressionArithmetique pi = new ConstanteSymbolique("pi");

		ExpressionArithmetique division = new Division(pi, trois);

		// element neutre
		ExpressionArithmetique neutreDiv = new Division(trois, un);
		ExpressionArithmetique neutreMul = new Multiplication(trois, un);
		ExpressionArithmetique neutreAdd = new Addition(trois, un);
		ExpressionArithmetique neutreSous = new Soustraction(trois, un);

		assertEquals(3.0, neutreDiv.calculer(), 1);
		assertEquals(3.0, neutreAdd.calculer(), 1);
		assertEquals(3.0, neutreMul.calculer(), 1);
		assertEquals(3.0, neutreSous.calculer(), 1);
		// egaliteAr

		ExpressionArithmetique expression1 = plus;
		ExpressionArithmetique expression2 = minus;

		assertEquals(false, expression1.egaliteAr(expression2));

		// System.out.println(division.calculer());

	}
}
