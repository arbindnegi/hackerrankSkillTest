package hackerrank.advanced;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EfficientJanitor {

	public static void main(String[] args) {
	       Float wt [] = {1.99f, 1.01f, 2.5f, 1.5f, 1.01f};
	        List<Float> weights = Stream.of(1.99f, 1.01f, 2.5f, 1.5f, 1.01f).collect(Collectors.toList());
	        //List<Float> weights = Stream.of(wt).collect(Collectors.toList());
		int count = efficientJanitor(weights);
		System.out.println("EfficientJanitor.main(): " + count);
	}

	static int efficientJanitor(List<Float> weights) {
		weights.sort(Comparator.naturalOrder());
		int left = 0;
		int right = weights.size() - 1;
		int count = 0;
		while (left <= right) {
			if (left == right) {
				count++;
				break;
			}
			if (weights.get(left) + weights.get(right) <= 3.0) {
				left++;
				right--;
				count++;
			} else {
				right--;
				count++;
			}

		}
		return count;
	}
}
