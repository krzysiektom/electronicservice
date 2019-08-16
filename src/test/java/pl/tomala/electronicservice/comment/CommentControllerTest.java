package pl.tomala.electronicservice.comment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CommentControllerTest {
    @InjectMocks
    CommentController tested;

    @Test
    public void home() {
        assertEquals("comments",tested.home());

    }
}