package utils;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.app.core.Customer;

import static com.app.validation.ValidationRules.validateall;

public class CustomerUtils {

	public static Map<String, Customer> populateMess() 
	{
		Map<String, Customer> map= new HashMap<>();
		List<Customer> list= new ArrayList<>();
		
		try 
		{
		list.add(validateall("soham","mehta","mehtasoham01@gmail.com","mehta","b104","8459377727","monthly",3000,map));
		list.add(validateall("deep","kumar","jassilassi69@gmail.com","bacchu","c201","7425880496","monthly",3000,map));
		list.add(validateall("kaivalya","joshi","kaivalya02@gmail.com","bachhi","c104","8456745587","yearly",32000,map));
		list.add(validateall("krishna","mahajan","skpandacodes@gmail.com","deep","b302","9759379421","quarterly",11700,map));
		list.add(validateall("prasad","singatkar","sleepy247@gmail.com","sleep","a101","8459321299","quarterly",11700,map));
		list.add(validateall("suyash","kolhe","skolhe05@gmail.com","kolhe","b305","8793580449","half_yearly",17500,map));
		list.add(validateall("sahil","patil","spatil01@gmail.com","ssss","a111","7666307727","monthly",3000,map));
		list.add(validateall("siddharth","ghase","sidd01@gmail.com","sidd","b203","8436234627","monthly",3000,map));
		list.add(validateall("soham","mehta","mehtasoham01@gmail.com","mehta","b104","8459377727","monthly",3000,map));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		list.forEach(p->map.put(p.getEmail(),p));
		
		return map;
	}
}
