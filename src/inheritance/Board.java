package inheritance;

import java.util.Arrays;

public class Board {
    private Shape[] places = new Shape[4];

    public Board(Shape[] places) {
        super();
        this.places = places;
    }

    public Board() {
        super();
    }

    public Shape[] getPlaces() {
        return places;
    }

    public void setPlaces(Shape[] places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "Board{" +
                "places=" + Arrays.toString(places) +
                '}';
    }

    public void insert(int place, Shape figure) {
        if (places[place-1] == null) {
            places[place-1] = figure;
        }
    }

    public void delete(int place) {
        for (int i = 1; i <= places.length; i++) {
            if (i == place && places[i] != null) {
                places[i] = null;
            }
        }
    }

    public  void shapeInfo() {
        double sumOfArea = 0;
        for (Shape place : places) {
            if (place != null) {
                System.out.println("Perimeter: " + place.getPerimeter() + "  Area: " + place.getArea());
            } else {
                continue;
            }
            sumOfArea += place.getArea();
        }
        System.out.println("Sum of area: " + sumOfArea);
    }
}
