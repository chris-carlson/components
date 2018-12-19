package collection;

public class GridCreator {
    public static Grid<Integer> create(String rep) {
        String[] rows = rep.split("\\|");
        Array<Array<Integer>> array = new Array<>(rows.length);
        for (int index = 0; index < rows.length; index++) {
            array.set(index, ArrayCreator.create(rows[index]));
        }
        return new Grid<>(array);
    }
}
