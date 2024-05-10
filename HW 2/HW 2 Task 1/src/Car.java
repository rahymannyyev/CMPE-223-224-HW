public class Car implements Comparable<Car> {

  public String brand, modelname;
  public long modelyear;

  public Car(String brand, String modelname, long modelyear) {
    this.brand = brand;
    this.modelname = modelname;
    this.modelyear = modelyear;
  }

  public static void main(String[] args) {

    Car one = new Car("Volvo", "XC90", 1999);
    Car two = new Car("Volkswagen", "Passat", 2000);
    Car three = new Car("Nissan", "Murano", 1980);
    Car four = new Car("Hyundai", "Santa Fe", 1983);
    Car five = new Car("Ford", "Mustang", 2022);
    Car six = new Car("Mazda", "CX-5", 2021);
    Car seven = new Car("Honda", "Civic", 2009);
    Car eight = new Car("Subaru", "Impreza", 1970);
    Car nine = new Car("Toyota", "Corolla", 2010);
    Car ten = new Car("Audi", "A4", 2024);

    Car[] peppa = new Car[] { one, two, three, four, five, six, seven, eight, nine, ten };
    sort(peppa);
    for (int i = 0; i < 10; i++) {
      System.out.println(peppa[i].toString());
    }
  }

  public static int compareTo(Car a, Car b) {
    if (a.modelyear > b.modelyear)
      return 1;
    if (a.modelyear < b.modelyear)
      return -1;
    return 0;
  }

  public static void sort(Car[] a) {

    sort(a, 0, a.length - 1);
  }

  private static void sort(Car[] a, int lo, int hi) {
    if (hi <= lo)
      return;
    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  private static int partition(Car[] a, int lo, int hi) {
    int i = lo, j = hi + 1;
    Car v = a[lo];
    while (true) {
      while (less(a[++i], v))
        if (i == hi)
          break;
      while (less(v, a[--j]))
        if (j == lo)
          break;
      if (i >= j)
        break;
      exch(a, i, j);
    }
    exch(a, lo, j);
    return j;
  }

  private static boolean less(Car v, Car w) {
    return Car.compareTo(w, v) < 0; // change is w, v positions
  }

  private static void exch(Car[] a, int i, int j) {
    Car t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  @Override
  public String toString() {
    return "\nCar's model name: " + this.modelname + "\nCar's model year: " + this.modelyear + "\nCar's brand: "
        + this.brand;
  }

  @Override
  public int compareTo(Car o) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
  }

}