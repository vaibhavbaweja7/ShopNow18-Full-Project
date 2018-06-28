package com.niit.Backend.dao;
import java.util.List;
import com.niit.Backend.model.CartLine;
import com.niit.Backend.model.Cart;
public interface CartLineDAO {

	
	public List<CartLine> list(int cartId);
	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean remove(CartLine cartLine);
	public  CartLine getByCartAndProduct(int cartId, int productId);
	boolean updateCart(Cart cart);
	List<CartLine> listAvailable(int cartId);
}
