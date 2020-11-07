package projet;

public class Exponentielle extends OperationUnaire {

	public Exponentielle(ExpressionArithmetique ea) {
		super(ea);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public double calculer() {
		
		return Math.exp(this.ea.calculer());
	}

	@Override
	public boolean egaliteAr(ExpressionArithmetique expr2) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
