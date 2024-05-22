package com.skyeye.skyeyeuserservice.model;

import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

public record UserDataRecord(
    UUID id,
    @NotBlank
    String firstName,
    String middleName,
    @NotBlank
    String lastName,
    String callSign,
    String email,
    String phoneNumber,
    String imageUrl
) {}