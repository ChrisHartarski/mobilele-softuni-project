package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.data.dto.RegisterUserDTO;
import bg.softuni.mobilele.data.entity.User;
import bg.softuni.mobilele.data.repository.UserRepository;
import bg.softuni.mobilele.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    private ModelMapper modelMapper;
    private UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(@Valid RegisterUserDTO registerUserDTO) {
        userRepository.saveAndFlush(map(registerUserDTO));
    }

    private User map(RegisterUserDTO registerUserDTO) {
        User user = modelMapper.map(registerUserDTO, User.class);
        user.setActive(true);
        user.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        user.setModified(user.getCreated());
        return user;
    }
}
