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
	public boolean egaliteAr(ExpressionArithmetique expr2) {
		// TODO Auto-generated method stub
		return false;
	}



}
