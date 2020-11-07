
import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.junit.Test;

import projet.Addition;
import projet.ConstEntiere;
import projet.ConstRationnelle;
import projet.Pi;
import projet.Cos;
import projet.Division;
import projet.Exponentielle;
import projet.ExpressionArithmetique;
import projet.Ln;
import projet.Multiplication;
import projet.Puissance;
import projet.Sin;
import projet.Soustraction;
import projet.VarSymbolique;

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
		ExpressionArithmetique vs = new VarSymbolique('x');
		assertEquals('x', ((VarSymbolique) vs.simplifier()).getVariable());

		// Opération de base
		ExpressionArithmetique plus = new Addition(neuf, deux);
		ExpressionArithmetique minus = new Soustraction(trois, cr);
		ExpressionArithmetique times = new Multiplication(plus, minus);
		// assertEquals(550 / 17.0, times.calculer(), 0.00001);

		// Racine carré

		// Cosinus & Sinus
		ExpressionArithmetique cosinus = new Cos(cr);
		ExpressionArithmetique sinus = new Sin(deux);
		// assertEquals(-0.9899924966004454, cosinus.calculer(), 0.0001);
		assertEquals(0.9092974268256817, sinus.calculer(), 0.0001);
		System.out.println(cr.calculer());
		System.out.println(cosinus.calculer());

		// ln
		ExpressionArithmetique ln2 = new Ln(deux);
		ExpressionArithmetique ln0 = new Ln(zero);

		assertEquals(0.69314718056, ln2.calculer(), 0.0001);

		// Puissance
		ExpressionArithmetique testp = new Puissance(deux, trois);

		assertEquals(8, ((ConstEntiere) testp.simplifier()).getEntier());

		// Constante Symbolique Pi
		ExpressionArithmetique pi = new Pi("pi");

		assertEquals(550, ((ConstRationnelle) times.simplifier()).getNumerateur());
		assertEquals(17, ((ConstRationnelle) times.simplifier()).getDenominateur());

		// test 1 + pi

		ExpressionArithmetique piAddition = new Pi("pi");
		ExpressionArithmetique un = new ConstEntiere(1);

		ExpressionArithmetique additionPietUn = new Addition(piAddition, un);

		// double approximation = Math.round(additionPietUn.calculer() * 10000);
		// approximation = approximation / 10000;

		assertEquals(4.1416, additionPietUn.calculer(), 0.0001);

		System.out.println("Pi + 1 = " + additionPietUn.calculer());

		// test constRationelle + 1

		ExpressionArithmetique crTest = new ConstRationnelle(3, 54);

		ExpressionArithmetique additionCRetUn = new Addition(crTest, un);

		assertEquals(1.055555555555556, additionCRetUn.calculer(), 0.0001);

		System.out.println("test constRationelle + 1" + additionCRetUn.calculer());

		// test 1 + ln(1)

		ExpressionArithmetique ln1 = new Ln(un);
		ExpressionArithmetique additionlnEtUn = new Addition(un, ln1);

		System.out.println("Ln +  1 = " + additionlnEtUn.calculer());

		// test 1 + e^0

		// premier test, je dois faire l'exponentielle first
		ExpressionArithmetique expo = new Exponentielle(un);
		System.out.println("Valeur de expo^1 : " + expo.calculer());

		// puis l'addition :)

		ExpressionArithmetique expoAndOne = new Addition(un, expo);
		System.out.println("Expo 0  + 1" + expoAndOne.calculer());

		// test : 1 + Sin(pi/2)

		ExpressionArithmetique PiParDeux = new Division(pi, deux);
		System.out.println("test pi/2  " + PiParDeux.calculer());
		ExpressionArithmetique SinOfPiParDeux = new Sin(PiParDeux);
		System.out.println("test : Sin(pi/2)  " + SinOfPiParDeux.calculer());
		ExpressionArithmetique UnPlusSinOfPiParDeux = new Addition(un, SinOfPiParDeux);
		System.out.println("test : 1 + Sin(pi/2)  " + UnPlusSinOfPiParDeux.calculer());

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

		ExpressionArithmetique divide = new Division(six, cr);

		// egaliteAr A refaire :)

		ExpressionArithmetique plus2 = new Addition(neuf, deux);

		ExpressionArithmetique expression1 = plus;
		ExpressionArithmetique expression2 = plus2;

		assertEquals(false, expression1.egaliteAr(expression2));

		// System.out.println(divide.calculer());

	}
}
