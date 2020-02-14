/**
* A starup class that acts as a sandbox to make use of our Infix to Postfix conversion 
*
* @name		Viet Nguyen, Joshua Martin
* @version	02/06/2020
*/
import java.util.*;
import java.util.Iterator;
public class Startup<T>{
		
	public static void main(String[] args){
		//create scanner to scan users' input
		Scanner scanner = new Scanner(System.in);
		
		//prompt users for input
		System.out.println("Please type your input");
		
		//Read the input
		String infix = scanner.nextLine();
		
		//Output postfix order
		String postfix = "";
		
		//create stack 
		MyStack<Character> stack = new MyStack<>();
		
		//for loop to read every single character from users' input 
		for(int i = 0; i < infix.length();i++){
			char current = infix.charAt(i);
			
			//Check if the character is operator
			if(priority(current) > 0){
				//if stack is empty, push current to stack
				if (stack.isEmpty()){
					stack.push(current);
					}
				
				else {
				//while stack is not empty, check precedence between C.O and E.O
				//existing operator (E.O) >= current operator (C.O), pop E.O
				while(!stack.isEmpty() && priority(stack.peek()) >= priority(current)){
					postfix += stack.pop();
				}
				//while loop will terminate when checking of E.O and C.O does not sastify the conditional operation
				//and then push C.O to stack
				stack.push(current);
				}
			}
			
			//if character is open parenthesis, push operator to stack
			else if(current == '('){
				stack.push(current);
			}
			
			//if character is close parenthesis, pop operators until hit open parenthesis
			else if(current == ')'){
				char temp = stack.pop();
				do{
				postfix += temp;
				temp = stack.pop();}
				while(temp != '(');
			}
			
			//If the character is not operator or parenthesese, output it
			else{
				postfix += current;
			}	
		}
		
		//pop the rest in stack if it not empty
		while(stack.isEmpty() == false){
				postfix += stack.pop();
		}
		System.out.println("Postfix converted string: " + postfix);
	}
	
	//method that return the predecence of 4 operator +, -, *, /
	public static int priority(char operand){
		if(operand == '+' || operand == '-'){
				int priority = 1;
				return priority;
			}
			else if(operand == '*' || operand == '/'){
				int priority = 2;
				return priority;
			}
			return 0;
	}
}