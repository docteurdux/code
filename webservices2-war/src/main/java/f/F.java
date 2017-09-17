package f;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.example.myservice.HelloWorld;

@WebService(endpointInterface = "com.example.myservice.HelloWorld")
public class F implements HelloWorld {

	@Override
	@WebMethod
	public String sayHello() {
		return "Hello from " + this.getClass().getName();
	}

}
