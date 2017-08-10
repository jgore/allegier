package pl.allegier.controller.frontend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.AuctionDto;
import pl.allegier.model.Auction;

/**
 * Created by Pawel Szczepkowski | Satlan on 10.08.17.
 */

@Component
public class AuctionMapper implements Mapper<AuctionDto,Auction> {

    private static final ModelMapper mapper = new ModelMapper();

    public Auction fromDto(AuctionDto dto) {
        if( dto == null)
        {
            throw new IllegalArgumentException("Auction cannot be null");
        }
        return mapper.map(dto, Auction.class);
    }

    public AuctionDto fromDao(Auction dao) {
        if( dao == null)
        {
            throw new IllegalArgumentException("Auction cannot be null");
        }
        return mapper.map(dao, AuctionDto.class);
    }
}
