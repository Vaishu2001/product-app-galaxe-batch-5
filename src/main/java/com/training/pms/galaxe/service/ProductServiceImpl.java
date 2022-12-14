package com.training.pms.galaxe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.galaxe.dao.productDAO;
import com.training.pms.galaxe.model.Product;
@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
	productDAO productdao;
	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String saveProduct(Product product) {
		// TODO Auto-generated method stub
		if(product.getPrice() <0 | product.getQuantityOnHand() <0)
		{
			return "Product price or QOH cannot be negative. Not Saved";
		}
		else {
			productdao.save(product);
			return "Product Saved Successfully";
		}
		
	}

	@Override
	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		if(product.getPrice() <0 | product.getQuantityOnHand() <0)
		{
			return "Product price or QOH cannot be negative. Not Updated";
		}
		else {
			productdao.save(product);
			return "Product Updated Successfully";
		}
		
	
	}

	@Override
	public String deleteProduct(int productId) {
		// TODO Auto-generated method stub
		productdao.deleteById(productId);
		return "Product deleted successfully";
	}

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		System.out.println("Single product called");
		Optional<Product> product= productdao.findById(productId);
		return product.get();
	}

	@Override
	public List<Product> getProduct() {
		// TODO Auto-generated method stub
	System.out.println("All products called");
			return (List<Product>) productdao.findAll();
	}

	@Override
	public boolean isProductExists(int productId) {
		// TODO Auto-generated method stub
		Optional<Product> product= productdao.findById(productId);
		return product.isPresent();
	}

	@Override
	public List<Product> searchProduct(String productName) {
		// TODO Auto-generated method stub
		return productdao.findByProductName(productName);
	}

	@Override
	public List<Product> searchProduct(String productName, int price, int qoh) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchProduct(int min, int max) {
		// TODO Auto-generated method stub
		return productdao.findByPriceBetween(min, max);
	}

	@Override
	public List<Product> checkStockStatus(int minStock) {
		// TODO Auto-generated method stub
		return productdao.findByQuantityOnHandGreaterThan(minStock);
	}

}
