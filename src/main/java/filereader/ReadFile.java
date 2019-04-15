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
		try (Scanner scan = new Scanner(new File(args[0]));) {
			while (scan.hasNextLine()) {
				values.add(Arrays.asList(scan.nextLine().replace("\"", "").split(",")));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Collections.sort(values, new Comparator<List<String>>() {

			@Override
			public int compare(List<String> o1, List<String> o2) {
				return o1.get(1).compareTo(o2.get(1));
			}
		});
		for (List<String> list : values) {
			if (Integer.parseInt(list.get(list.size() - 1)) > 18) {
				System.out.print(list.get(0) + ", " + list.get(1) + ", " + list.get(2));
				System.out.println();
			}
		}
	}
}
