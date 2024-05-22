package com.skyeye.skyeyeuserservice.mappers;

import com.skyeye.skyeyeuserservice.model.UserIdCard;
import com.skyeye.skyeyeuserservice.model.UserIdCardRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserIdCardDataMapper {
  UserIdCardRecord sourceToDestination(UserIdCard source);
  UserIdCard destinationToSource(UserIdCardRecord destination);
}
