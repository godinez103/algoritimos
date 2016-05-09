public class Calculadora {	
	public int soma(int x, int y){
		return x+y;
	}
	public int sub(int x, int y){
		return x-y;
	}
	public int mult(int x, int y){
		return x*y;
	}
	public int div(int x, int y){
		return x/y;
	}
	public int exp(int x, int y){
		return (int) Math.pow(x, y);
	}
}