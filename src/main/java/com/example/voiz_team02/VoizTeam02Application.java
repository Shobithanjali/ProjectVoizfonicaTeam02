package com.example.voiz_team02;

import com.example.voiz_team02.data.DongleRepository;
import com.example.voiz_team02.data.PostpaidRepositary;
import com.example.voiz_team02.data.PrepaidRepository;
import com.example.voiz_team02.data.Regstrationrepo;
import com.example.voiz_team02.model.DonglePlans;
import com.example.voiz_team02.model.PostpaidPlan;
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
            repo.save(new DonglePlans("ABC", "Dongle:RS 598/MONTH", "200GB"));
            repo.save(new DonglePlans("DEF", "Dongle:RS 748/MONTH", "300GB"));
            repo.save(new DonglePlans("PR01","Dongle Purchase","Warranty: 2 years"));
            repo1.save(new PrepaidPlans("10", "Prepaid:RS 200/MONTH"));
            repo1.save(new PrepaidPlans("11", "Prepaid:RS 250/MONTH"));
            repo1.save(new PrepaidPlans("12", "Prepaid:RS 300/MONTH"));
           /* repo1.save(new PrepaidPlans("13", "RS 350 PER MONTH"));*/
            repo2.save(new PostpaidPlan("plan1","Postpaid:Rs.249", "3G/4G - 75Gb","Local/Std Unlimited"));
            repo2.save(new PostpaidPlan("plan2", "Postpaid:Rs 449", "3G/4G - 125Gb", "Local/Std Unlimited"));
            repo2.save(new PostpaidPlan("plan3", "Postpaid:Rs 749", "3G/4G - 150Gb","Local/Std Unlimited"));
            repo3.save(new regstration());
            repo3.save(new regstration());
            repo3.save(new regstration());

        };
    }


}
