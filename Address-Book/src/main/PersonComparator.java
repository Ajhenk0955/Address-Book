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
enum PersonComparator implements Comparator<Person> {

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
	LAST_NAME_SORT {
		public int compare(Person o1, Person o2) {
			return o1.getLastName().compareTo(o2.getLastName());
		}
	},
	LAST_NAME_FILTER{
		public int compare(Person o1, Person o2)	{
			return (o1.getLastName().equals(o2.getLastName()))? 0 : -1; // might have to change -1 to 1
		}
	},
	FIRST_NAME_FILTER{
		public int compare(Person o1, Person o2)	{
			return (o1.getFirstName().equals(o2.getFirstName()))? 0 : -1; // might have to change -1 to 1
		}
	},
	ZIP_FILTER{
		public int compare(Person o1, Person o2)	{
			return (o1.getZip().equals(o2.getZip()))? 0 : -1; // might have to change -1 to 1
		}
	},
	STATE_FILTER{
		public int compare(Person o1, Person o2)	{
			return (o1.getState().equals(o2.getState()))? 0 : -1; // might have to change -1 to 1
		}
	},
	CITY_FILTER{
		public int compare(Person o1, Person o2)	{
			return (o1.getCity().equals(o2.getCity()))? 0 : -1; // might have to change -1 to 1
		}
	},
	PHONE_FILTER{
		public int compare(Person o1, Person o2)	{
			return (o1.getPhone().equals(o2.getPhone()))? 0 : -1; // might have to change -1 to 1
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
