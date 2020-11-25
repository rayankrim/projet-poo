package projet;

public final class Factorisation extends OperationUnaire {



	public Factorisation(ExpressionArithmetique ea) {
		super(ea);
	}

	public ExpressionArithmetique facto() {

		

		ConstEntiere deux = new ConstEntiere(2);
		// Cas Polynome de la forme AX^2 + A*2*X*Y + AY^2
		if (ea instanceof Addition) {
			Addition poly = (Addition) ea;
			ExpressionArithmetique polyLeft = poly.eaLeft;
			ExpressionArithmetique polyRight = poly.eaRight;
			if (polyLeft instanceof Addition) {
				Addition polyleft = (Addition) polyLeft;
				if (polyleft.eaLeft instanceof Multiplication) {
					Multiplication AX2 = (Multiplication) polyleft.eaLeft;
					ConstEntiere A = (ConstEntiere) AX2.eaLeft;
					if (AX2.eaRight instanceof Puissance) {
						Puissance x2Puissance = (Puissance) AX2.eaRight;
						VarSymbolique X = (VarSymbolique) x2Puissance.eaLeft;
						ConstEntiere puissance = (ConstEntiere) x2Puissance.eaRight;
						if (puissance.equals(deux)) {
							if (polyleft.eaRight instanceof Multiplication) {
								Multiplication deuxAfoisXY = (Multiplication) polyleft.eaRight;
								Multiplication AFOIS2 = (Multiplication) deuxAfoisXY.eaLeft;
								if (AFOIS2.simplifier().equals(new Multiplication(deux, A).simplifier())) {
									if (polyRight instanceof Multiplication) {
										Multiplication AfoisYcarre = (Multiplication) polyRight;
										Puissance y2Puissance = (Puissance) AfoisYcarre.eaRight;
										VarSymbolique Y = (VarSymbolique) y2Puissance.eaLeft;
										if (AfoisYcarre.eaLeft.equals(A)) {
											ExpressionArithmetique aplusb = new Addition(X, Y);
											ExpressionArithmetique aplusbcarre = new Puissance(aplusb, deux);
											ExpressionArithmetique Afoisidentite = new Multiplication(A, aplusbcarre);
											// retourner l'identié remarque
											return Afoisidentite;

										}

									}
								}
							}
						}

					}

				}
				// Cas ou pas de A
				Puissance x2Puissance = (Puissance) polyleft.eaLeft;
				VarSymbolique X = (VarSymbolique) x2Puissance.eaLeft;
				ConstEntiere puissance = (ConstEntiere) x2Puissance.eaRight;
				if (puissance.equals(deux)) {
					if (polyleft.eaRight instanceof Multiplication) {
						Multiplication deuxfoisXY = (Multiplication) polyleft.eaRight;
						Multiplication XY = (Multiplication) deuxfoisXY.eaRight;
						if (deuxfoisXY.eaLeft.equals(deux)) {
							if (!(polyRight instanceof Multiplication)) {
								Puissance ycarre = (Puissance) polyRight;
								VarSymbolique Y = (VarSymbolique) ycarre.eaLeft;
								if (XY.equals(new Multiplication(X, Y)) || XY.equals(new Multiplication(Y, X))) {
									ExpressionArithmetique aplusb = new Addition(X, Y);
									ExpressionArithmetique aplusbcarre = new Puissance(aplusb, deux);
									return aplusbcarre;
								}
							}
						}
					}
				}
				// Cas Polynome de la forme AX^2 - A*2*X*Y + AY^2	
			} else if (polyLeft instanceof Soustraction) {
				Soustraction polyleft = (Soustraction) polyLeft;
				if (polyleft.eaLeft instanceof Multiplication) {
					Multiplication AX2 = (Multiplication) polyleft.eaLeft;
					ConstEntiere A = (ConstEntiere) AX2.eaLeft;
					if (AX2.eaRight instanceof Puissance) {
						Puissance x2Puissance = (Puissance) AX2.eaRight;
						VarSymbolique X = (VarSymbolique) x2Puissance.eaLeft;
						ConstEntiere puissance = (ConstEntiere) x2Puissance.eaRight;
						if (puissance.equals(deux)) {
							if (polyleft.eaRight instanceof Multiplication) {
								Multiplication deuxAfoisXY = (Multiplication) polyleft.eaRight;
								Multiplication AFOIS2 = (Multiplication) deuxAfoisXY.eaLeft;
								if (AFOIS2.simplifier().equals(new Multiplication(deux, A).simplifier())) {
									if (polyRight instanceof Multiplication) {
										Multiplication AfoisYcarre = (Multiplication) polyRight;
										Puissance y2Puissance = (Puissance) AfoisYcarre.eaRight;
										VarSymbolique Y = (VarSymbolique) y2Puissance.eaLeft;
										if (AfoisYcarre.eaLeft.equals(A)) {
											ExpressionArithmetique amoinsb = new Soustraction(X, Y);
											ExpressionArithmetique amoinsbcarre = new Puissance(amoinsb, deux);
											ExpressionArithmetique Afoisidentite = new Multiplication(A, amoinsbcarre);
											return Afoisidentite;

										}

									}
								}

							}
						}
					}
				}
				// Cas ou pas de A
				Puissance x2Puissance = (Puissance) polyleft.eaLeft;
				VarSymbolique X = (VarSymbolique) x2Puissance.eaLeft;
				ConstEntiere puissance = (ConstEntiere) x2Puissance.eaRight;
				if (puissance.equals(deux)) {
					if (polyleft.eaRight instanceof Multiplication) {
						Multiplication deuxfoisXY = (Multiplication) polyleft.eaRight;
						Multiplication XY = (Multiplication) deuxfoisXY.eaRight;
						if (deuxfoisXY.eaLeft.equals(deux)) {
							if (!(polyRight instanceof Multiplication)) {
								Puissance ycarre = (Puissance) polyRight;
								VarSymbolique Y = (VarSymbolique) ycarre.eaLeft;
								if (XY.equals(new Multiplication(X, Y)) || XY.equals(new Multiplication(Y, X))) {
									ExpressionArithmetique amoinsb = new Soustraction(X, Y);
									ExpressionArithmetique amoinsbcarre = new Puissance(amoinsb, deux);
									return amoinsbcarre;

								}
							}
						}
					}
				}

			}
		}

		
		//Cas ou (a - b)(a + b)
		if (ea instanceof Multiplication) {
			Multiplication membre = (Multiplication) ea;
			if (membre.eaLeft instanceof Soustraction) {
				Soustraction membregauche = (Soustraction) membre.eaLeft;
				VarSymbolique a = (VarSymbolique) membregauche.eaLeft;
				VarSymbolique b = (VarSymbolique) membregauche.eaRight;
				if (membre.eaRight instanceof Addition) {
					Addition membredroit = (Addition) membre.eaRight;
					if (membredroit.eaLeft.equals(a) || membredroit.eaLeft.equals(b)) {
						if (membredroit.eaRight.equals(b) || membredroit.eaRight.equals(a)) {
							ExpressionArithmetique acarre = new Puissance(a, deux);
							ExpressionArithmetique bcarre = new Puissance(b, deux);
							ExpressionArithmetique acarremoinsbcarre = new Soustraction(acarre, bcarre);
							return acarremoinsbcarre;
						}
					}
				}
			}
			//cas ou (a + b(a - b))
			if (membre.eaLeft instanceof Addition) {
				Addition membregauche = (Addition) membre.eaLeft;
				VarSymbolique a = (VarSymbolique) membregauche.eaLeft;
				VarSymbolique b = (VarSymbolique) membregauche.eaRight;
				if (membre.eaRight instanceof Soustraction) {
					Soustraction membredroit = (Soustraction) membre.eaRight;
					if (membredroit.eaLeft.equals(a) || membredroit.eaLeft.equals(b)) {
						if (membredroit.eaRight.equals(b) || membredroit.eaRight.equals(a)) {
							ExpressionArithmetique acarre = new Puissance(a, deux);
							ExpressionArithmetique bcarre = new Puissance(b, deux);
							ExpressionArithmetique acarremoinsbcarre = new Soustraction(acarre, bcarre);
							return acarremoinsbcarre;

						}

					}
				}
			}
		}
		return null;

	}

	@Override
	public double calculer() {
		return 0;
	}

	@Override
	public String afficher() {
		return null;
	}
	
	@Override
	public ExpressionArithmetique isNeutre() {
		return null;
	}
}

