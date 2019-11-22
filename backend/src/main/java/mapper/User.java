package mapper;

import org.modelmapper.ModelMapper;

public class User {
    ModelMapper modelMapper = new ModelMapper();
    contract.dto.User userDTO = new contract.dto.User();

    entities.User user = modelMapper.map(userDTO, entities.User.class);
}
