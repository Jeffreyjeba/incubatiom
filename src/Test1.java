

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import utility.Marker;

@RunWith(Categories.class)
@Categories.IncludeCategory(Marker.class)
@SuiteClasses({ nullCheck.class})
public class Test1 {

}
