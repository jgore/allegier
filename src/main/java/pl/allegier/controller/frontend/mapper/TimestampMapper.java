package pl.allegier.controller.frontend.mapper;

import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.TimeStampDto;
import pl.allegier.model.timestamp.Timestamp;

@Component
public class TimestampMapper {

    public Timestamp toDao(final Timestamp timestamp, final TimeStampDto dto) {
        timestamp.setCreated(dto.getCreated());
        timestamp.setUpdated(dto.getUpdated());
        return timestamp;
    }

    public TimeStampDto toDto(final TimeStampDto dto, final Timestamp timestamp) {
        dto.setCreated(timestamp.getCreated());
        dto.setUpdated(timestamp.getUpdated());
        return dto;
    }
}
