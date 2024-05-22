package com.skyeye.skyeyeuserservice.service;

import com.skyeye.skyeyeuserservice.exception.NoSuchUserException;
import com.skyeye.skyeyeuserservice.mappers.UserIdCardDataMapper;
import com.skyeye.skyeyeuserservice.model.UserData;
import com.skyeye.skyeyeuserservice.model.UserIdCard;
import com.skyeye.skyeyeuserservice.model.UserIdCardRecord;
import com.skyeye.skyeyeuserservice.repo.UserDataRepository;
import com.skyeye.skyeyeuserservice.repo.UserIdCardRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "useridcard")
@Service
@RequiredArgsConstructor
@Slf4j
public class UserIdCardService {

  final UserIdCardDataMapper userIdCardDataMapper;
  final UserIdCardRepository userIdCardRepository;
  final UserDataRepository userDataRepository;

  @Cacheable(key = "#userId")
  public UserIdCardRecord getUserIdCardByUserid(String userId) {
    log.info("DB call with userId {}", userId);
    return userIdCardRepository.findByUserId(UUID.fromString(userId))
        .orElseThrow(() -> new NoSuchUserException(userId));
  }

  public UserIdCardRecord saveIdCard(String userId, UserIdCardRecord userIdCardRecord) {
    log.info("DB call with userId 22 {}", userId);

    UserData userData = userDataRepository.findById(UUID.fromString(userId))
        .orElseThrow(() -> new NoSuchUserException(userId));
    UserIdCard idCard = userIdCardDataMapper.destinationToSource(userIdCardRecord);
    userData.setUserIdCard(idCard);

    return userIdCardDataMapper.sourceToDestination(
        userDataRepository.save(userData).getUserIdCard()
    );
  }
}
