package td3;

public class Ln extends OperationUnaire {

	public Ln(ExpressionArithmetique ea) {
		super(ea);
	}
	
	@Override
	public double calculer() {
		
		return Math.log(this.ea.calculer());
	}
	
	

}
