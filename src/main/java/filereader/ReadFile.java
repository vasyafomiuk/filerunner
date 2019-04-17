package filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
	public static void main(String[] args) {
		ArrayList<List<String>> values = new ArrayList<>();
		//you can also provide a path ""/Users/<user name>/Desktop/exercise_input.txt""
		try (Scanner scan = new Scanner(new File(args[0]));) {
			while (scan.hasNextLine()) {
				values.add(Arrays.asList(scan.nextLine().replace("\"", "").split(",")));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Comparator<List<String>> comps1 = Comparator.comparing(o1->o1.get(1)) ; 
		Comparator<List<String>> comps2 = Comparator.comparing(o1->o1.get(0)) ; 
		comps1.thenComparing(comps2);
		Collections.sort(values, comps1.thenComparing(comps2)  );
		for (List<String> list : values) {
			if (Integer.parseInt(list.get(list.size() - 1)) > 18) {
				System.out.print(list.get(0)+" ");
				System.out.print(list.get(1)+" ");
				System.out.print((list.get(2).contains(".")? list.get(2).substring(0, list.get(2).indexOf("."))+".": list.get(2))+" ");
				System.out.print((list.get(3).length()==2? list.get(2).substring(list.get(2).lastIndexOf(" ")).trim(): list.get(3))+" ");
				System.out.print((list.get(4).matches("\\d+")?list.get(3).toUpperCase():list.get(4).toUpperCase())+" ");
				System.out.print((list.get(4).matches("\\d+")?list.get(4): list.get(5) ));
				System.out.println();
			}
		}
	}
}
