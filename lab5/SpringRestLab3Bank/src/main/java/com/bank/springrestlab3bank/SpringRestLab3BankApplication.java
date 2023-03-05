package com.bank.springrestlab3bank;

import com.bank.springrestlab3bank.controller.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication
public class SpringRestLab3BankApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestLab3BankApplication.class, args);
    }

    @Autowired
    private RestOperations restTemplate;
    private String serverUrl = "http://localhost:8080/banks";

    @Override
    public void run(String... args) throws Exception {
        // Add Account
        restTemplate.postForLocation(serverUrl, new AccountDTO(1234, "Sanjaya Koju"), AccountDTO.class);

        // Get Account
        AccountDTO accountDTO = restTemplate.getForObject(serverUrl+"/1234", AccountDTO.class);
        System.out.println("============= Account Detail =================");
        System.out.println(accountDTO);

        // Deposit Amount
        restTemplate.put(serverUrl+"/deposit?accountNumber=1234&amount=1000", AccountDTO.class);
        System.out.println("============== After Deposit =============");

        // Get Account
        AccountDTO accountDTO1 = restTemplate.getForObject(serverUrl+"/1234", AccountDTO.class);
        System.out.println(accountDTO1);

        // Withdraw Amount
        String uriString = UriComponentsBuilder.fromUriString(serverUrl+"/withdraw")
                .queryParam("accountNumber", 1234)
                .queryParam("amount", 500)
                .toUriString();

        restTemplate.put(uriString, AccountDTO.class);
        System.out.println("============== After Withdraw =============");

        // Get Account
        AccountDTO accountDTO2 = restTemplate.getForObject(serverUrl+"/1234", AccountDTO.class);
        System.out.println(accountDTO2);

        // Delete Account
        restTemplate.delete(serverUrl+"/1234");
        System.out.println("================ After Delete Account =============");

    }
}
