package pl.allegier.controller.frontend.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.allegier.TestConfiguration;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.model.Product;

import java.math.BigDecimal;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class ProductMapperTest implements MapperTest<ProductDto,Product>{

    private static final String TEST_TITLE = "gore";
    private static final String TEST_TITLE_2 = "gore";
    private static final String TEST_DESC = "gore1234";
    private static final BigDecimal TEST_PRICE = BigDecimal.ONE;

    @Autowired
    private Mapper<ProductDto, Product> productMapper;

    @Test
    public void toEntityTest() {
        ProductDto dto = new ProductDto(TEST_TITLE, TEST_DESC, TEST_PRICE);
        Product dao = productMapper.toDao(dto);

        assertThat(dao.getTitle(), equalTo(dto.getTitle()));
        assertThat(dao.getDescription(), equalTo(dto.getDescription()));
        assertThat(dao.getPrice(), equalTo(dto.getPrice()));
    }

    @Test
    public void toDtoTest() {
        Product dao = new Product(TEST_TITLE, TEST_DESC, TEST_PRICE);
        ProductDto dto = productMapper.toDto(dao);

        assertThat(dao.getTitle(), equalTo(dto.getTitle()));
        assertThat(dao.getDescription(), equalTo(dto.getDescription()));
        assertThat(dao.getPrice(), equalTo(dto.getPrice()));
    }



}