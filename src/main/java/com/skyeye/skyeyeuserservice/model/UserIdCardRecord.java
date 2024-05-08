package com.skyeye.skyeyeuserservice.model;

import java.time.ZonedDateTime;

public record UserIdCardRecord(
    String code,
    ZonedDateTime issueDate,
    ZonedDateTime expiryDate,
    String title
){}
