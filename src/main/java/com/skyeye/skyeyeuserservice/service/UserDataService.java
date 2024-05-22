package com.skyeye.skyeyeuserservice.service;

import com.skyeye.skyeyeuserservice.exception.NoSuchUserException;
import com.skyeye.skyeyeuserservice.mappers.UserDataMapper;
import com.skyeye.skyeyeuserservice.model.UserData;
import com.skyeye.skyeyeuserservice.model.UserDataRecord;
import com.skyeye.skyeyeuserservice.repo.UserDataRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "userdata")
@Service
@RequiredArgsConstructor
@Slf4j
public class UserDataService {
  final UserDataMapper userDataMapper;
  final UserDataRepository userDataRepository;

  @Cacheable(key = "#id")
  public UserDataRecord getUserData(String id) {
    log.info("Hitting db for user id {}", id);
    return userDataRepository.findById(UUID.fromString(id))
        .map(userDataMapper::sourceToDestination)
        .orElseThrow(() -> new NoSuchUserException(id));
  }

  public UserDataRecord saveUser(UserDataRecord userDataRecord) {
    return userDataMapper.sourceToDestination(
        userDataRepository.save(
            userDataMapper.destinationToSource(userDataRecord)
        )
    );
  }

}
