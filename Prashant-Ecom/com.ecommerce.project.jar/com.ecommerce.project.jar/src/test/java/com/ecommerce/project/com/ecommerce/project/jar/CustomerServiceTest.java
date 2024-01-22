package com.ecommerce.project.com.ecommerce.project.jar;

import com.ecommerce.project.com.ecommerce.project.jar.model.Customer;
import com.ecommerce.project.com.ecommerce.project.jar.repository.CustomerRepository;
import com.ecommerce.project.com.ecommerce.project.jar.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

  @Mock
  private CustomerRepository customerRepository;

  @InjectMocks
  private CustomerService customerService;

  @BeforeEach
  void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testGetCustomerById() {
    // Mocking the behavior of the customerRepository
    Long customerId = 1L;
    Customer customer = new Customer();
    customer.setId(customerId);
    when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

    // Calling the service method
    Customer result = customerService.getCustomerById(customerId);

    // Verifying the result
    assertSame(customer, result);
  }

  @Test
  void testGetAllCustomer() {
    // Mocking the behavior of the customerRepository
    List<Customer> customers = new ArrayList<>();
    when(customerRepository.findAll()).thenReturn(customers);

    // Calling the service method
    List<Customer> result = customerService.getAllCustomer();

    // Verifying the result
    assertSame(customers, result);
  }

  @Test
  void testAddCustomer() {
    // Creating a new customer
    Customer customer = new Customer();

    // Mocking the behavior of the customerRepository
    when(customerRepository.save(customer)).thenReturn(customer);

    // Calling the service method
    Customer result = customerService.addCustomer(customer);

    // Verifying the result
    assertSame(customer, result);
  }

  @Test
  void testDeleteCustomerById() {
    // Mocking the behavior of the customerRepository
    Long customerId = 1L;
    doNothing().when(customerRepository).deleteById(customerId);

    // Calling the service method
    customerService.deleteCustomerById(customerId);

    // Verifying that the delete method was called with the correct ID
    verify(customerRepository, times(1)).deleteById(customerId);
  }

  @Test
  void testLogin() {
    // Mocking the behavior of the customerRepository
    String email = "test@example.com";
    String password = "password";
    Customer customer = new Customer();
    when(customerRepository.findByemailAndPassword(email, password)).thenReturn(customer);

    // Calling the service method
    Customer result = customerService.login(email, password);

    // Verifying the result
    assertSame(customer, result);
  }
}
