package projet;

public class Produit extends OperationBinaire{
	
	public Produit(ExpressionArithmetique nombre, ExpressionArithmetique max) {
		super(nombre,max);
	}

	@Override
	public double calculer() {
		double result =0;
		if(this.eaLeft instanceof Multiplication) {
			Multiplication ealeft = (Multiplication) this.eaLeft;
			if(ealeft.eaLeft instanceof Indice && ealeft.eaRight instanceof Puissance) {
				Indice ealeftLeft = (Indice) ealeft.eaLeft;
				Puissance ealeftRight=(Puissance) ealeft.eaRight;
				VarSymbolique ealeftLeftRight= (VarSymbolique) ealeftLeft.eaRight;
				VarSymbolique ealeftRightRight= (VarSymbolique) ealeftRight.eaRight;
				for(int i=0; i<=this.eaRight.calculer();i++) {
					ealeftLeftRight.setValue(i);
					ealeftRightRight.setValue(i);
					result*=this.eaLeft.calculer();
				}
				return result;
			}else if(ealeft.eaLeft instanceof Puissance  && ealeft.eaRight instanceof Puissance){
				Puissance ealeftLeft = (Puissance) ealeft.eaLeft;
				Puissance ealeftRight=(Puissance) ealeft.eaRight;
				VarSymbolique ealeftLeftRight= (VarSymbolique) ealeftLeft.eaRight;
				VarSymbolique ealeftRightRight= (VarSymbolique) ealeftRight.eaRight;
				for(int i=0; i<=this.eaRight.calculer();i++) {
					ealeftLeftRight.setValue(i);
					ealeftRightRight.setValue(i);
					result*=this.eaLeft.calculer();
				}
				return result;
			}else 
				return this.calculer();
		}else if(this.eaLeft instanceof Puissance) {
			Puissance eaLeft = (Puissance) this.eaLeft;
			VarSymbolique eaLeftRight= (VarSymbolique) eaLeft.eaRight;
			if(eaLeft.eaLeft instanceof VarSymbolique) {
				return this.calculer();
			} else {
				
				for(int i=0;i<=this.eaRight.calculer(); i++) {
					eaLeftRight.setValue(i);
					result*=this.eaLeft.calculer();
				}
				return result;
			}
		}else
			return this.calculer();
	}

	@Override
	protected ExpressionArithmetique simplifie(ExpressionArithmetique gauche, ConstEntiere droite) {
		if(gauche instanceof Multiplication) {
			Multiplication g=(Multiplication) gauche;
			if(g.eaLeft instanceof Indice && g.eaRight instanceof Puissance) {
				Indice gEaLeft= (Indice) g.eaLeft;
				Puissance gEaRight= (Puissance) g.eaRight;
				return this;
			}else if(g.eaLeft instanceof Puissance && g.eaRight instanceof Puissance) {
				Puissance gEaLeft = (Puissance) g.eaLeft;
				Puissance gEaRight = (Puissance) g.eaRight;
				VarSymbolique gEaLeftRight=(VarSymbolique) gEaLeft.eaRight;
				VarSymbolique gEaRightRight=(VarSymbolique) gEaRight.eaRight;
				int r=1;
				for(int i=0; i<=droite.getEntier();i++) {
					gEaLeftRight.setValue(i);
					gEaRightRight.setValue(i);
					r*=gauche.calculer();
				}
				return new ConstEntiere(r).simplifier();
			}else {
				return this;
			}
		}else if(gauche instanceof Puissance){
			Puissance g=(Puissance) gauche;
			VarSymbolique gEaRight=(VarSymbolique) g.eaRight;
			if(g.eaLeft instanceof VarSymbolique) {
				return this;
			}else {
				int r=1;
				for(int i=0; i<=droite.getEntier();i++) {
					gEaRight.setValue(i);
					r*=gauche.calculer();
				}
				return new ConstEntiere(r).simplifier();
			}
		}else
			return this;
			
	}
	
	@Override
	public String afficher() {
		String result ="";
		if(this.eaLeft instanceof Multiplication) {
			Multiplication ealeft = (Multiplication) this.eaLeft;
			Indice ealeftLeft=(Indice) ealeft.eaLeft;
			Puissance ealeftRight=(Puissance) ealeft.eaRight;
			VarSymbolique ealeftLeftRight=(VarSymbolique) ealeftLeft.eaRight;
			VarSymbolique ealeftRightRight=(VarSymbolique) ealeftRight.eaRight;
			int c=0;
			for(int i=0; i<=this.eaRight.calculer();i++) {
				ealeftLeftRight.setValue(i);
				if(i!=this.eaRight.calculer())	
					result+=ealeftLeft.afficher()+"*";
				else
					result+=ealeftLeft.afficher();
				c+=i;
			}
			ealeftRightRight.setValue(c);
			result+="*"+ealeftRight.afficher();
		}
		if(this.eaLeft instanceof Puissance) {
			Puissance eaLeft = (Puissance) this.eaLeft;
			VarSymbolique eaLeftRight=(VarSymbolique) eaLeft.eaRight;
			int c=0;
			for(int i=0; i<=this.eaRight.calculer(); i++) {
				c+=i;
			}
			eaLeftRight.setValue(c);
			result+=this.eaLeft.afficher();
		}
		if(this.eaLeft instanceof Indice) {
			Indice eaLeft = (Indice) this.eaLeft;
			VarSymbolique eaLeftRight=(VarSymbolique) eaLeft.eaRight;
			for(int i=0; i<=this.eaRight.calculer(); i++) {
				eaLeftRight.setValue(i);
				if(i!=this.eaRight.calculer())
					result+=this.eaLeft.afficher()+"*";
				else
					result+=this.eaLeft.afficher();
			}
		}	
		return result;
	}


}
