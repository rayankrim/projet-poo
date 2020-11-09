
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
import projet.VarSymboliqueException;

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
	public void classExample() throws VarSymboliqueException {

		// Réels
		ExpressionArithmetique zero = new ConstEntiere(0);
		ExpressionArithmetique neuf = new ConstEntiere(9);
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		
		// Rationnelles
		ExpressionArithmetique cr = new ConstRationnelle(1, 17);

		// Variable Symbolique
		ExpressionArithmetique vs = new VarSymbolique("x");
		ExpressionArithmetique cosVs = new Cos(vs);
		ExpressionArithmetique sinVs = new Sin(vs);
		
		try {
			sinVs.calculer();
			//problème
			fail("cette ligne ne devrait pas être exécutée");
			}
			catch(VarSymboliqueException e) {
			//pas problème
				//une erreur a bien été envoyée
				System.out.println("L'Exception a bien été effectué ");
			}
		
		
		//assertEquals("x", ((VarSymbolique) vs.simplifier()).getVariable());
		
		

		// Opération de base
		ExpressionArithmetique plus = new Addition(neuf, deux);
		ExpressionArithmetique minus = new Soustraction(trois, cr);
		ExpressionArithmetique times = new Multiplication(plus, minus);
	
		assertEquals(550 / 17.0, times.calculer(), 0.00001);
		
		assertEquals(550, ((ConstRationnelle) times.simplifier()).getNumerateur());
		assertEquals(17, ((ConstRationnelle) times.simplifier()).getDenominateur());
		

		// Racine carré

		// Cosinus & Sinus
		ExpressionArithmetique cosinus = new Cos(cr);
		ExpressionArithmetique sinus = new Sin(deux);
		
		
		//assertEquals(-0.9899924966004454, cosinus.calculer(), 0.0001);
		assertEquals(0.9092974268256817, sinus.calculer(), 0.0001);
		//System.out.println(cr.calculer());
		//System.out.println(cosinus.calculer());
		
		//ln
		ExpressionArithmetique ln2 = new Ln(deux);
		ExpressionArithmetique ln0 = new Ln(zero);

		assertEquals(0.69314718056, ln2.calculer(), 0.0001);

		

		// Puissance
		ExpressionArithmetique testp = new Puissance(deux, trois);

		assertEquals(8, ((ConstEntiere) testp.simplifier()).getEntier());

		
	
		// Constante Symbolique
		ExpressionArithmetique pi = new ConstanteSymbolique("pi");
		ExpressionArithmetique e = new ConstanteSymbolique("e");
		
		ExpressionArithmetique cosinusExpo = new Cos(e);
		ExpressionArithmetique cosinusPi = new Cos(pi);
		
		assertEquals(3.14,pi.calculer(),0.01);
		
		
		

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

		// egaliteAr

		ExpressionArithmetique expression1 = plus;
		ExpressionArithmetique expression2 = minus;

	
		assertEquals(false, expression1.egaliteAr(expression2));

		// System.out.println(divide.calculer());

		
	}
}
