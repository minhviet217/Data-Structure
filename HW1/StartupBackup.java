/**
* A starup class that acts as a sandbox to make use of our Infix to Postfix conversion 
*
* @name		Viet Nguyen, Joshua Martin
* @version	02/06/2020
*/
import java.util.*;
import java.util.Iterator;
public class StartupBackup<T>{
	public static int precedence(char operand){
		if(operand == '+' || operand == '-'){
				int precedence = 1;
				return precedence;
			}
			else if(operand == '*' || operand == '/'){
				int precedence = 2;
				return precedence;
			}
			return -1;
			
				
	}
	
		
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);//create scanner to scan users' input
		System.out.println("Please type your input");//prompt users for input
		String infix = scanner.nextLine();//Read the input
		String postfix = "";
		MyStack<Character> stack = new MyStack<>();//create stack 
		//for loop to check every single symbol from users' input
		for(int i = 0; i < infix.length();i++){
			char current = infix.charAt(i);
			
			if(precedence(current) > 0){
				while(stack.isEmpty() == false && precedence(stack.peek()) >= precedence(current)){
					postfix += stack.pop();
				}
				stack.push(current);
			}
			else if(current == ')'){
				char temp = stack.pop();
				while(temp != '('){
					postfix += temp;
					temp = stack.pop();
				}
			}
			else if(current == '('){
				stack.push(current);
			}
			else{
				postfix += current;
			}
			
		}
		while(stack.isEmpty() == false){
				postfix += stack.pop();
		}
		System.out.println("Postfix converted string: " + postfix);
	}
}