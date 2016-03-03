package main;


import java.util.Comparator;
/*
 * this enum is used to compare entries<Person> 
 */
enum PersonComparator implements Comparator<Person> {

	ZIP_SORT {
		public int compare(Person o1, Person o2) {
			return Integer.valueOf(o1.getZip()).compareTo(Integer.valueOf(o2.getZip()));
		}
	},
	FIRST_NAME_SORT {
		public int compare(Person o1, Person o2) {
			return o1.getFirstName().compareTo(o2.getFirstName());
		}
	},
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
