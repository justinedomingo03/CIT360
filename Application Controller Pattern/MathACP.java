import java.util.HashMap;

public class MathACP {
	public static HashMap<String,Math>
	hashMapOfCommands = new HashMap<String,Math>();
	
	public static void MyACP() {
		
	}
	
	public static void handleCommand(String command, Integer num1, Integer num2){
		hashMapOfCommands.put("+",  new MathAdd());
		hashMapOfCommands.put("-",  new MathSubtract());
		hashMapOfCommands.put("*",  new MathMultiply());
		hashMapOfCommands.put("/",  new MathDivide());
		
		Math handler = hashMapOfCommands.get(command);
		handler.execute(num1, num2);
	}
}
