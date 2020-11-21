import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import projet.Addition;
import projet.ConstEntiere;
import projet.ConstRationnelle;
import projet.ConstanteSymbolique;
import projet.Cos;
import projet.Division;
import projet.ExpressionArithmetique;
import projet.Indice;
import projet.Ln;
import projet.Multiplication;
import projet.OperationBinaire;
import projet.Produit;
import projet.Puissance;
import projet.Sin;
import projet.Somme;
import projet.Soustraction;
import projet.VarSymbolique;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void produitQuestion12() {
		ExpressionArithmetique alpha = new VarSymbolique("alpha");
		ExpressionArithmetique x = new VarSymbolique("x");
		ExpressionArithmetique i = new VarSymbolique("i");
		ExpressionArithmetique alphaI= new Indice(alpha,i);
		ExpressionArithmetique xI = new Puissance(x,i);
		ExpressionArithmetique Max= new ConstEntiere(4);

		ConstEntiere max = (ConstEntiere) Max;
		
		ExpressionArithmetique prodAlphaI= new Produit(alphaI, max);
		ExpressionArithmetique prodXI= new Produit(xI, max);
		ExpressionArithmetique exceptResult= new Multiplication(prodAlphaI,prodXI);
		
		ExpressionArithmetique multi= new Multiplication(alphaI,xI);
		ExpressionArithmetique testResult= new Produit(multi,max);
		
		String eResult=exceptResult.simplifier().afficher();
		assertEquals(eResult,testResult.simplifier().afficher());
	}
	//alpha(0)*alpha(1)*alpha(2)*alpha(3)*alpha(4)*x^10
/*	@Test
	public void sommeQuestion11V2() {
		ExpressionArithmetique alpha = new VarSymbolique("alpha");
		ExpressionArithmetique x = new VarSymbolique("x");
		ExpressionArithmetique i = new VarSymbolique("i");
		ExpressionArithmetique alphaI= new Indice(alpha,i);
		ExpressionArithmetique xI = new Puissance(x,i);
		ExpressionArithmetique Max= new ConstEntiere(4);

		ConstEntiere max = (ConstEntiere) Max;
		
		ExpressionArithmetique multi= new Multiplication(alphaI,xI);
		ExpressionArithmetique sum= new Somme(multi,max);
		
		String sum2="alpha(0)*x^0+alpha(1)*x^1+alpha(2)*x^2+alpha(3)*x^3+alpha(4)*x^4";
		assertEquals(sum2,sum.simplifier().afficher());
	}
*/	
	
	
/*	@Test
	public void question_12V3() {
		ExpressionArithmetique alpha = new VarSymbolique("alpha");
		ExpressionArithmetique x= new VarSymbolique("x");
		ExpressionArithmetique debut= new ConstEntiere(0);
		ExpressionArithmetique fin= new ConstEntiere(4);

		System.out.println(Arrays.toString(somme));
		
			
		ExpressionArithmetique i= new VarSymbolique("i");
		ExpressionArithmetique i2= new VarSymbolique("i");
		
		ConstEntiere d=(ConstEntiere) deb;
		ConstEntiere f=(ConstEntiere) fin;
		VarSymbolique I=(VarSymbolique) i;
		VarSymbolique I2=(VarSymbolique) i2;
		String Somme=new String();
		int compteurPuissance=0;
		
		for(int j=d.getEntier();j<=f.getEntier();j+=2) {
			I.setValue(j);
			ExpressionArithmetique indice= new Indice(alpha,I);

			if(j!=f.getEntier()) {
				I2.setValue(j+1);
				ExpressionArithmetique indiceSuivant= new Indice(alpha,I2);
				ExpressionArithmetique produit=new Multiplication(indice,indiceSuivant);
				Somme+=produit.afficher()+"*";
				compteurPuissance+=(I.getValue()+I2.getValue());
			} else {
				Somme+=indice.afficher();
				compteurPuissance+=I.getValue();
			}
		}
		

		I.setValue(compteurPuissance);
		ExpressionArithmetique puissance= new Puissance(x,I);
		Somme+="*"+puissance.afficher();
		
		
	//	assertEquals("alpha(0)*alpha(1)*alpha(2)*alpha(3)*alpha(4)*x^10",somme);
	}
*/
	
/*	// question 8: calcul d'une EA avec des Varsymbolique dont on connait la valeur.
	@Test
	public void question_8() {
		
		ExpressionArithmetique un = new ConstEntiere(1);
		ExpressionArithmetique x = new VarSymbolique("x");
		ExpressionArithmetique y = new VarSymbolique("y");
		
		ConstEntiere Un= (ConstEntiere) un;
		VarSymbolique X = (VarSymbolique) x;
		VarSymbolique Y = (VarSymbolique) y;
		X.setValue(Un.getEntier());
		Y.setValue(Un.getEntier());
		
		OperationBinaire noeud1 = new Addition(Y,un);
		OperationBinaire noeud2 = new Division(X,noeud1);
		OperationBinaire noeud3 = new Addition(un,noeud2);
	
		assertEquals(3,((ConstRationnelle) noeud3.simplifier()).getNumerateur());
		assertEquals(2,((ConstRationnelle) noeud3.simplifier()).getDenominateur());
	}
*/	

/*	@Test
	public void simpleSum() {

		ConstEntiere neuf = new ConstEntiere(9);
		ConstEntiere deux = new ConstEntiere(2);
		Addition racine = new Addition(neuf, deux);

		assertEquals(11, ((ConstEntiere) racine.simplifier()).getEntier());

	}*/

/*	@Test
	public void classExample() throws VarSymboliqueException {

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

		try {
			sinVs.calculer();
			// problème
			fail("cette ligne ne devrait pas être exécutée");
		} catch (VarSymboliqueException e) {
			// pas problème
			// une erreur a bien été envoyée
			System.out.println("L'Exception a bien été effectué ");
		}

		// assertEquals("x", ((VarSymbolique) vs.simplifier()).getVariable());

		assertEquals('x', ((VarSymbolique) vs.simplifier()).getVariable());

		// Opération de base
		ExpressionArithmetique plus = new Addition(neuf, deux);
		ExpressionArithmetique minus = new Soustraction(trois, cr);
		ExpressionArithmetique times = new Multiplication(plus, minus);
		// assertEquals(550 / 17.0, times.calculer(), 0.00001);
		assertEquals(550 / 17.0, times.calculer(), 0.00001);

		assertEquals(550, ((ConstRationnelle) times.simplifier()).getNumerateur());
		assertEquals(17, ((ConstRationnelle) times.simplifier()).getDenominateur());


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

		//System.out.println("cos(1/17) = " + cosinus.calculer());

		// System.out.println(cr.calculer());
		// System.out.println(cosinus.calculer());

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

		// Constante Symbolique

		ExpressionArithmetique e = new ConstanteSymbolique("e");

		ExpressionArithmetique cosinusExpo = new Cos(e);
		ExpressionArithmetique cosinusPi = new Cos(pi);

		assertEquals(3.14, pi.calculer(), 0.01);

		// test 1 + pi

		ExpressionArithmetique piAddition = new Pi("pi");
		

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
		assertEquals(1.0, additionlnEtUn.calculer(), 1);
		System.out.println("Ln(1) +  1 = " + additionlnEtUn.calculer());

		// x*1
		ExpressionArithmetique UnX = new Multiplication(un, vs);
		// System.out.println("1*x = "+ UnX.calculer());

		// afficher une expression arithmetique
		//System.out.println(testadd.afficher());
		// test 1 + e^0

		// premier test, je dois faire l'exponentielle first
		ExpressionArithmetique expo = new Exponentielle(un);
		System.out.println("Valeur de expo^1 : " + expo.calculer());

		// puis l'addition :)

		ExpressionArithmetique expoAndOne = new Addition(un, expo);
		System.out.println("Expo 0  + 1" + expoAndOne.calculer());

		/*
		 * VarSymbolique vr = new VarSymbolique('x'); vr.setValeur(new ConstEntiere(9));
		 * // x = 9 VarSymbolique oui = (VaSymbolique)vr.simplifier();
		 * System.out.println(oui.getVariable());
		 */

		// test : 1 + Sin(pi/2)
/*
		ExpressionArithmetique PiParDeux = new Division(pi, deux);
		System.out.println("test pi/2  " + PiParDeux.calculer());
		ExpressionArithmetique SinOfPiParDeux = new Sin(PiParDeux);
		System.out.println("test : Sin(pi/2)  " + SinOfPiParDeux.calculer());
		ExpressionArithmetique UnPlusSinOfPiParDeux = new Addition(un, SinOfPiParDeux);
		//assertEquals(2.0, testadd.calculer(), 1);
		System.out.println("test : 1 + Sin(pi/2)  " + UnPlusSinOfPiParDeux.calculer());

		// test Polynome
		int[] tab = { 3, 5, 10 };
		int[] tab2 = { 2, 1, 0 };

		Polynome poly = new Polynome(3, tab, tab2);
		poly.derive();

		Polynome poly2 = new Polynome();
		poly2 = poly.getFonctionDerivee();

		poly2.derive();

		Polynome poly3 = new Polynome();
		poly3 = poly2.getFonctionDerivee();

		poly.afficher();
		poly2.afficher();
		poly3.afficher();
		
		
		//test loic question 8 
		
		ExpressionArithmetique x = new VarSymbolique("x");
		ExpressionArithmetique y = new VarSymbolique("y");
		VarSymbolique Y = (VarSymbolique) y;
		ConstEntiere Un= (ConstEntiere) un;
		Y.modifierVariable(Un.getEntier());
		VarSymbolique X = (VarSymbolique) x;
		X.modifierVariable(Un.getEntier());
		ExpressionArithmetique noeud1 = new Addition(Y,un);
		ExpressionArithmetique noeud2 = new Division(X,noeud1);
		ExpressionArithmetique noeud3 = new Addition(un,noeud2);
		
		double n = noeud3.calculer();
		Object N = (Object) n;
		
		assertEquals(1.5, N);

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
		ExpressionArithmetique pi = new ConstanteSymbolique("pi");

		ExpressionArithmetique division = new Division(pi, trois);

		// element neutre
		//ExpressionArithmetique neutreDiv = new Division(trois, un);
		//ExpressionArithmetique neutreMul = new Multiplication(trois, un);
		//ExpressionArithmetique neutreAdd = new Addition(trois, un);
		//ExpressionArithmetique neutreSous = new Soustraction(trois, un);

		//assertEquals(3.0, neutreDiv.calculer(), 1);
		//assertEquals(3.0, neutreAdd.calculer(), 1);
		//assertEquals(3.0, neutreMul.calculer(), 1);
		//assertEquals(3.0, neutreSous.calculer(), 1);

		// egaliteAr à revoir !!! __________________

		ExpressionArithmetique plus2 = new Addition(neuf, deux);

		ExpressionArithmetique expression1 = plus;
		ExpressionArithmetique expression2 = plus2;

		assertEquals(false, expression1.egaliteAr(expression2));

		// System.out.println(divide.calculer());
		// System.out.println(division.calculer());  ????


	}*/
}