package mapper;

import org.modelmapper.ModelMapper;

public class Passenger {
    ModelMapper modelMapper = new ModelMapper();
    contract.dto.Passenger passengerDTO = new contract.dto.Passenger();

    entities.Ticket passenger = modelMapper.map(passengerDTO, entities.Ticket.class);  // Passenger --> Ticket
}
