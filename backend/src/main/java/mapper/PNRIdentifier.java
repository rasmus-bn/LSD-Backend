package mapper;

import contract.dto.FFNCCIdenitfier;
import entities.Booking;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class PNRIdentifier {
    ModelMapper modelMapper = new ModelMapper();
    contract.dto.PNRIdentifier pnrIdentifier = new contract.dto.PNRIdentifier();

    PropertyMap<Booking, contract.dto.PNRIdentifier> pnrMap = new PropertyMap<Booking, contract.dto.PNRIdentifier>() {
        @Override
        protected void configure() {
            map().setPnr(source.getPnr());
        }
    };
}
