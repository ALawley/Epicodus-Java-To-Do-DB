import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

public class CategoryTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Category.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfDescriptionsAretheSame() {
    Category firstCategory = new Category("Home");
    Category secondCategory = new Category("Home");
    assertTrue(firstCategory.equals(secondCategory));
  }

  @Test
  public void save_returnsTrueIfDescriptionsAretheSame() {
    Category myCategory = new Category("Home");
    myCategory.save();
    assertTrue(Category.all().get(0).equals(myCategory));
  }

  @Test
  public void save_assignsIdToObject() {
    Category myCategory = new Category("Home");
    myCategory.save();
    Category savedCategory = Category.all().get(0);
    assertEquals(myCategory.getId(), savedCategory.getId());
  }

  @Test
  public void find_findsCategoryInDatabase_true() {
    Category myCategory = new Category("Home");
    myCategory.save();
    Category savedCategory = Category.find(myCategory.getId());
    assertTrue(myCategory.equals(savedCategory));
  }
}
