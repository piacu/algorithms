

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1228 {

	public static void main(String[] args) throws IOException {
		List<String> list = new LinkedList<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int originKeys = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for(int i=0; i<originKeys; i++) {
			list.add(st.nextToken());
		}
		int commands = Integer.parseInt(bf.readLine());
		
		

	}
}

class Node {
	String data;
	Node link;
	
	public Node(String data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}
	
	public Node(String data) {
		super();
		this.data = data;
	}
	
	
}
