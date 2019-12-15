package mapper;

import org.modelmapper.ModelMapper;

public class Flight {
    ModelMapper modelMapper = new ModelMapper();
    contract.dto.Flight flightDTO = new contract.dto.Flight();

    entities.FlightInstance flight = modelMapper.map(flightDTO, entities.FlightInstance.class);  // FlightInstance --> Flight

}
