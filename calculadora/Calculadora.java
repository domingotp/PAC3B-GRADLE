package calculadora;

import org.apache.commons.math3.primes.Primes;

public class Calculadora {
	
	private float lastResult;
	private String lastOp;

	public float getLastResult(){
		return this.lastResult;
	}

	public String getLastOp(){
		return this.lastOp;
	}

	public float suma(float op1, float op2){
		float result=op1+op2;
		this.lastResult=result;
		this.lastOp="Suma";

		return result;
	}

	public float resta(float op1, float op2){
		float result=op1-op2;
		this.lastResult=result;
		this.lastOp="Resta";

		return result;
	}

	public float multiplica(float op1, float op2){
		float result=op1*op2;
		this.lastResult=result;
		this.lastOp="Multiplica";

		return result;
	}

	public float divideix(float op1, float op2){
		float result=op1/op2;
		this.lastResult=result;
		this.lastOp="Divideix";

		return result;
	}

	public float majorque(float op1, float op2){
		float result;
		if (op1>op2) {
			result=op1;
		} else {
			result=op2;
		}
		this.lastResult=result;
		this.lastOp="Major";

		return result;
	}
	
	public Boolean esPrim(float op1){
		int aux=(int)op1;
		return Primes.isPrime(aux);
	}

	public Integer proximPrim(float op1){
		int aux=(int)op1;
		return Primes.nextPrime(aux);
	}
	
}
