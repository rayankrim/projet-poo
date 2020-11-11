package projet;

public class Cos extends OperationUnaire {

	public Cos(ExpressionArithmetique ea) {
	super(ea);
	

	}
	
	@Override
	public double calculer() {
	
		return Math.cos(this.ea.calculer());
	}

	@Override
	public boolean egaliteAr(ExpressionArithmetique expr2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String afficher() {
		return "cos(" + ea.afficher() + ")";
	}



}
