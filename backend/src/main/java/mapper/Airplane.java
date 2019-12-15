package mapper;

import org.modelmapper.ModelMapper;

public class Airplane {
    contract.dto.Airplane airplaneDTO = new contract.dto.Airplane();

    ModelMapper modelMapper = new ModelMapper();
    entities.Flight airplane = modelMapper.map(airplaneDTO, entities.Flight.class); // Flight --> Airplane
}
