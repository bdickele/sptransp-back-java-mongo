package org.bdickele.sptransp.security;

import org.bdickele.sptransp.domain.UserProfile;
import org.bdickele.sptransp.dto.UserDTO;
import org.bdickele.sptransp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bertrand DICKELE
 */
@Service
public class SpTranspUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDTO user = repository.findByUid(userName);

        if (user==null) throw new UsernameNotFoundException("User with UID " + userName + " was not found");

        UserProfile userProfile = UserProfile.getByCode(user.getProfileCode());

        List<GrantedAuthority> authorities = userProfile.getRoles().stream()
                .map(r -> new SimpleGrantedAuthority(r.getCode()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getUid(),
                user.getPassword(),
                authorities);
    }
}
