package com.skyeye.skyeyeuserservice.service;

import com.skyeye.skyeyeuserservice.exception.NoSuchUserException;
import com.skyeye.skyeyeuserservice.model.UserIdCardRecord;
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

  final UserIdCardRepository userIdCardRepository;

  @Cacheable(key = "#userId")
  public UserIdCardRecord getUserIdCardByUserid(String userId) {
    log.info("DB call with id {}", userId);
    return userIdCardRepository.findByUserId(UUID.fromString(userId))
        .orElseThrow(() -> new NoSuchUserException(userId));
  }

}
