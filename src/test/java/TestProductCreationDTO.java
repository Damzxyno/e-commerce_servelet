import com.example.damzxynostore.dao.CustomerDAO;
import com.example.damzxynostore.dao.ProductDAO;
import com.example.damzxynostore.entities.CustomerDTO;
import com.example.damzxynostore.entities.ProductDTO;

import java.util.Date;
import java.util.Locale;

public class TestProductCreationDTO {
//    public static void main(String[] args) {
//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setProductId(1);
//        productDTO.setProductName("Chivita");
//        productDTO.setImage((byte) 001);
//        productDTO.setPrice(20_000.00);
//        productDTO.setDescription("A fine juice");
//        productDTO.setCategoryId(1234);
//
//
//        ProductDAO productDAO = new ProductDAO();
//
//        productDAO.create(productDTO);
//    }

    public static void main(String[] args) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setAddress("Oshodi");
        customerDTO.setEmail("ilepa");
        customerDTO.setLastName("Ife");
        customerDTO.setFirstName("Ola");
        customerDTO.setPhone("23454");
        customerDTO.setPassword("23454");
        customerDTO.setDate(new Date());


        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.create(customerDTO);
    }
}
