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

		Collections.sort(values, new Comparator<List<String>>() {
			@Override
			public int compare(List<String> o1, List<String> o2) {
				return o1.get(1).compareTo(o2.get(1));
			}
		});
		for (List<String> list : values) {

			if (Integer.parseInt(list.get(list.size() - 1)) > 18) {
				System.out.print("First name: " + list.get(0) + ", Last name: " + list.get(1) + ", Address: "
						+ (list.get(2).contains(".") ? list.get(2).substring(0, list.get(2).lastIndexOf("."))
								: list.get(2))
						+ ", "
						+ (list.get(3).length() > 2
								? list.get(3).substring(0, 1).toUpperCase() + list.get(3).substring(1).toLowerCase()
										+ ", Age: " + list.get(list.size() - 1)
								: list.get(2).substring(list.get(2).lastIndexOf(" ") + 1))
						+ ", " + (list.get(4).matches("\\d+") ? list.get(3).toUpperCase() : list.get(4).toUpperCase())
						+ ", Age: " + list.get(list.size() - 1));
				System.out.println();
			}
		}
	}
}
