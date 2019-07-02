package food;

/*
 * This class contains attributes for individual food items, and a toString method to compile all
 * information on the item together.
 */

public class FoodItem {
	
	// Default empty constructor
	public FoodItem() {}
	
	// Overloaded constructor taking all arguments
	public FoodItem(String name, double price, int quantity, double total) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
	}
	
	// Attributes
	private String name;
	private double price;
	private int quantity;
	private double total;
	
	// Getters/Setters for attributes
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	/*
	 * This method takes a new quantity amount, and adds it to the current quantity.
	 * When this method is used, the total is also updated accordingly.
	 */
	public void incrementQuantity(int quantity) {
		this.quantity += quantity;
		this.total += (quantity * getPrice());
	}
	
	/*
	 * This method resets the object's quantity and total fields, but NOT the 
	 * name and price values, allowing for a fresh run
	 */
	public void reset() {
		setTotal(0.0);
		setQuantity(0);
	}
	
	// Overridden toString method. This returns all information on the attribute
	@Override
	public String toString() {
		// Concatenating all information on the FoodItem into a string
		return getQuantity() + " " + getName() + "(s)" + " @ $" + String.format("%.2f", getPrice()) + " ea. = $"
				+ String.format("%.2f", getTotal());
	}
	
}
