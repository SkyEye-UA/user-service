package com.skyeye.skyeyeuserservice;

import com.skyeye.skyeyeuserservice.model.UserData;
import com.skyeye.skyeyeuserservice.model.UserIdCard;
import com.skyeye.skyeyeuserservice.repo.UserDataRepository;
import java.time.ZonedDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class SkyeyeUserServiceApplication {

  @Autowired
  private UserDataRepository userDataRepository;

  public static void main(String[] args) {
    SpringApplication.run(SkyeyeUserServiceApplication.class, args);
  }

  @Bean
  @ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
  public CommandLineRunner demoCommandLineRunner() {
    return args -> {

      UserData userData = UserData.builder()
          .firstName("Володимир")
          .middleName("")
          .lastName("Пілот")
          .middleName("Люк Скайуокер")
          .email("example@example.com")
          .phoneNumber("+380111111111")
          .imageUrl("https://gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50?s=400")
          .build();

     UserIdCard userIdCard1 = UserIdCard
          .builder()
          .code("https://example.com/example/d749eaf3208e4732027b07ef1a2f2add53041a3b")
          .issueDate(ZonedDateTime.now())
          .expiryDate(ZonedDateTime.now())
          .title("Володимир Пілот")
          .build();

      userData.setUserIdCard(userIdCard1);

      UserData saved = userDataRepository.save(userData);

      log.info("Inserted data with id {}", saved.getId());
    };
  }

}
