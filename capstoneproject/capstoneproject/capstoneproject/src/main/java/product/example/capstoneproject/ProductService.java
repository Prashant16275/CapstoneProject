package product.example.capstoneproject;




import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product getProductById(Long id)
    {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    //  @PreAuthorize("hasRole('ADMIN')")
    public Product addProduct(Product product)
    {
        return productRepository.save(product);
    }

//    public List<Product> searchByname(String productname){
//        return productRepository.searchProductByName(productname);
//    }

    public void deleteProductById(Long id)
    {
        productRepository.deleteById(id);
    }


    //  public Product update(Product product){return productRepository.save(product);}

    public Product updateProduct(long id, Product updateproduct){
        Product product = productRepository.findById(id).get();

        product.setName(updateproduct.getName());
        product.setDescription(updateproduct.getDescription());
        product.setPrice(updateproduct.getPrice());
        //   product.setManufacturer(updateproduct.getManufacturer());
        return productRepository.save(product);
    }
}

