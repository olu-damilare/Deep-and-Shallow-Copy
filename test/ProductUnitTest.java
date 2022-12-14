import com.java.deepandshallowcopy.Product;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;

public class ProductUnitTest {

    @Test
    void whenRemoveFromOriginalObject_thenRemoveFromShallowCopiedDuplicate(){

        // Given that

        List<String> originalImages = new ArrayList<>();
        originalImages.add("firstImage");
        originalImages.add("secondImage");
        originalImages.add("thirdImage");

        Product product = new Product();
        product.shallowCopy(originalImages);

        // Before modifying the original list
        assertEquals(product.getImages().size(), 3);
        assertEquals(originalImages.size(), 3);

        // when
        originalImages.remove(2);

        // after modifying the original list
        assertNotEquals(product.getImages().size(), 3);
        assertNotEquals(originalImages.size(), 3);
    }

    @Test
    void whenRemoveFromOriginalObject_thenDeepCopiedDuplicateRemainUnchanged(){
        List<String> originalImages = new ArrayList<>();
        originalImages.add("firstImage");
        originalImages.add("secondImage");
        originalImages.add("thirdImage");

        Product product = new Product();
        product.deepCopy(originalImages);
        assertEquals(product.getImages().size(), 3);
        assertEquals(originalImages.size(), 3);

        originalImages.remove(2);

        assertEquals(product.getImages().size(), 3);
        assertNotEquals(originalImages.size(), 3);
    }
}
