package mg.mandresy.springSecurity.customer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "customer", target = "roles", qualifiedByName = "roles")
    CustomerDTO customerToCustomerDto(Customer customer);

    @Named("roles")
    default List<String> toListOfRoles(Customer customer) {
        return customer.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

}
