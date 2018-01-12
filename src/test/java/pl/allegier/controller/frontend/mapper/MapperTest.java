package pl.allegier.controller.frontend.mapper;

/**
 * Created by Pawel Szczepkowski | GoreIT on 27.10.17.
 */
public interface MapperTest<DTO,ENTITY> {
    void toDtoTest();
    void toEntityTest();
}
