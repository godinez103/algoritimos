import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Operacao {
	private static String mFilename = "expressoes.txt";
	
	public static void main(String[] args) throws IOException {

		Pilha pilha = new Pilha();
		Calculadora calc = new Calculadora();
		BufferedReader br = new BufferedReader(new FileReader(mFilename));
		
	
		String line = br.readLine();
		
		while (line != null) {
			int n = 0;			
			String [] vet = line.split(" ");
			for(String newLine : vet) {														
				pilha.push(newLine);
				String momento = pilha.top();
				System.out.println(momento);
				n++;
				System.out.println(pilha.size());				
				if (momento.equals(")")){
					int stop = 0;
					String [] op = new String[n];
					while (pilha.top()!="("){							
						op[n-stop] = pilha.pop();
						stop++;
					}
					for(int i = 0;i<=stop;i++){
						System.out.println(op[i]);
					}
					String lixo = pilha.pop();
					while(stop>2){
						if(op[n-stop + 1]=="+"){
							int n1 = calc.soma(Integer.parseInt(op[n-3]), Integer.parseInt(op[n-1]));
							stop= stop-2;
							op[n-stop]=n1+"";								
						}else if(op[n-stop + 1]=="-"){
							int n1 = calc.sub(Integer.parseInt(op[n-3]), Integer.parseInt(op[n-1]));
							stop= stop-2;
							op[n-stop]=n1+"";
						}else if(op[n-stop + 1]=="*"){
							int n1 = calc.mult(Integer.parseInt(op[n-3]), Integer.parseInt(op[n-1]));
							stop= stop-2;
							op[n-stop]=n1+"";
						}else if(op[n-stop + 1]=="/"){
							int n1 = calc.div(Integer.parseInt(op[n-3]), Integer.parseInt(op[n-1]));
							stop= stop-2;
							op[n-stop]=n1+"";
						}else if(op[n-stop + 1]=="^"){
							int n1 = calc.exp(Integer.parseInt(op[n-3]), Integer.parseInt(op[n-1]));
							stop= stop-2;
							op[n-stop]=n1+"";
						}
					}
					pilha.push(op[n-stop+1]);
				}
			}
			System.out.println(pilha.top());
			System.out.println(line);
			line = br.readLine();
		}
	
		br.close();
	
	}
}

