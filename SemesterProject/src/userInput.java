import java.util.Scanner;
import java.time.localDate;
import java.time.format.DateTimeFormatter;
public class userInput {
	public static void main(String[] args) {
		System.out.println("Enter the day/time you want to countdown to : ");
		Scanner scanner = new Scanner(System.in);
		Object countDownDate = new dateChosen().getTime();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        int a = scanner.nextInt();
        System.out.println(a);
        scanner.close();
	
	}
}
