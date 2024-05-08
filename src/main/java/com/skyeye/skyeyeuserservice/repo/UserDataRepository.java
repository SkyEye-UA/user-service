package com.skyeye.skyeyeuserservice.repo;

import com.skyeye.skyeyeuserservice.model.UserData;
import com.skyeye.skyeyeuserservice.model.UserDataRecord;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDataRepository extends JpaRepository<UserData, UUID> {

  @Query("SELECT new com.skyeye.skyeyeuserservice.model.UserDataRecord("
      + "ud.id, ud.firstName, ud.middleName, ud.lastName, "
      + "ud.callSign, ud.email, ud.phoneNumber,ud.imageUrl)"
      + " FROM UserData ud WHERE ud.id = :userId")
  Optional<UserDataRecord> findByUserId(@Param("userId") UUID userid);
}
