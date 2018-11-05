import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

/**
 * If you use the @Mock annotation, you must trigger the creation of annotated objects. The MockitoRule allows this. It
 * invokes the static method MockitoAnnotations.initMocks(this) to populate the annotated fields. Alternatively you can
 * use @RunWith(MockitoJUnitRunner.class).
 *
 * @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoSample {

    @Test
    public void spyDemo() {
        List<String> spyList = spy(new ArrayList<>(Arrays.asList("a", "b", "c")));

        spyList.add("a");

        verify(spyList, times(1)).add("a");

        // partial mock
        // mock behavior with no return
        doAnswer(invocationOnMock -> spyList.add("w")).when(spyList).add("d");

        spyList.add("d");

        assertThat(spyList.contains("w"), is(true));
    }

    @Test
    public void callRealMethodInMock() {
        TestObject mockTestObject = mock(TestObject.class);

        when(mockTestObject.printA()).thenReturn("Mocked");
        when(mockTestObject.printB()).thenCallRealMethod();

        assertThat(mockTestObject.printA(), is("Mocked"));
        assertThat(mockTestObject.printB(), is(new TestObject().printB()));

    }

    @Test(expected = RuntimeException.class)
    public void mockThrowException() {
        List<String> mockList = (List<String>)mock(ArrayList.class);

        when(mockList.size()).thenThrow(new RuntimeException());

        mockList.size();
    }

    private static class TestObject {

        public String printA() {
            return "A";
        }

        public String printB() {
            return "B";
        }
    }

}
