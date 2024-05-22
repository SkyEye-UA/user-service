package com.skyeye.skyeyeuserservice.mappers;

import com.skyeye.skyeyeuserservice.model.UserData;
import com.skyeye.skyeyeuserservice.model.UserDataRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDataMapper {
  UserDataRecord sourceToDestination(UserData source);
  UserData destinationToSource(UserDataRecord destination);
}
