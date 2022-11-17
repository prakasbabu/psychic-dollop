package com.prakash.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("employee")
public class Employee extends JdkSerializationRedisSerializer implements Serializable {
    @Id
    private int id;
    private String firstName;
    private String lastName;


}
