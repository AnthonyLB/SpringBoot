package poe.spring.delegate;

public class PhoneNumberFormaterDelegateService {

	public static String format(String number) {
		String formatedNumber;
		formatedNumber = number.replaceAll("\\+33", "0");
		return formatedNumber;
	}
}
