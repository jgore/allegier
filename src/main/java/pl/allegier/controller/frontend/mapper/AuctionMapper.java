package pl.allegier.controller.frontend.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.AuctionDto;
import pl.allegier.model.Auction;
import pl.allegier.model.Bid;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Pawel Szczepkowski | Satlan on 10.08.17.
 */

@Component
public class AuctionMapper implements Mapper<AuctionDto, Auction> {

    private static final ModelMapper mapper = new ModelMapper();
    {
      //  mapper.addMappings(new AuctionMap());
    }

    public Auction toDao(AuctionDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Auction cannot be null");
        }
        return mapper.map(dto, Auction.class);
    }

    public AuctionDto toDto(Auction dao) {
        if (dao == null) {
            throw new IllegalArgumentException("Auction cannot be null");
        }
        AuctionDto map = mapper.map(dao, AuctionDto.class);
        return setBids(dao, map);
    }

    private AuctionDto setBids(Auction dao, AuctionDto map) {
        Set<Integer> bids = dao.getBids().stream().map(Bid::getId).collect(Collectors.toSet());
        map.setBids(bids);

        return map;
    }

    public  class AuctionMap extends PropertyMap<Auction, AuctionDto> {
        @Override
        protected void configure() {
            map().setBids(new HashSet<>());
            map().setCategory(null);
        }

    }
}
