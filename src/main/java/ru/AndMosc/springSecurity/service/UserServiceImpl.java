package ru.AndMosc.springSecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.AndMosc.springSecurity.entity.Authorities;
import ru.AndMosc.springSecurity.entity.User;
import ru.AndMosc.springSecurity.repository.UserRepository;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public boolean saveUser(User userForm) {
        User user = userRepository.findByUsername(userForm.getUsername());

        if (user != null) {
            return false;
        }
        userForm.setEnabled((short) 1);
        userForm.setAuthority(Collections.singleton(new Authorities((userForm.getUsername()),"ROLE_USER")));
        userForm.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
        userRepository.save(userForm);
        return true;
    }
}
