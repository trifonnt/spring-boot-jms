package lankydan.tutorial.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lankydan.tutorial.documents.OrderTransaction;

@RestController
@RequestMapping("/transaction")
public class OrderTransactionController {

	@Autowired
	private JmsTemplate jmsTemplate;

	@PostMapping("/send")
	public void send(@RequestBody OrderTransaction transaction) {
		System.out.println("Sending a transaction.");
		jmsTemplate.convertAndSend("OrderTransactionQueue", transaction);
	}
}
