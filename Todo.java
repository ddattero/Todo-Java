import java.util.*;

public class Todo {
	public static void main (String args[]) {
		TaskList t = new TaskList();
		
		printCommands();
		
		String input;
		
		Scanner scan = new Scanner(System.in);
				
		boolean cont = true;
		
		while (cont) {
			input = scan.nextLine();
						
			
			if (input.substring(0, 2).equals("a ")) {
				t.add(input.substring(2));
			}
			else if (input.substring(0, 2).equals("r ")) {
				t.remove(Integer.parseInt(input.substring(2)));
			}
			else if (input.substring(0, 2).equals("c ")) {
				t.complete(Integer.parseInt(input.substring(2)));
			}
			else if (input.substring(0, 2).equals("u ")) {
				t.uncomplete(Integer.parseInt(input.substring(2)));
			}
			else if (input.substring(0, 1) == "e") {
				cont = false;
			}
			else {
				System.out.println("Invalid command");
			}
			
			System.out.println();
			
			t.print();
		}
		
		scan.close();

	}
	
	
	static void printCommands() {
		System.out.println("a \'name\': add a task with name");
		System.out.println("r \'n\': remove task n");
		System.out.println("c \'n\': complete task n");
		System.out.println("u \'n\': uncomplete task n");
		System.out.println("e: end the program");

	}
	
}
