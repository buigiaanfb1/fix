package helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

public class PasswordField {

	public static String readPassword(String prompt) {
		EraserThread et = new EraserThread(prompt);
		Thread mask = new Thread(et);
		mask.start();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String password = "";

		try {
			password = in.readLine();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		// stop masking
		et.stopMasking();
		// return the password entered by the user
		return password;
	}
}


