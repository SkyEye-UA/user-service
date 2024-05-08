package com.skyeye.skyeyeuserservice.model;

import java.util.UUID;

public record UserDataRecord(
    UUID id,
    String firstName,
    String middleName,
    String lastName,
    String callSign,
    String email,
    String phoneNumber,
    String imageUrl
) {}