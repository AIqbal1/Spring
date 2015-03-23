package om.iavaab.sip;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RabbitConfigurationMain {
	  public static void main(String args[]) {
		  ApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfiguration.class);
		  AmqpTemplate template = context.getBean(AmqpTemplate.class);

		  template.convertAndSend("myqueue", "foo");

		  String foo = (String) template.receiveAndConvert("myqueue");	
		  
		  System.out.println(foo);
		  
	  }
}
