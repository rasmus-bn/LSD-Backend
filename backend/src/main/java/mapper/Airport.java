package mapper;

import org.modelmapper.ModelMapper;

public class Airport {
    ModelMapper modelMapper = new ModelMapper();
    contract.dto.Airport airportDTO = new contract.dto.Airport();

    entities.Airport airport = modelMapper.map(airportDTO, entities.Airport.class);
}
