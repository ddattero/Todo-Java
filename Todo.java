import java.util.*;
import java.io.*;

public class Todo {
	public static void main (String args[]) {
		TaskList t = read();
		
		printCommands();
		
		String input;
		
		Scanner scan = new Scanner(System.in);
				
		boolean cont = true;
		
		while (cont) {
			
			t.print();

			input = scan.nextLine();
						
			
			if (input.substring(0, 1).equals("a")) {
				t.add(input.substring(2));
			}
			else if (input.substring(0, 1).equals("r")) {
				if (input.substring(1, 2).equals("c")) {
					t.removeCompleted();
				}
				else {
					t.remove(Integer.parseInt(input.substring(2)));
				}
			}
			else if (input.substring(0, 1).equals("c")) {
				t.complete(Integer.parseInt(input.substring(2)));
			}
			else if (input.substring(0, 1).equals("u")) {
				t.uncomplete(Integer.parseInt(input.substring(2)));
			}
			else if (input.substring(0, 1).equals("e")) {
				cont = false;
			}
			else {
				System.out.println("Invalid command");
			}
			
			System.out.println();
			
			try {
				save(t);
			}
			catch (IOException i) {
				i.printStackTrace();
			}
			
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
	
	static TaskList read() {
		TaskList t = null;

		try {
			FileInputStream fis = new FileInputStream("todo-list.tmp");
			ObjectInputStream ois = new ObjectInputStream(fis);
			t = (TaskList) ois.readObject();
			ois.close();
			fis.close();
			
			return t;
		}
		catch (EOFException e) {
			return t = new TaskList();
		}
		catch (IOException i){
			i.printStackTrace();
			return t;
		}
		catch (ClassNotFoundException c) {
			System.out.println("TaskList class not found");
			c.printStackTrace();
			return t;
		}

	}
	
	
	static void save(TaskList t) throws IOException {
	      FileOutputStream fos = new FileOutputStream("todo-list.tmp");
	      ObjectOutputStream oos = new ObjectOutputStream(fos);
	      
	      oos.writeObject(t);
	      
	      oos.close();
	      fos.close();
	}
	
}
