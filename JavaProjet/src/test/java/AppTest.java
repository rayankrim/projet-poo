
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

/**
 * Unit test for simple App.
 */
public class AppTest {

	// pour la question 9: bien ? mauvais ?
	/*	@Test
		public void afficherEa() {
			ExpressionArithmetique ea= new VarSymbolique('z');
			System.out.println(ea);
		}
		*/
		// question 8: calcul d'une EA avec des Varsymbolique dont on connait la valeur.
		@Test
		public void question_7() {
			
			ExpressionArithmetique un = new ConstEntiere(1);
			ExpressionArithmetique deux = new ConstEntiere(2);
			ExpressionArithmetique x = new VarSymbolique('x');
			ExpressionArithmetique y = new VarSymbolique('y');
			ConstEntiere Un= (ConstEntiere) un;
			VarSymbolique X = (VarSymbolique) x;
			X.modifierVariable(Un.getEntier());
			VarSymbolique Y = (VarSymbolique) y;
			Y.modifierVariable(Un.getEntier());
			
			ExpressionArithmetique noeud1 = new Addition(Y,un);
			ExpressionArithmetique noeud2 = new Division(X,noeud1);
			ExpressionArithmetique noeud3 = new Addition(un,noeud2);
			
			assertEquals(3,((ConstRationnelle) noeud3.simplifier()).getNumerateur());
			assertEquals(2,((ConstRationnelle) noeud3.simplifier()).getDenominateur());
		}
/*	
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
		assertEquals(550 / 17.0, times.calculer(), 0.00001);

		// Racine carré

		// Cosinus & Sinus
		ExpressionArithmetique cosinus = new Cos(cr);
		ExpressionArithmetique sinus = new Sin(deux);
		//assertEquals(-0.9899924966004454, cosinus.calculer(), 0.0001);
		assertEquals(0.9092974268256817, sinus.calculer(), 0.0001);
		System.out.println(cr.calculer());
		System.out.println(cosinus.calculer());
		
		//ln
		ExpressionArithmetique ln2 = new Ln(deux);
		ExpressionArithmetique ln0 = new Ln(zero);

		assertEquals(0.69314718056, ln2.calculer(), 0.0001);

		

		// Puissance
		ExpressionArithmetique testp = new Puissance(deux, trois);

		assertEquals(8, ((ConstEntiere) testp.simplifier()).getEntier());

		
		
		// Constante Symbolique
		ExpressionArithmetique pi = new ConstanteSymbolique("e");

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

		ExpressionArithmetique divide = new Division(six, cr);

		// egaliteAr

		ExpressionArithmetique expression1 = plus;
		ExpressionArithmetique expression2 = minus;

	
		assertEquals(false, expression1.egaliteAr(expression2));

		// System.out.println(divide.calculer());

		
	}*/
}
