
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.DecimalFormat;

import org.junit.Test;

import projet.Addition;
import projet.ConstEntiere;
import projet.ConstRationnelle;
import projet.Pi;
import projet.Polynome;
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


	}

	@Test
	public void question_1_2_3() {

		// Réels
		ExpressionArithmetique zero = new ConstEntiere(0);
		ExpressionArithmetique un = new ConstEntiere(1);
		ExpressionArithmetique neuf = new ConstEntiere(9);
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);

		// Rationnelles
		ExpressionArithmetique cr = new ConstRationnelle(1, 17);

		// Variable Symbolique
		ExpressionArithmetique vs = new VarSymbolique("x");
		ExpressionArithmetique cosVs = new Cos(vs);
		ExpressionArithmetique sinVs = new Sin(vs);
		
		assertEquals("x", ((VarSymbolique) vs.simplifier()).getVariable());assertEquals("x", ((VarSymbolique) vs.simplifier()).getVariable());

		// Opération de base
		ExpressionArithmetique plus = new Addition(neuf, deux);
		ExpressionArithmetique minus = new Soustraction(trois, cr);
		ExpressionArithmetique times = new Multiplication(plus, minus);
		//assertEquals(550 / 17.0, times.calculer(), 0.00001);
		//assertEquals(550 / 17.0, times.calculer(), 0.00001);

		assertEquals(550, ((ConstRationnelle) times.simplifier()).getNumerateur());
		assertEquals(17, ((ConstRationnelle) times.simplifier()).getDenominateur());

		// Racine carré de 4
		ExpressionArithmetique quatre = new ConstEntiere(4);
		ExpressionArithmetique testRaC = new RacineCarre(quatre);
		assertEquals(2.0, testRaC.calculer(), 1);


		// Cosinus & Sinus
		ExpressionArithmetique cosinus = new Cos(cr);
		ExpressionArithmetique sinus = new Sin(deux);
		// assertEquals(-0.9899924966004454, cosinus.calculer(), 0.0001);
		assertEquals(0.9092974268256817, sinus.calculer(), 0.0001);

	
		// ln
		ExpressionArithmetique ln2 = new Ln(deux);
		ExpressionArithmetique ln0 = new Ln(zero);

		assertEquals(0.69314718056, ln2.calculer(), 0.0001);

		// Puissance
		ExpressionArithmetique testp = new Puissance(deux, trois);

		assertEquals(8, ((ConstEntiere) testp.simplifier()).getEntier());

		assertEquals(550, ((ConstRationnelle) times.simplifier()).getNumerateur());
		assertEquals(17, ((ConstRationnelle) times.simplifier()).getDenominateur());
		
	}
	
	@Test
	public void question_4() {
		
		ExpressionArithmetique un = new ConstEntiere(1);
		ExpressionArithmetique pi = new Pi("pi");
		ExpressionArithmetique e = new Exponentielle(un);
			
		assertEquals(3.141592654, pi.calculer(), 0.0001);
		assertEquals(2.718, e.calculer(), 0.001);
	
		
	}
	
	
	@Test
	public void question_6() {
		// test 1 + pi
		
		ExpressionArithmetique un = new ConstEntiere(1);
		ExpressionArithmetique pi = new Pi("pi");
		ExpressionArithmetique piplusun = new Addition(pi, un);
		ExpressionArithmetique cr1 = new ConstRationnelle(3, 4);
		ExpressionArithmetique add1 = new Addition(cr1,un);
		
		assertEquals(1.7500, add1.calculer(), 0.0001);
		assertEquals(4.1416, piplusun.calculer(), 0.0001);
		
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
		ExpressionArithmetique pi = new Pi("pi");

		ExpressionArithmetique division = new Division(pi, trois);

	
	}

	@Test
	public void question_7() {
		//TEST ADDITION 
		ExpressionArithmetique un = new ConstEntiere(1);
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		
		ExpressionArithmetique add = new Addition(deux,trois);
		ExpressionArithmetique add2 = new Addition(deux,trois);	
		ExpressionArithmetique add3 = new Addition(deux,deux);	
		
		assertEquals(true, add.equals(add2));
		assertEquals(false, add.equals(add3));
		
		//TEST CR 
		ExpressionArithmetique cr1 = new ConstRationnelle(1,2);	
		ExpressionArithmetique cr2 = new ConstRationnelle(1,2);	
		ExpressionArithmetique cr3 = new ConstRationnelle(1,4);	
		
		assertEquals(true, cr1.equals(cr2));
		assertEquals(false, cr1.equals(cr3));
		
		//TEST DIVISION 
		ExpressionArithmetique div1 = new Division(un,deux);
		ExpressionArithmetique div2 = new Division(un,deux);
		ExpressionArithmetique div3 = new Division(un,trois);
		
		assertEquals(true, div1.equals(div2));
		assertEquals(true, div1.simplifier().equals(div2.simplifier()));
		assertEquals(false, div1.equals(div3));
		
		//TEST COS 
		ExpressionArithmetique cos1 = new Cos(un);
		ExpressionArithmetique cos2 = new Cos(un);
		ExpressionArithmetique cos3 = new Cos(deux);
		assertEquals(true, cos1.equals(cos2));
		assertEquals(false, cos1.equals(cos3));
		
		//TEST EXPONENTIELLE
		ExpressionArithmetique exp1 = new Exponentielle(un);
		ExpressionArithmetique exp2 = new Exponentielle(un);
		ExpressionArithmetique exp3 = new Exponentielle(trois);
		assertEquals(true, exp1.equals(exp2));
		assertEquals(false, exp1.equals(exp3));
		
		//TEST LN 
		ExpressionArithmetique ln1 = new Ln(un);
		ExpressionArithmetique ln2 = new Ln(un);
		ExpressionArithmetique ln3 = new Ln(trois);
		assertEquals(true, ln1.equals(ln2));
		assertEquals(false, ln1.equals(ln3));
		
		//TEST MULTIPLICATION 
		ExpressionArithmetique mult1 = new Multiplication(un,deux);
		ExpressionArithmetique mult2 = new Multiplication(un,deux);
		ExpressionArithmetique mult3 = new Multiplication(un,trois);
		assertEquals(true, mult1.equals(mult2));
		assertEquals(false, mult1.equals(mult3));
		
		
		//TEST PI 
		ExpressionArithmetique pi1 = new Pi("pi");
		ExpressionArithmetique pi2 = new Pi("pi");
		assertEquals(true, pi1.equals(pi2));
		
		//TEST POLY
		ExpressionArithmetique poly1 = new Polynome(mult1,mult2);
		ExpressionArithmetique poly2 = new Polynome(mult1,mult2);
		ExpressionArithmetique poly3 = new Polynome(mult1,mult3);
		assertEquals(true, poly1.equals(poly2));
		assertEquals(false, poly1.equals(poly3));
		
		//TEST PUISSANCE 
		ExpressionArithmetique p1 = new Puissance(un,deux);
		ExpressionArithmetique p2 = new Puissance(un,deux);
		ExpressionArithmetique p3 = new Puissance(un,trois);
		assertEquals(true, p1.equals(p2));
		assertEquals(false, p1.equals(p3));
		
		//TEST RACINE CARRE
		ExpressionArithmetique rc1 = new RacineCarre(un);
		ExpressionArithmetique rc2 = new RacineCarre(un);
		ExpressionArithmetique rc3 = new RacineCarre(trois);
		assertEquals(true, rc1.equals(rc2));
		assertEquals(false, rc1.equals(rc3));
		
		//TEST SINUS
		ExpressionArithmetique sin1 = new Sin(un);
		ExpressionArithmetique sin2 = new Sin(un);
		ExpressionArithmetique sin3 = new Sin(trois);
		assertEquals(true, sin1.equals(sin2));
		assertEquals(false, sin1.equals(sin3));
		
		//TEST SOUSTRACTION
		ExpressionArithmetique s1 = new Soustraction(deux,un);
		ExpressionArithmetique s2 = new Soustraction(deux,un);
		ExpressionArithmetique s3 = new Soustraction(trois,un);
		assertEquals(true, s1.equals(s2));
		assertEquals(false, s1.equals(s3));
		
		//TEST VARSYMBO
		ExpressionArithmetique vs1 = new VarSymbolique("x");
		ExpressionArithmetique vs2 = new VarSymbolique("x");
		ExpressionArithmetique vs3 = new VarSymbolique("y");
		assertEquals(true, vs1.equals(vs2));
		assertEquals(false, vs1.equals(vs3));
		
		
	}
	

	@Test
	public void question_9() {
		ExpressionArithmetique vs = new VarSymbolique("x");
		
		
	}
	
	
	
	
	@Test
	public void question_13_14() {

		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique trois = new ConstEntiere(3);
		ExpressionArithmetique cinq = new ConstEntiere(5);
		ExpressionArithmetique dix = new ConstEntiere(10);
		ExpressionArithmetique quatre = new ConstEntiere(4);

		ExpressionArithmetique vs = new VarSymbolique("x");

		ExpressionArithmetique puissance = new Puissance(vs, deux);
		ExpressionArithmetique multiplication = new Multiplication(trois, puissance);

		ExpressionArithmetique puissance3 = new Puissance(vs, trois);
		ExpressionArithmetique puissance2 = new Puissance(vs, quatre);

		ExpressionArithmetique cinqx = new Multiplication(cinq, vs);

		Multiplication nombre1 = new Multiplication(cinq, puissance2);

		Multiplication nombre2 = new Multiplication(quatre, puissance3);
		Multiplication nombre3 = new Multiplication(trois, puissance);


		Polynome poly1 = new Polynome(nombre1, nombre2, nombre3, cinqx, dix);
		//assertEquals()
		System.out.println((poly1.derivation(3).afficher()));
	}
	
	

	@Test
	public void question_15() {
		ExpressionArithmetique x = new VarSymbolique("x");
		ExpressionArithmetique zero = new ConstEntiere(0);
		ExpressionArithmetique un = new ConstEntiere(1);

		// Addition x+0
		ExpressionArithmetique elt = new Addition(x, zero);
		ExpressionArithmetique add = new Addition(zero, x);
		assertEquals("x", (elt.simplifier().afficher()));

		// Soustraction x-0
		ExpressionArithmetique elt1 = new Soustraction(x, zero);
		assertEquals("x", (elt1.simplifier().afficher()));

		// Multiplication x*1
		ExpressionArithmetique elt2 = new Multiplication(x, un);
		assertEquals("x", (elt2.simplifier().afficher()));

		// Division x/1
		ExpressionArithmetique elt3 = new Division(x, un);
		assertEquals("x", (elt3.simplifier().afficher()));

		// Puissance x^0=1 et x^1=x
		ExpressionArithmetique elt4 = new Puissance(x, un);
		ExpressionArithmetique elt5 = new Puissance(x, zero);
		assertEquals("x", (elt4.simplifier().afficher()));
		assertEquals("1", (elt5.simplifier().afficher()));

	}

	@Test
	public void question_16() {

		ExpressionArithmetique x = new VarSymbolique("x");
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique undemi = new ConstRationnelle(1, 2);

		ExpressionArithmetique add = new Addition(x, undemi);
		ExpressionArithmetique multi = new Multiplication(deux, add);

		assertEquals("(2x+1)", multi.simplifier().afficher());

		ExpressionArithmetique sous = new Soustraction(x, undemi);
		ExpressionArithmetique multi2 = new Multiplication(deux, sous);

		assertEquals("(2x-1)", multi2.simplifier().afficher());

	}
	
	@Test
	public void question_17() {
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique un = new ConstEntiere(1);
		ExpressionArithmetique neuf = new ConstEntiere(9);
		
		ExpressionArithmetique x = new VarSymbolique("x");
        ExpressionArithmetique unplusx = new Addition(un, x);
        ExpressionArithmetique unplusunplusx = new Addition(un, unplusx);
        ExpressionArithmetique test = new Addition(neuf, neuf);

        ExpressionArithmetique undemi = new ConstRationnelle(1,2);
        ExpressionArithmetique undemix = new Multiplication(undemi,x);
        ExpressionArithmetique mult = new Multiplication(deux,undemix);

		
		
	}
	
	
	
	@Test
	public void question_10() {
		
		//LN(1) + 1
		ExpressionArithmetique un = new ConstEntiere(1);
		ExpressionArithmetique zero = new ConstEntiere(0);
		ExpressionArithmetique quatre = new ConstEntiere(4);
		ExpressionArithmetique ln1 = new Ln(un);
		ExpressionArithmetique add1 = new Addition(un,ln1);
		assertEquals("1",add1.simplifier().afficher());
		
		
		//EXPO
		ExpressionArithmetique expo1 = new Exponentielle(zero);
		ExpressionArithmetique add2 = new Addition(expo1,un);
		
		
		
		//RACINE CARRE
		ExpressionArithmetique rc1 = new RacineCarre(quatre);
		assertEquals("2",rc1.simplifier().afficher());
		
		//DIVISION
		ExpressionArithmetique pi = new Pi("pi");
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique div1 = new Division(pi,deux);
		ExpressionArithmetique sin1 = new Sin(div1);
		ExpressionArithmetique add3 = new Addition(sin1,un);
		assertEquals("2",add3.simplifier().afficher());
		
		
	}
	
	
	@Test
	public void question_19() {
		//3x^2
		ExpressionArithmetique trois = new ConstEntiere(3);
		ExpressionArithmetique deux = new ConstEntiere(2);
		ExpressionArithmetique vs = new VarSymbolique("x");
		ExpressionArithmetique p1 = new Puissance(vs,deux);
		ExpressionArithmetique mult1 = new Multiplication(trois,p1);
		//5x
		ExpressionArithmetique cinq = new ConstEntiere(5);
		ExpressionArithmetique mult2 = new Multiplication(cinq,vs);
		//10
		ExpressionArithmetique dix = new ConstEntiere(10);
		
		//test 
		
		Polynome poly1 = new Polynome(mult1, mult2, dix);
		//System.out.println((poly1.derivation(0)));
		
		System.out.println((poly1.primitiver(1).afficher()));
		
	}

	
	
	
	

}
