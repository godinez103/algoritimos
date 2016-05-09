
public class Pilha {

	private String[] data = new String[20];
	private int count;
	
	public void push(String element){
		if(count ==data.length){
			System.out.println("erro1");
		}else{
			data[count] = element;
			count++;
		}	
	}
	public String pop(){
		if(count==0){
			return "erro2";
			
		}		
		else{
			String aux = data[count -1];
			count--;
			return aux;
		}
	}
	public  int size(){
		return count;
	}
	public String top(){
		if(count == 0){
			return "erro3";
			
		}
		else return data[count-1];
	}
	public boolean isEmpty(){
		if(count==0) return true;
		else return false;
	}
	public void clear(){
		count =0;
	}
}
