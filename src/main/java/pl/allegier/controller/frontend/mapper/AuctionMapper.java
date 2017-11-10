package pl.allegier.controller.frontend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.AuctionDto;
import pl.allegier.model.Auction;
import pl.allegier.model.Bid;
import pl.allegier.model.Category;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */

@Component
public class AuctionMapper implements Mapper<AuctionDto, Auction> {

    private  final ModelMapper mapper = new ModelMapper();

    public AuctionMapper() {
    }

    public Auction toDao(AuctionDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Auction cannot be null");
        }
        Auction map = mapper.map(dto, Auction.class);
        setCategory(dto, map);
        setBids(dto,map);

        return map;
    }

    public AuctionDto toDto(Auction dao) {
        if (dao == null) {
            throw new IllegalArgumentException("Auction cannot be null");
        }
        AuctionDto map = mapper.map(dao, AuctionDto.class);
        map.setCategory(dao.getCategory().getId());
        return setBids(dao, map);
    }

    private Auction setBids(AuctionDto dto, Auction map) {
        Category category = new Category();
        category.setId( dto.getCategory());
        map.setCategory( category );

        return map;
    }

    private Auction setCategory(AuctionDto dto, Auction map) {
        Category category = new Category();
        category.setId( dto.getCategory() );
        map.setCategory( category );

        return map;
    }

    private AuctionDto setBids(Auction dao, AuctionDto map) {
        Set<Integer> bids = dao.getBids().stream().map(Bid::getId).collect(Collectors.toSet());
        map.setBids(bids);

        return map;
    }


}
