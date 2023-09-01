package tn.stb.mstransaction_log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsTransactionLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTransactionLogApplication.class, args);
	}

}
