package pl.allegier.controller.frontend.mapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.allegier.TestConfiguration;
import pl.allegier.controller.dao.category.CategoryDao;
import pl.allegier.controller.frontend.dto.ProductDto;
import pl.allegier.model.Category;
import pl.allegier.model.Product;

import java.math.BigDecimal;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class ProductMapperTest implements MapperTest<ProductDto,Product>{

    private static final String TEST_TITLE = "gore";
    private static final String TEST_TITLE_2 = "gore";
    private static final String TEST_DESC = "gore1234";
    private static final BigDecimal TEST_PRICE = BigDecimal.ONE;

    @Autowired
    private Mapper<ProductDto,Product> productMapper;

    @Autowired
    private CategoryDao categoryDao;


    @Before
    public void setup()
    {
        Category category = new Category();
        category.setId("DOM");
        categoryDao.save(category);
    }

    @Test
    public void toEntityTest() {
        ProductDto dto = new ProductDto(TEST_TITLE, TEST_DESC, TEST_PRICE);
        dto.setCategory( "DOM" );
        Product dao = productMapper.toDao(dto);

        assertThat(dao.getCategory().getId(), equalTo(dto.getCategory()));
        assertThat(dao.getTitle(), equalTo(dto.getTitle()));
        assertThat(dao.getDescription(), equalTo(dto.getDescription()));
        assertThat(dao.getPrice(), equalTo(dto.getPrice()));
    }

    @Test
    public void toDtoTest() {
        Product dao = new Product(TEST_TITLE, TEST_DESC, TEST_PRICE);
        Category dom = categoryDao.findById("DOM");
        dao.setCategory(dom);
        ProductDto dto = productMapper.toDto(dao);

        assertThat(dao.getCategory().getId(), equalTo(dto.getCategory()));
        assertThat(dao.getTitle(), equalTo(dto.getTitle()));
        assertThat(dao.getDescription(), equalTo(dto.getDescription()));
        assertThat(dao.getPrice(), equalTo(dto.getPrice()));
    }



}