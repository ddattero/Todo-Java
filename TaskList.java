import java.util.ArrayList;

//a list of tasks, with associated functions for a todo list
public class TaskList {
	ArrayList<Task> tasks;
	
	//creates a new
	TaskList() {
		tasks = new ArrayList<Task>();
	}
	
	//adds a new task at the end of the list
	void add(Task t) {
		tasks.add(t);
	}
	
	void add(String n) {
		tasks.add(new Task(n));
	}
	
	//removes the task at index x-1;
	void remove(int x) {
		x = x - 1;
		tasks.remove(x);
	}
	
	//completes task at index x-1
	void complete (int x) {
		x = x - 1;
		tasks.get(x).complete();
	}
	
	//uncompletes task at index x-1
	void uncomplete (int x) {
		x = x - 1;
		tasks.get(x).uncomplete();
	}
	
	//prints the list
	void print() {
		System.out.println("==================================================================================");
		for (int i = 0; i < tasks.size(); i++) {
			System.out.print((i + 1) + " ");
			tasks.get(i).print();
		}
		System.out.println("==================================================================================");

	}
	
	
}