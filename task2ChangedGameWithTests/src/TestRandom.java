import org.junit.Assert;
import org.junit.Test;

public class TestRandom {
    //@Rule
    //public RepeatRule repeatRule = new RepeatRule();

    @Test
    //@Repeat(10)
    public void testRandom100(){
        int  testValue = 0;
        Model model=new Model();
            testValue = model.randomNumber();
            Assert.assertEquals(testValue, 100);
        }

    @Test
    //@Repeat(10)
    public void testRandom0(){
        int  testValue = 0;
        Model model=new Model();
        testValue = model.randomNumber();
        Assert.assertEquals(testValue, 0);
    }
//    @Test
//    //@Repeat(10)
//    public void testRandom50(){
//        int  testValue = 0;
//        Model model=new Model();
//        testValue = model.randomNumber();
//        Assert.assertEquals(testValue, 50);
//    }
    }

