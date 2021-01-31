//-----------------------------------------------------
// Title: Calc
// Author: Ömer Görkem Canıdemir
// ID: 13177246034
// Section: 2
// Assignment: 1 Part_2
// Description: This class has the main method to run calculator.
//-------------------------------------------------

import java.util.Scanner;

//Calc class extends the Stack class to use Node constructor.
public class Calc extends Stack<Integer> {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Stack<Integer> operandDepot = new Stack<Integer>();
		String input;
		// It check the first part of the input and do the latter according to that.
		do {
			input = keyboard.nextLine();
			String[] splittedInput = input.split(" ");
			switch (splittedInput[0]) {
			// It prints out all the items in the stack.
			case "S":
				try {
					Node temp = operandDepot.getFirst();
					System.out.print("[" + temp.getItem());
					for (int i = 0; i < operandDepot.getSize() - 1; i++) {
						temp = temp.getNext();
						System.out.print(", " + temp.getItem());
					}
					System.out.println("]");
				} catch (Exception e) {
					System.out.println("[]");
				}
				break;
			// It prints out and pops the last item in the stack.
			case "P":
				try {
					int temp = operandDepot.pop();
					System.out.println(temp);
				} catch (Exception e) {
					System.out.println("Stack is empty. Please add operands.");
				}
				break;
			// It adds the last two item in the stack.
			case "+":
				try {
					int operand1 = operandDepot.pop();
					int operand2 = operandDepot.pop();
					operandDepot.push(operand2 + operand1);
				} catch (Exception e) {
					System.out.println("There is not enough number in the depot. Please first enter the numbers.");
				}
				break;
			// It subtracts the last two item in the stack.
			case "-":
				try {
					int operand1 = operandDepot.pop();
					int operand2 = operandDepot.pop();
					operandDepot.push(operand2 - operand1);
				} catch (Exception e) {
					System.out.println("There is not enough number in the depot. Please first enter the numbers.");
				}
				break;
			// It multiplies the last two item in the stack.
			case "*":
				try {
					int operand1 = operandDepot.pop();
					int operand2 = operandDepot.pop();
					operandDepot.push(operand2 * operand1);
				} catch (Exception e) {
					System.out.println("There is not enough number in the depot. Please first enter the numbers.");
				}
				break;
			// It divides the last two item in the stack.
			case "/":
				try {
					int operand1 = operandDepot.pop();
					int operand2 = operandDepot.pop();
					operandDepot.push(operand2 / operand1);
				} catch (Exception e) {
					System.out.println("There is not enough number in the depot or Tried to divide 0.");
				}
				break;
			// It gets the written input and pushes into the stack.
			default:
				if (!splittedInput[0].equalsIgnoreCase("E")) {
					try {
						for (String s : splittedInput) {
							int inputInt = Integer.parseInt(s);
							operandDepot.push(inputInt);
						}
					} catch (Exception e) {
						System.out.println("Please Enter the Operation or a operand.");
					}
				}
			}
		} while (!input.equalsIgnoreCase("E"));
		keyboard.close();
	}
}
