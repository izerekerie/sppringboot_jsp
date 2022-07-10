package  com.example.school_management_system.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.school_management_system.models.User;
import com.example.school_management_system.repositories.IUserRepository;

@Service
public class UserDetailsServiceExtender implements UserDetailsService {

    private final IUserRepository userRepository;

    @Autowired
    public UserDetailsServiceExtender(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s).orElseThrow(() -> new UsernameNotFoundException("Invalid Credentials"));
        return UserPrinciple.create(user);
    }

    @Transactional
    public UserDetails loadByUserId(long id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return UserPrinciple.create(user);
    }
}
