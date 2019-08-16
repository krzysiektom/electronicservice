package pl.tomala.electronicservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

    @InjectMocks
    HomeController tested;

    @Test
    public void shouldHome() {
    assertEquals("Home page" ,tested.home());
    }
}