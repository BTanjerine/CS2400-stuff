/*
Brayden Tanji 
march 15, 2022
CS 2400
driver code for the linked stack class to test infix to postfix conversion
*/


public class LStackTest {
	public static void main(String[] args) {

	}

	public String convertToPostfix(String infix){
		LStack<Character> operationStack = new LStack<>();
		String postfix = "";

		int nextIndex = 0;
 		while(infix.length() > 0){
			char nextChar = infix.charAt(nextIndex);

			if(nextChar == ' '){
				System.out.println("error: no spaces inside of infix equation");	//exit code if there are spaces in the code
				break;
			}

			switch(nextChar){
				case '^':
					operationStack.push(nextChar);		//push operation on to stack
				break;

				case '+': case '-': case '*': case '/':
					while(!operationStack.isEmpty() && true){	// precedence of nextchar <= precedence of operatorstack.peek

					}
					operationStack.push(nextChar);		//push operation on to stack
				break;

				case '(':
					operationStack.push(nextChar);		//push operation on to stack
				break;

				case ')':
					char topOperator = operationStack.pop();	//pop operation

					while(topOperator != '('){			//keep popping and appending to postfix till the open bracket is reached	
						postfix += topOperator;
						topOperator = operationStack.pop();
					}
				break;

				default: 
					int charVal = nextChar;
					if(((charVal > 65 && charVal < 90) || (charVal > 97 && charVal < 122))){ //check if char is not a letter
						postfix += nextChar;
					}	

				break;
			}

			nextIndex++;		//increment index for next char
		}

		return postfix;
	}
}
