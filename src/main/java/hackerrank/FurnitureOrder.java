package hackerrank;

import java.util.HashMap;
import java.util.stream.Collectors;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    
    private final HashMap<Furniture, Integer> furnitureMap;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
	furnitureMap = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
	Integer cnt = 0;
        if (furnitureMap.containsKey(type)) {
            cnt = furnitureMap.get(type);
        }
        furnitureMap.put(type, cnt + furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
       
	return new HashMap<Furniture, Integer>(furnitureMap);
    }

    public float getTotalOrderCost() {
        if (!furnitureMap.isEmpty()) {
    	return furnitureMap.entrySet().parallelStream().map(map -> map.getKey().cost() * map.getValue())
		.collect(Collectors.toList()).stream().reduce(Float::sum).get();
        }
	
       return 0;
    }

    public int getTypeCount(Furniture type) {
	if (furnitureMap.containsKey(type)) {
	    return furnitureMap.get(type);
	}
        return 0;
    }

    public float getTypeCost(Furniture type) {
	if (furnitureMap.containsKey(type)) {
	    return furnitureMap.get(type) * type.cost();
	}
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
	if (furnitureMap.isEmpty()) {
	    furnitureMap.values().stream().reduce(Integer::sum).get();
	}
        return 0;
    }
}