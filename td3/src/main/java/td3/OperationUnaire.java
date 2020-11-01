package td3;

//A peu prêt sur le même model que "Operation Binaire".
public abstract class OperationUnaire implements ExpressionArithmetique{
	protected ExpressionArithmetique ea;
	
	public OperationUnaire(ExpressionArithmetique ea) {
		this.ea= ea;
	}
	
	protected ExpressionArithmetique simplifie(ExpressionArithmetique nb) {
		return this;
	}
	protected ExpressionArithmetique simplifie(ConstEntiere nb) {
		return this;
	}
	protected ExpressionArithmetique simplifie(ConstRationnelle nb) {
		return this;
	}

	public ExpressionArithmetique simplifier() {
		this.ea= this.ea.simplifier();
		
		if (this.ea instanceof ConstEntiere) {
			ConstEntiere nb= (ConstEntiere) this.ea;
			return simplifie(nb);
		} else if(this.ea instanceof ConstRationnelle){
			ConstRationnelle nb= (ConstRationnelle) this.ea;
			return simplifie(nb);
		} else {
			return this;
		}
	}
}
