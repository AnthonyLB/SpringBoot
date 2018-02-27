package poe.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import poe.spring.delegate.PhoneNumberFormaterDelegateService;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneNumberFormaterDelegateServiceTest {

	@Test
	public void checkFormatOk() {
		String phone = "0600000000";
		String formated = PhoneNumberFormaterDelegateService.format(phone);
		assertThat(formated).isEqualTo(phone);
	}
	
	public void checkFormat33() {
		
	}
}
