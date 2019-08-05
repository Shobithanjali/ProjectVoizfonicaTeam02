package com.example.voiz_team02;

import com.example.voiz_team02.data.DongleRepository;
import com.example.voiz_team02.data.PostpaidRepositary;
import com.example.voiz_team02.data.PrepaidRepository;
import com.example.voiz_team02.data.Regstrationrepo;
import com.example.voiz_team02.model.DonglePlans;
import com.example.voiz_team02.model.Postpaidplan;
import com.example.voiz_team02.model.PrepaidPlans;
import com.example.voiz_team02.model.regstration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.voiz_team02.data")
public class VoizTeam02Application {

    public static void main(String[] args) {
        SpringApplication.run(VoizTeam02Application.class, args);
    }
    @Bean
    public CommandLineRunner dataLoader(DongleRepository repo, PrepaidRepository repo1, PostpaidRepositary repo2, Regstrationrepo repo3) {
        repo.deleteAll();
        repo1.deleteAll();
        repo2.deleteAll();
        repo3.deleteAll();
        return args -> {
            repo.save(new DonglePlans("ABC", "RS 598 PER MONTH", "200GB"));
            repo.save(new DonglePlans("DEF", "RS 748 PER MONTH", "300G"));
            repo1.save(new PrepaidPlans("10", "RS 200 PER MONTH"));
            repo1.save(new PrepaidPlans("11", "RS 250 PER MONTH"));
            repo1.save(new PrepaidPlans("12", "RS 300 PER MONTH"));
            repo1.save(new PrepaidPlans("13", "RS 350 PER MONTH"));
            repo2.save(new Postpaidplan("plan1","Rs.249", "3G/4G - 75Gb","Local/Std Unlimited"));
            repo2.save(new Postpaidplan("plan2", "Rs 449", "3G/4G - 125Gb", "Local/Std Unlimited"));
            repo2.save(new Postpaidplan("plan3", "Rs 749", "3G/4G - 150Gb","Local/Std Unlimited"));
            repo3.save(new regstration());
            repo3.save(new regstration());
            repo3.save(new regstration());

        };
    }


}
