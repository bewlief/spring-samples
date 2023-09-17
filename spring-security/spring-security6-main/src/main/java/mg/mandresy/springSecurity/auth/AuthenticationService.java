package mg.mandresy.springSecurity.auth;

import lombok.AllArgsConstructor;
import mg.mandresy.springSecurity.customer.Customer;
import mg.mandresy.springSecurity.customer.CustomerDTO;
import mg.mandresy.springSecurity.customer.CustomerMapper;
import mg.mandresy.springSecurity.security.jwt.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final CustomerMapper mapper;

    public AuthenticationResponse login(AuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        var principal = (Customer) authentication.getPrincipal();
        CustomerDTO customerDTO = mapper.customerToCustomerDto(principal);
        String token = jwtUtil.issueToken(customerDTO.username(), customerDTO.roles());
        return new AuthenticationResponse(token, customerDTO);
    }

}
