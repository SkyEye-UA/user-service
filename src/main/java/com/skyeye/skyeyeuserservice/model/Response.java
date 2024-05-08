package com.skyeye.skyeyeuserservice.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skyeye.skyeyeuserservice.serializers.UserDataSerializer;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
@JsonSerialize(using = UserDataSerializer.class)
public class Response<T> {

  private final T data;
  private final HttpStatus code;
}
