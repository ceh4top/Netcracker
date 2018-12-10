package netcracker.properties;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

    @Test
    void getProperty() {
        Property property = Config.getInstance();
        String sort = property.getProperty("PersonRepository.sort");
        assertNotNull(sort);
    }
}