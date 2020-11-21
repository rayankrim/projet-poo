package projet;

//A peut prêt sur la meme forme que Addition.
public class RacineCarre extends OperationUnaire {

	public RacineCarre(ExpressionArithmetique ea) {
		super(ea);
	}

	public double calculer() {// faire l'exception pour les nb <1.
		double calcul = Math.sqrt(this.ea.calculer());
		int c = (int) calcul;
		if (c * c != this.ea.calculer()) {
			return this.ea.calculer();
		} else {
			return calcul;
		}
	}

	@Override
	public ExpressionArithmetique simplifie(ConstEntiere nb) { // verifier que "nb" est paire
		double calcul = Math.sqrt(nb.getEntier());
		int c = (int) calcul;
		if (c * c != nb.getEntier()) {
			return this;
		} else {
			return new ConstEntiere(c).simplifier();
		}
	}

	@Override
	public ExpressionArithmetique simplifie(ConstRationnelle nb) {
		ConstEntiere n = new ConstEntiere(nb.getNumerateur());
		ConstEntiere d = new ConstEntiere(nb.getDenominateur());
		double calcul1 = Math.sqrt(n.calculer());
		double calcul2 = Math.sqrt(d.calculer());
		int c1 = (int) calcul1;
		int c2 = (int) calcul2;

		if (c1 * c1 != n.getEntier() || c2 * c2 == d.getEntier()) {
			return this;
		} else {
			return new ConstRationnelle(c1, c2).simplifier();
		}
	}

	@Override
	public boolean equals(Object expr2) {
		if (this == expr2) {
			return true;

		}

		if (expr2 == null) {
			return false;
		}

		if (getClass() != expr2.getClass()) {

			return false;

		}
		int comparaison = ((RacineCarre) expr2).afficher().compareTo(this.afficher());
		
		if(comparaison == 0) {
			return true; 
		}
		return false; 
		
		
	}

	@Override
	public String afficher() {
		return "√" + ea.afficher();
	}

	
	//non utilisé car il n'y pas d'élément neutre dans une racine carrée
	@Override
	public ExpressionArithmetique isNeutre(ConstEntiere ce) {
		return null;
	}

	

}
