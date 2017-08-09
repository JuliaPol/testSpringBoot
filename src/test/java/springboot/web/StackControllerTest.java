package springboot.web;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import springboot.model.Website;
import springboot.service.WebsitesService;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StackControllerTest {
    @Mock
    private WebsitesService websitesService;

    @InjectMocks
    StackController sut;

//вместо InjectMocks
//    @Before
//    public void setUp() throws Exception {
//        sut = new StackController();
//    }

    @Test
    public void getListOfProviders() throws Exception {
        //prepare
        when(websitesService.findAll()).thenReturn(ImmutableList.of());
        //testing
        List<Website> listOfProviders = sut.getListOfProviders();
        //validate
        verify(websitesService).findAll();
    }

}