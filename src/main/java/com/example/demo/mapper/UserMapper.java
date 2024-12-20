package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.request.UserRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(target = "id", ignore = true)
    User userRequestToUser(UserRequest userRequest);

    UserDto userToUserDto(User user);

    UserResponse userDtoToUserResponse(UserDto userDto);
}
