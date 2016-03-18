package main;

import java.util.Comparator;

/*
 * this enum is used to compare entries<Person>
 *
 * Returns
 * -1 o1 < o2
 *  0 o1 == o2
 *  1 o1 > 02
 */
public enum PersonComparator implements Comparator<Person> {

	/*
	 * used for sorting zip codes
	 */
	ZIP_SORT {
		public int compare(Person o1, Person o2) {
			return Integer.valueOf(o1.getZip()).compareTo(Integer.valueOf(o2.getZip()));
		}
	},
	/*
	 * used for sorting first names
	 */
	FIRST_NAME_SORT {
		public int compare(Person o1, Person o2) {
			return o1.getFirstName().compareTo(o2.getFirstName());
		}
	},
	/*
	 * sorts by last name
	 */
	LAST_NAME_SORT {
		public int compare(Person o1, Person o2) {
			return o1.getLastName().compareTo(o2.getLastName());
		}
	};

	public static Comparator<Person> decending(final Comparator<Person> other) {
		return new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return -1 * other.compare(o1, o2);
			}
		};
	}

	/*
	 * the actual compare function
	 */
	public static Comparator<Person> getComparator(final PersonComparator... multipleOptions) {
		return new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				for (PersonComparator option : multipleOptions) {
					int result = option.compare(o1, o2);
					if (result != 0) {
						return result;
					}
				}
				return 0;
			}
		};

	}
}