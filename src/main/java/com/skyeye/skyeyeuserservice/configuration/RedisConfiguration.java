package com.skyeye.skyeyeuserservice.configuration;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.Duration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableCaching
public class RedisConfiguration {

  @Bean
  public RedisCacheConfiguration cacheConfiguration() {
    ObjectMapper objectMapperC = new ObjectMapper();
    objectMapperC.registerModule(new JavaTimeModule());
    objectMapperC = objectMapperC.activateDefaultTyping(
        objectMapperC.getPolymorphicTypeValidator(),
        ObjectMapper.DefaultTyping.EVERYTHING,
        JsonTypeInfo.As.PROPERTY
    );

    return RedisCacheConfiguration.defaultCacheConfig()
        .entryTtl(Duration.ofMinutes(5))
        .disableCachingNullValues()
        .serializeValuesWith(
            SerializationPair.fromSerializer(
                new GenericJackson2JsonRedisSerializer(objectMapperC)
            )
        );
  }
}
