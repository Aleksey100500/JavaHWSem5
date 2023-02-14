import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Sem5HW {
    public static void main(String[] args) {
        // 1. Создать словарь HashMap. Обобщение <Integer, String>.

        Map<Integer, String> db = new HashMap<>();

        // 2. Заполнить тремя ключами (индекс, цвет), добавить ключь, если не было!)

        db.put(1, "Yellow");
        db.put(2, "Blue");
        db.put(3, "Orange");

        // 3. Изменить значения дописав восклицательные знаки.
        String symbol = "!";
        System.out.println(db);
        for (int i = 1; i < db.size(); i++) {
            db.put(i, db.get(i) + symbol);
        }
        System.out.println(db);

        // 4. *Создать TreeMap, заполнить аналогично.

        TreeMap<Integer, String> tMap = new TreeMap<>();
        tMap.put(1, "Green");
        tMap.put(2, "Red");
        tMap.put(3, "Brown");

        // 5. *Увеличить количество элементов до 1000 случайными ключами и общей строкой.
        // 6. **Сравнить время последовательного и случайного перебора тысячи элементов словарей.
        Random rnd = new Random();
        // Для TreeMap последовательный

        for (int i = 1; i < 1000; i++) {
            tMap.put(rnd.nextInt(1000), "Stroke by TreeMap");
        }
        long begin = System.currentTimeMillis();
        for (var item: tMap.entrySet()) {
            System.out.printf("[%d: %s]\n", item.getKey(),item.getValue());
        }
        long end = System.currentTimeMillis();
        System.out.printf("Time posl TreeMap: %d\n", end - begin);

        // Для HashMap последовательный

        for (int i = 1; i < 1000; i++) {
            db.put(rnd.nextInt(1000), "Stroke by HashMap");
        }
        long begin1 = System.currentTimeMillis();
        for (var item: db.entrySet()) {
            System.out.printf("[%d: %s]\n", item.getKey(),item.getValue());
        }
        long end1 = System.currentTimeMillis();
        System.out.printf("Time posl HashMap: %d\n", end1 - begin1);

        // Случайный перебор
        // Для TreeMap
        long begin2 = System.currentTimeMillis();
        for (int i = 1; i < tMap.size(); i++) {
            System.out.println(tMap.get(rnd.nextInt(tMap.size())));
        }
        long end2 = System.currentTimeMillis();
        System.out.printf("Time rand TreeMap: %d\n", end2 - begin2);
        // Для HashMap
        long begin3 = System.currentTimeMillis();
        for (int i = 1; i < db.size(); i++) {
            System.out.println(db.get(rnd.nextInt(db.size())));
        }
        long end3 = System.currentTimeMillis();
        System.out.printf("Time rand HashMap: %d\n", end3 - begin3);
    }
}
