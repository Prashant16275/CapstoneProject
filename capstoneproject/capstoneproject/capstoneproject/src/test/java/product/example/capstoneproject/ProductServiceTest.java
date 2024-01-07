package product.example.capstoneproject;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
public class ProductServiceTest {
    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetProductById() {
        Long productId = 1L;
        Product expectedProduct = new Product();
        expectedProduct.setId(productId);
        when(productRepository.findById(productId)).thenReturn(Optional.of(expectedProduct));

        Product actualProduct = productService.getProductById(productId);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testGetAllProduct() {
        List<Product> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product());
        expectedProducts.add(new Product());
        when(productRepository.findAll()).thenReturn(expectedProducts);
        List<Product> actualProducts = productService.getAllProduct();
        assertEquals(expectedProducts.size(), actualProducts.size());
    }
    @Test
    public void testAddProduct() {
        Product productToAdd = new Product();
        when(productRepository.save(productToAdd)).thenReturn(productToAdd);
        Product addedProduct = productService.addProduct(productToAdd);
        assertEquals(productToAdd, addedProduct);
    }
    @Test
    public void testDeleteProductById() {
        Long productId = 1L;
        productService.deleteProductById(productId);

        verify(productRepository, times(1)).deleteById(productId);
    }


}
