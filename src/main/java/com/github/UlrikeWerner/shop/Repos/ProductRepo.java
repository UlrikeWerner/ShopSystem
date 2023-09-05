package com.github.UlrikeWerner.shop.Repos;

import com.github.UlrikeWerner.shop.Entities.Product;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class ProductRepo {
    private Map<UUID, Product> productList;

    //Constructor
    public ProductRepo(Map<UUID, Product> productList) {
        this.productList = productList;
    }

    // Getter & Setter
    public Map<UUID, Product> getProductList() {
        return productList;
    }

    public void setProductList(Map<UUID, Product> productList) {
        this.productList = productList;
    }

    //methods
    public void addProductToList(Product product) {
        productList.put(product.productId(), product);
    }

    public void deleteProductFromList(Product product){
        if(getProductInfo(product.productId()) == null){
            System.out.println("Das Produkt existiert nicht!");
            return;
        }
        productList.remove(product.productId());
    }

    public Product getProductInfo(UUID productId){
        return productList.get(productId);
    }

    // generated methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(productList, that.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productList);
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "productList=" + productList +
                '}';
    }
}
