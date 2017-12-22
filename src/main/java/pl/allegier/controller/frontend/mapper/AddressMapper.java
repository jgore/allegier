package pl.allegier.controller.frontend.mapper;

import org.apache.log4j.Logger;
import pl.allegier.controller.frontend.dto.AddressDto;
import pl.allegier.model.Address;

public class AddressMapper implements Mapper<AddressDto, Address> {

    private static final Logger LOGGER = Logger.getLogger(AddressMapper.class);

    @Override
    public Address toDao(final AddressDto dto) {
        if (dto == null) {
            LOGGER.info("AddressDto is null");
            return null;
        }

        Address address = new Address();
        address.setCity(dto.getCity());
        address.setZipCode(dto.getZipCode());
        address.setStreetName(dto.getStreetName());
        address.setLocaleNumber(dto.getLocaleNumber());
        address.setStreetNumber(dto.getStreetNumber());
        return address;
    }

    @Override
    public AddressDto toDto(final Address address) {
        if (address == null) {
            LOGGER.info("Address is null");
            return null;
        }

        AddressDto dto = new AddressDto();
        dto.setCity(address.getCity());
        dto.setZipCode(address.getZipCode());
        dto.setStreetName(address.getStreetName());
        dto.setLocaleNumber(address.getLocaleNumber());
        dto.setStreetNumber(address.getStreetNumber());
        return dto;
    }
}
