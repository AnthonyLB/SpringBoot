package poe.spring;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	boolean a;
	float b;
	
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
    	Application f = new Application();
    	System.out.println(f.a+","+ f.b);
    	Map<String, List<String>> m = new HashMap();
    	m.put("bob", new ArrayList<>());
    	try(InputStream fis = new FileInputStream("")){
    		
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
