package mg.mandresy.springSecurity.auth;

import mg.mandresy.springSecurity.customer.CustomerDTO;

public record AuthenticationResponse(String token, CustomerDTO customerDto) {
}
