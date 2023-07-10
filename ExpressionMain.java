package com.stack;

import java.util.Stack;

public class ExpressionMain {

	public static int solvePostfix(String post) {
		// stack of perands
		Stack<Integer> s = new Stack<>();
		// traverse postfix from left to right
//		System.out.print(post);
//		System.out.println("-------------");
		for (int i = 0; i < post.length(); i++) {
			// get each symbol fro, expression
			char symbol = post.charAt(i);
			// System.out.print(symbol);
			// if symbol is operandd
			if (Character.isDigit(symbol)) {
				// convert it into int and push on satck
				String operand = Character.toString(symbol);
				// System.out.print(operand);
				s.push(Integer.parseInt(operand));
			} else {
				// pop two operand from stack
				int b = s.pop();

				int a = s.pop();
				// calculate result
				int c = calc(a, b, symbol);
				// push result on stack
				s.push(c);
			}
		} // repeat for all symbol in expression
			// pop final result from stack and return
		return s.pop();
	}

	public static int calc(int a, int b, char operator) {
		switch (operator) {
		case '$':
			return (int) Math.pow(a, b);
		case '/':
			return a / b;
		case '*':
			return a * b;
		case '+':
			return a + b;
		case '-':
			return a - b;
		}
		return 0;
	}

	// infix to postfix
	public static String infixToPostfix(String infix) {
		Stack<Character> s = new Stack<Character>();
		// we are using stringBuilder since we have to do mutability again and again an
		// or we could have used StringBuffer but it is mainly used in synchrosnised or
		// multithreading environment
		// since this his is single threaded use StringBuilder
		StringBuilder post = new StringBuilder();
		
		// traverse infix from left to rigth
		for (int i = 0; i < infix.length(); i++) {
			char symbol = infix.charAt(i); // symbol can be operand,( , ) o operator
			// if operand found append to postfix

			if (Character.isDigit(symbol)) {
				post.append(symbol);
			} else if (symbol == '(') { // if opening '(' is found, thne push it into stack
				s.push(symbol);
			} else if (symbol == ')') { // if closing is found, pop all operator from satck one by one and
				// append to postfix, until opening ) is found
				while (s.peek() != '(')
					post.append(s.pop());
				// also pop and discar opening
				s.pop();

			} else { // if operator is found, push it into stack
						// if priority of topmost operator is >= current operator ,pop and append to
						// post
				while (!s.isEmpty() && priority(s.peek()) >= priority(symbol)) {
					post.append(s.pop());// pop op from stack and append to postfix
				}
				s.push(symbol);
			}
		}
		// when all symbol from infix are done , pop all operators from stack one by one
		// and append to postfix
		while (!s.isEmpty())
			post.append(s.pop());
		return post.toString();

	}

	//to chek priority 
	public static int priority(Character operator) {
		switch (operator) {
		case '$':
			return 10; // higher precedence
		case '*':
			return 7;
		case '/':
			return 7;
		case '%':
			return 7;
		case '+':
			return 5;
		case '-':
			return 5;
		}
		return 0; // in case of ( and ) etc
	}

	//prefix
	private static int solvePrefix(String pre) {
		Stack<Integer> s = new Stack<>();
		// traverse from right left
		for (int i = pre.length() - 1; i >= 0; i--) {
			char sym = pre.charAt(i);

			if (Character.isDigit(sym)) {
				String operand = Character.toString(sym);
				s.push(Integer.parseInt(operand));
			} else {
				int a = s.pop();
				int b = s.pop();
				int c = calc(a, b, sym);
				s.push(c);
			}
		}
		return s.pop();
	}

	

	public static String infixToPrefix(String infix) {
		Stack<Character> s = new Stack<Character>();
		StringBuilder pre = new StringBuilder();
		
		//traverse from right to left
		for(int i=infix.length()-1;i>=0;i--) {
			char symbol = infix.charAt(i);
			if(Character.isDigit(symbol)){ //if operand found, push it in stack
				pre.append(symbol);
			}
			else if(symbol ==')') { //if clising found push
				s.push(symbol);
			}
			else if(symbol == '(') { //if opening pop operator from stack and append to 
				//prefix until closing is found
				while(s.peek()!=')') {
					pre.append(s.pop());
				}
				//pop and discard (
				s.pop();
			}
			else {
				// if operator is found, push it into stack
				// if priority of topmost operator is > current operator ,pop and append to pre
				while(!s.isEmpty() && priority(s.peek())>priority(symbol)) {
					pre.append(s.pop());// pop op from stack and append to prefix
				}
				s.push(symbol);
			}
		}
		//when all symbol from infix are done, pop all operator from stack one by one and appned to prefix
		while(!s.isEmpty()) {
			pre.append(s.pop());
		}
		//reverse prefix and return
		return pre.reverse().toString();
	}
	
	//Parenthesis balancing
	public static boolean isBalanced(String expr) {
		Stack<Character> st = new Stack<Character>();
		String open = "({[" , close=")}]";
		
		//treaverse xpr from left to right
		for(int i = 0;i<expr.length();i++) {
			char symbol = expr.charAt(i);
			
			//if opening is found
			if(open.indexOf(symbol)!=-1) {
				st.push(symbol);
			}
			//if closing is found
			else if(close.indexOf(symbol)!=-1) {
				//if stack is empty some opening is less
				if(st.empty()) {
					return false;
				}
				//pop one from stack
				char pop = st.pop();
				//compare if they are matching , if yes continue
				if(close.indexOf(symbol)!=open.indexOf(pop)) {
					return false;
			}
			
		}
			
		}
		return st.empty();
	}
	
	public static void main(String[] args) {
		String postfix = "";// "59+4862/-*-173-$+";
		String prefix = ""; //"+-+59*4-8/62$1-73";
		String infix = "(5+9-4*(8-6/2)+1$(7-3)))";
		
		// int result = solvePostfix(postfix);
//		int result1 = solvePrefix(prefix);
//		System.out.println("Result:"+result1);
//		postfix = infixToPostfix(infix);
//		prefix = infixToPrefix(infix);
		boolean balanced = isBalanced(infix);
		System.out.println("Balanced: "+balanced);
//		System.out.println("Postfix:" + postfix);
//		System.out.println("Prefix:" + prefix);
//		

	}

}
