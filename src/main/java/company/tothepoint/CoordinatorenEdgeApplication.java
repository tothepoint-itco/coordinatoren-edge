package company.tothepoint;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
@EnableZuulProxy
//@EnableOAuth2Sso
public class CoordinatorenEdgeApplication {
	private static final String EDGE_ROUTING = "edge-routing";
	private static final String EDGE_QUEUE = "edge-queue";
	private static final String EDGE_EXCHANGE = "edge-exchange";

	public static void main(String[] args) {
		SpringApplication.run(CoordinatorenEdgeApplication.class, args);
	}
	@Bean
	String queueName() {
		return EDGE_QUEUE;
	}

	@Bean
	Queue queue() {
		return new Queue(EDGE_QUEUE, true, false, false);
	}
	@Bean
	Binding edgeBinding(Queue queue, TopicExchange edgeTopicExchange) {
		return BindingBuilder.bind(queue).to(edgeTopicExchange).with(EDGE_ROUTING);
	}
	@Bean
	TopicExchange edgeTopicExchange() {
		return new TopicExchange(EDGE_EXCHANGE, true, false);
	}

}
