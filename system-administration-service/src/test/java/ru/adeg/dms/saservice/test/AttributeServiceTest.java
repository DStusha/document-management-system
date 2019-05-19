package ru.adeg.dms.saservice.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.adeg.dms.saservice.entity.Attribute;
import ru.adeg.dms.saservice.service.AttributeService;
import ru.adeg.dms.saservice.service.impl.AttributeServiceImpl;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AttributeServiceTest {

    @TestConfiguration
    static class AttributeServiceTestContextConfiguration {

        @Bean
        public AttributeServiceImpl attributeService() {
            return new AttributeServiceImpl();
        }
    }

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AttributeService attributeService;

    @Test
    public void testFindByName() {
        Attribute attribute = new Attribute("C++");
        entityManager.persist(attribute);
        List<Attribute> books = attributeService.getAll();
        assertEquals(1, books.size());
        assertThat(books).extracting(Attribute::getName).containsOnly("C++");
    }
}
