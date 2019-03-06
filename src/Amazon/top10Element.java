import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

class Item {
	int id;
	Date time;
	int soldCount;
	
	public Item(int id){ 
		this.id = id;
		this.time = new Date();
		this.soldCount = 0;
	}	
}


interface ItemInterface {
	public List<Item> getTopItem(Date timeGiven);
}

class TimeComparator implements Comparator<Item> {

	public int compare(Item i1, Item i2) {
		// Date Wise Comparison
		// Descending Order
		return i2.time.compareTo(i1.time);
	}
}

public class top10Element implements ItemInterface {
	
	Map<Integer, Item> soldCount = new HashMap<>();

	public void putItem(int id) {
		Item newItem = soldCount.getOrDefault(id, new Item(id));
		newItem.soldCount++;
		newItem.time = new Date();
		soldCount.put(id, newItem);
	}

	@Override
	public List<Item> getTopItem(Date timeGiven) {
		List<Item> result = new ArrayList<Item>();		
		
		// Current Time
		Calendar c = Calendar.getInstance();
		c.setTime(timeGiven);
		c.add(c.HOUR, -1);
		Date oneHourBack = c.getTime(); 
		
		// Priority Queue popping last 10 elements
		int count = 0;
		while (pq.size()!=0 && count < 10){
			result.add(pq.poll());
			count++;
		}
		
		// Pushing it again
		count--;
		while(count>=0) {
			pq.offer(result.get(count));
			count--;
		}

		return result;	
	}


}
