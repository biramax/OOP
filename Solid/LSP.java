/*
Переписать код в соответствии с Liskov Substitution Principle.
*/


/*
Класс Square, как наследник, не должен изменять логики класса-родителя Rectangle. 
В классе Rectangle предполагается, что стороны могут иметь разный размер.
Но в классе Square это поведение ужимается до частного случая.
Но, с другой стороны, квадрат действительно является прямоугольником, поэтому мы можем сохранить эту приемственность, но прямое наследование в данном случае нужно изменить.
*/

// Создадим абстракцию - общего родителя для обеих фигур.
public abstract class Shape {
    public abstract int area();
}

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int area() {
        return this.width * this.height;
    }
}

public class Square extends Shape {
    private Rectangle rectangle;

    public Square(int side) {
        rectangle = new Rectangle(side, side);
    }

    public void setSide(int side) {
        this.rectangle.setWidth(side);
        this.rectangle.setHeight(side);
    }

    @Override
    public int area() {
        return this.rectangle.area();
    }
}



