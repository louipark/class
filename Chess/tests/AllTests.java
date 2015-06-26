import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({ BoardTest.class, 
		KingTest.class, KnightTest.class, PawnTest.class, QueenTest.class,
		BishopTest.class, RookTest.class, Spec1Test.class, Spec2Test.class })
public class AllTests {

}
