package pl.allegier.controller.frontend.mapper;

import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.BaseDto;
import pl.allegier.model.timestamp.Timestamp;

@Component
public class TimestampMapper {

    public Timestamp toDao(final Timestamp timestamp, final BaseDto dto) {
        timestamp.setCreated(dto.getCreated());
        timestamp.setUpdated(dto.getUpdated());
        return timestamp;
    }

    public BaseDto toDto(final BaseDto dto, final Timestamp timestamp) {
        dto.setCreated(timestamp.getCreated());
        dto.setUpdated(timestamp.getUpdated());
        return dto;
    }
}
