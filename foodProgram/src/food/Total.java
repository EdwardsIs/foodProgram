package food;

/*
 * This class contains a list of all food items, and methods to aggregate
 * all information into a presentable total.
 */

public class Total {
	
	// Attributes
	private double finalTotal = 0;
	// Array holding all FoodItem objects with initial values for name and price
	private FoodItem foodItems[] = {new FoodItem("Cheeseburger Deluxe", 5.00, 0, 0.0), 
			new FoodItem("Cheeseburger", 4.00, 0, 0.0), new FoodItem("Hamburger", 3.00, 0, 0.0),
			new FoodItem("Fries", 2.00, 0, 0.0), new FoodItem("Soda", 2.00, 0, 0.0),
			new FoodItem("Water", 0.0, 0, 0.0)};
	
	
	// Getter and Setter for finalTotal variable
	public double getFinalTotal() {
		return finalTotal;
	}


	public void setFinalTotal(double finalTotal) {
		this.finalTotal = finalTotal;
	}
	
	// Special incrementFinalTotal method to increment the total amount
	public void incrementTotal(double amount) {
		this.finalTotal += amount;
	}


	/*
	 * This method takes an array of quantities ordered.  Each position in the argument array
	 * will directly correspond to an item in the foodItems array.  The method loops through
	 * the array of quantities, calling the incrementQuantity() method for each item in the 
	 * food items array, which updates all amounts accordingly.
	 */
	public void updateItemQuantities(int quantities[]) {
		// Count variable incrementing each loop iteration to allow access to proper array element
		int count = 0;
		// Special for loop goes through array.
		for(int quantity : quantities) {
			// Checking to see if a negative value has been entered
			// If so, it is simply changed to 0.
			if (quantity < 0) {
				quantity = 0;
			}
			foodItems[count].incrementQuantity(quantity);
			count++;
		}
	}
	
	
	// This method resets all values, allowing for another day's information
	public void reset() {
		// Resetting final total
		setFinalTotal(0.0);
		
		// Resetting all individual food items
		for(FoodItem item : foodItems) {
			item.reset();
		}
	}
	
	
	/*
	 *  Overriden toString() method gathers all information from each item
	 *  in the foodItems array, and puts concatenates together a clean output string 
	 */
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// Setting final total to 0 so the previous amount 
		// isn't added on again
		setFinalTotal(0.0);
		for (FoodItem item : foodItems) {
			sb.append(item.toString() + "\n");
			incrementTotal(item.getTotal());
		}
		sb.append("Total sales for the day: $" + String.format("%.2f", getFinalTotal()));
		return sb.toString();
	}
}
