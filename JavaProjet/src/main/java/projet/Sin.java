package projet;

public class Sin extends OperationUnaire {

	public Sin(ExpressionArithmetique ea) {
		super(ea);
	}

	@Override
	public double calculer() {

		return Math.sin(this.ea.calculer());
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
		String result = ((Sin) expr2).afficher();
		String result2 = this.afficher();
		int comparaison = result.compareTo(result2);
		
		if(comparaison == 0) {
			return true; 
		}
		return false; 
		
		
	}

	@Override
	public String afficher() {
		return "sin(" + ea.afficher() + ")";
	}

	

}
