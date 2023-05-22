/*
Переписать код в соответствии с Interface Segregation Principle.
Подсказка: круг не объемная фигура и этому классу не нужен метод volume().
*/

/*
Поскольку плоские фигуры не имеют объёма, то при имплементировании данного интерфейса они им придётся нести в себе ненужный метод.
Чтобы этого не происходило, раздлеляем этот "толстый" интерфейс на несколько специализированных. И дальше в классах будем подключать только нужные интерфейсы.

public interface Shape {
    double area();
    double volume();
}
*/
public interface Area {
    double area();
}
public interface Volume {
    double volume();
}


public class Circle implements /*Shape*/ Area {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 2 * 3.14 * radius;
    }
    /*
    @Override
    public double volume() {
        throw new UnsupportedOperationException();
    }
    */
}

public class Cube implements /*Shape*/ Area, Volume {
    private int edge;

    public Cube(int edge) {
        this.edge = edge;
    }

    @Override
    public double area() {
        return 6 * edge * edge;
    }

    @Override
    public double volume() {
        return edge * edge * edge;
    }
}
