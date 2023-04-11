
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		RBTree myTree = new RBTree();
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean flag = true;
			while (flag) {
				try {
					String inp = bufferedReader.readLine();
					if (is_numeric(inp)) {
						myTree.addNode(Integer.parseInt(inp));
						System.out.println("ready");
					} else {
						flag = false;
					}
				} catch (Exception ignored) {
					System.out.println(ignored.getMessage());
					System.out.println("Repeat your enter");
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		myTree.printTree();
		
	}
	
	private static boolean is_numeric(String string) {
		return string.matches("^\\d+$");
	}
}