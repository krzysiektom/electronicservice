package pl.tomala.electronicservice.warehouse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class WarehouseControllerTest {

    @InjectMocks
    WarehouseController tested;

    @Test
    public void shouldHome() {
        assertEquals("warehouse", tested.home());
    }
}