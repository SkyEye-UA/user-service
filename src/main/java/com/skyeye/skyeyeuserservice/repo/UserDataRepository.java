package com.skyeye.skyeyeuserservice.repo;

import com.skyeye.skyeyeuserservice.model.UserData;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, UUID> { }
