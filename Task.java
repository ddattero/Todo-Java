
//a class for a task
public class Task implements java.io.Serializable {

	String name;
	boolean completed;
	
	//Constructor takes a string and set the name to that string
	//completed is false by default
	Task(String n) {
		name =  n;
		completed = false;
	}
	
	//returns the title
	String getName() {
		return name;
	}
	
	//returns whether or not the task is completed
	boolean isComplete() {
		return completed;
	}
	
	//makes completed true
	void complete() {
		completed = true;
	}
	
	//make completed false
	void uncomplete() {
		completed = false;
	}
	
	//prints the task out on a line
	void print() {
		char compChar;
		
		if (completed) {
			compChar = 'x';
		}
		else {
			compChar = ' ';
		}
		
		System.out.println("[" + compChar + "] " + name);
	}
}
