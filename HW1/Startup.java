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
		Scanner scanner = new Scanner(System.in);//create scanner to scan users' input
		System.out.println("Please type your input");//prompt users for input
		String infix = scanner.nextLine();//Read the input
		MyStack stack = new MyStack();//create stack 
		//for loop to check every single symbol from users' input
		for ( int i = 0; i < infix.length(); i++){
			int ascii = (int) infix.charAt(i);
			if (ascii >= 65){
				System.out.print(infix.charAt(i));}//read operand and output it
			if (ascii >= 40 && ascii <= 47){
				//check stack is empty and if parenthesis on top
				if (stack.isEmpty() == true || (char) stack.peek() == '('){
					//push operator to stack
					stack.push(infix.charAt(i));
				}
				//check precidence with existing operator
				//if current operator (infix.charAt(i)) > existing operator (stack.peek()), push current one
				char currOperator = infix.charAt(i);
				char eOperator = (char) stack.peek();
				if ((currOperator == '/' || currOperator == '*') && (eOperator == '+' ||eOperator == '-')){
					stack.push(currOperator);
				}
				else{
					System.out.print(stack.pop());
					if ((currOperator == '/' || currOperator == '*') && (eOperator == '+' ||eOperator == '-')){
						stack.push(currOperator);
					}
					stack.push(currOperator);
				}
				}
				if (infix.charAt(i) == ')'){
					stack.push(infix.charAt(i));
				}
				if (infix.charAt(i) == '('){
					while (infix.charAt(i) != ')'){
						
						System.out.print(stack.pop());
					}
				}
				while (stack.isEmpty() == false){
					
				}
				
			}
	
		}
	}
	
