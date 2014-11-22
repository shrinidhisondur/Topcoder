import java.util.*;

public class SyllableSorting {
	
	boolean isVowel (char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
	
	class Node implements Comparable<Node> {
		
		ArrayList <String> unsorted;
		ArrayList <String> sorted;
		String word;
		Node (String word) {
			unsorted = new ArrayList <String> ();
			sorted = new ArrayList <String> ();
			this.word = word;
		}
		
		@Override
		public int compareTo(Node arg0) {
			int index = 0;
			
			while (index < Math.min(arg0.sorted.size(), sorted.size())) {
				
				if (0 != sorted.get(index).compareTo(arg0.sorted.get(index))) {
					return sorted.get(index).compareTo(arg0.sorted.get(index));
				}
				index++;
			}
			
			if (index < sorted.size()) {
				return 1;
			}
			
			if (index < arg0.sorted.size()) {
				return -1;
			}
			
			index = 0;
			while (index < Math.min(arg0.unsorted.size(), unsorted.size())) {
				
				if (0 != unsorted.get(index).compareTo(arg0.unsorted.get(index))) {
					return unsorted.get(index).compareTo(arg0.unsorted.get(index));
				}
				index++;
			}
			
			if (index < unsorted.size()) {
				return 1;
			}
			
			if (index < arg0.unsorted.size()) {
				return -1;
			}
			
			return 0;
		}
	}
	
	String[] sortWords(String[] words) {
		
		ArrayList <Node> list = new ArrayList<Node>(); 
		for (String string : words) {
			int index = 0;
			int consIndex = 0;
			
			Node node = new Node (string);
			while (index < string.length()) {
				if (isVowel (string.charAt(index)) && ( (index == string.length()-1) || !isVowel (string.charAt(index + 1))) ) {
					node.unsorted.add(string.substring(consIndex, index + 1));
					node.sorted.add(string.substring(consIndex, index + 1));
					consIndex = index + 1;
				}
				index++;
			}
			Collections.sort (node.sorted);
			list.add(node);
		}
		Collections.sort(list);
		
		String [] response = new String [list.size()];
		int counter = 0;
		for (Node node : list) {
			response[counter] = node.word;
			counter++;
		}
		return response;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SyllableSorting ss = new SyllableSorting();
		
		String [] words = {"xiaoxiao", "yamagawa", "gawayama"};
		String [] res = ss.sortWords(words);
		for (String string : res) {
			System.out.print(string + " ");
		}

	}

}
