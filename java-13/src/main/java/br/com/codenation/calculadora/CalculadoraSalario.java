package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		 if (salarioBase < 1039){
		 	return 0L;
		 }
		double salarioBrutoInss = salarioBase - calculaDescontoInss(salarioBase);
		double salarioLiquido = salarioBrutoInss - calculaDescontoIrrf(salarioBrutoInss);
		return Math.round(salarioLiquido);
	}
	
	private double getAliquotaInss(double salarioBase){
		if(salarioBase >=1000 && salarioBase <= 1500){
			return 0.08d;
		}else if(salarioBase > 1500 && salarioBase <= 4000){
			return 0.09d;

		}else {
			return 0.11d;

		}
	}
	private double getAliquotaIrrf(double salarioBrutoInss){
		if( salarioBrutoInss <= 3000){
			return 0.0d;
		} else if (salarioBrutoInss > 3000 && salarioBrutoInss <= 6000){
			return 0.075d;
		} else {
			return 0.15d;
		}
	}

	private double calculaDescontoInss(double salarioBase) {
		double desconto = salarioBase* getAliquotaInss(salarioBase);
		return desconto;
	}

	private double calculaDescontoIrrf(double salarioBrutoInss){
		double desconto = salarioBrutoInss * getAliquotaIrrf(salarioBrutoInss);
		return desconto;
	}
}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/