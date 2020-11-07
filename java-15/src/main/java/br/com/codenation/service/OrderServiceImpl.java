package br.com.codenation.service;

import java.util.*;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		double value = items.stream().mapToDouble(orderItem -> {
			Optional<Product> product = productRepository.findById(orderItem.getProductId());
			double total = orderItem.getQuantity()* product.get().getValue();
			if(product.get().getIsSale()){
				double totalWithDiscount = total - (total*0.2);
				return totalWithDiscount ;
			}
			return total;
		}).sum();
		return value;
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream().map(id -> productRepository.findById(id).orElse(null))
				.filter(Objects::nonNull).collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream().mapToDouble(orderItems -> {
			return calculateOrderValue(orderItems);
		}).sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return productIds.stream().map(id -> productRepository.findById(id).get())
				.collect(Collectors.groupingBy(Product::getIsSale));
	}

}