package Stacks_Queues;

public class AlgorithmUsedStack {
	
	//1. 괄호표현이 올바르게 쓰였는지 확인하는 함수 - p217 
	public boolean isMatched (String expression) {
		System.out.println(expression);
		final String opening = "({[";
		final String closing = ")}]";
		LinkedStack<Character> stack = new LinkedStack<>();
		
		for(char c : expression.toCharArray()) {
			if(opening.indexOf(c)!=-1) { //expression이 opening에 포함되어있는 경우 
				stack.push(c);
			}
			else if(closing.indexOf(c)!=-1) { //expression이 closing에 포함되어있을 경우
				if(stack.isEmpty()) return false;
				if(opening.indexOf(stack.pop())!=closing.indexOf(c)) return false;
			}
		}

		return stack.isEmpty(); //expression의 모든 character를 검사하면 stack은 비어있게 된다. 
	}
	
	//2. 스택 두개로 큐 자료구조 구현하기
	private LinkedStack inBox = new LinkedStack();
	private LinkedStack outBox = new LinkedStack();
	public void enqueue(Object o) {
		inBox.push(o);
	}
	public Object dequeue() {
		if(outBox.isEmpty()) {
			while(!inBox.isEmpty()) {
				outBox.push(inBox.pop());
			}
		}
		return outBox.pop();
	}

}
