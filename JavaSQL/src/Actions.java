import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;


public class Actions {
    public static void main(String[] args) throws SQLException {
        String[] types = new String[]{"Абиссинская кошка", "Австралийский мист", "Американская жесткошерстная",
                "Американская короткошерстная", "Американский бобтейл", "Американский кёрл",
                "Балинезийская кошка", "Бенгальская кошка", "Бирманская кошка",
                "Бомбейская кошка", "Бразильская короткошёрстная", "Британская длинношерстная",
                "Британская короткошерстная", "Бурманская кошка", "Бурмилла кошка",
                "Гавана", "Гималайская кошка", "Девон-рекс", "Донской сфинкс",
                "Европейская короткошерстная", "Египетская мау", "Канадский сфинкс", "Кимрик",
                "Корат", "Корниш-рекс", "Курильский бобтейл", "Лаперм", "Манчкин",
                "Мейн-ку́н", "Меконгский бобтейл", "Мэнкс кошка", "Наполеон", "Немецкий рекс",
                "Нибелунг", "Норвежская лесная кошка", "Ориентальная кошка", "Оцикет",
                "Персидская кошка", "Петерболд", "Пиксибоб", "Рагамаффин", "Русская голубая кошка",
                "Рэгдолл", "Саванна", "Селкирк-рекс", "Сиамская кошка", "Сибирская кошка",
                "Сингапурская кошка", "Скоттиш-фолд", "Сноу-шу", "Сомалийская кошка", "Тайская кошка",
                "Тойгер", "Тонкинская кошка", "Турецкая ангорская кошка", "Турецкий ван", "Украинский левкой",
                "Чаузи", "Шартрез", "Экзотическая короткошерстная", "Японский бобтейл"};
        Connection conn = null;
        // db parameters
        String url = "jdbc:sqlite:My_cats.db";
        // create a connection to the database
        conn = DriverManager.getConnection(url);
        System.out.println("Connection to SQLite has been established.");
//        Statement statmt = conn.createStatement();
//        statmt.execute("CREATE TABLE types(id INTEGER PRIMARY KEY AUTOINCREMENT, type VARCHAR2(100) NOT NULL);");
//        System.out.println("Таблица создана или уже существует.");
//        insert_type("Австралийский мист", conn);
//        insert_type("Американская жесткошерстная", conn);
//        insert_all_types(types, conn);
//        Statement statmt = conn.createStatement();
//        statmt.execute("CREATE TABLE cats(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "name VARCHAR2(100) NOT NULL," +
//                "type_id INTEGER NOT NULL," +
//                "age INTEGER NOT NULL," +
//                "weigth DOUBLE," +
//                "FOREIGN KEY(type_id) REFERENCES types(id));");
//        System.out.println("Таблица создана или уже существует.");
//        insert_cat("Барсик", "Простой", 5, 5.4, conn);
        add_more_cats(5000,conn);
    }
    public static void add_more_cats(int n, Connection conn) throws SQLException {
        String[] names = {"Гарфилд","Том","Гудвин","Рокки","Ленивец","Пушок"
                ,"Спорти","Бегемот","Пират","Гудини","Зорро","Саймон","Альбус"
                ,"Базилио","Леопольд","Нарцисс","Атос","Каспер","Валлито","Оксфорд"
                ,"Бисквит","Соня","Клеопатра","Цунами","Забияка","Матильда"
                ,"Кнопка","Масяня","Царапка","Серсея","Ворсинка","Амели","Наоми"
                ,"Маркиза","Изольда","Вальс","Несквик","Златан","Баскет","Изюм"
                ,"Цукат","Мокко","Месси","Кокос","Адидас","Бейлиз","Тайгер"
                ,"Зефир","Мохи","Валенсия","Баунти","Свити","Текила","Ириска"
                ,"Карамель","Виски","Кукуруза","Гренка","Фасолька","Льдинка"
                ,"Китана","Офелия","Дайкири","Брусника","Аватар","Космос","Призрак"
                ,"Изумруд","Плинтус","Яндекс","Крисмас","Метеор","Оптимус","Смайлик"
                ,"Цельсий","Краска","Дейзи","Пенка","Веста","Астра","Эйприл","Среда"
                ,"Бусинка","Гайка","Елка","Золушка","Мята","Радость","Сиам","Оскар",
                "Феликс","Гарри","Байрон","Чарли","Симба","Тао","Абу","Ватсон","Енисей"
                ,"Измир","Кайзер","Васаби","Байкал","Багира","Айрис","Диана","Мими","Сакура"
                ,"Индия","Тиффани","Скарлетт","Пикси","Лиззи","Алиса","Лило","Ямайка","Пэрис"
                ,"Мальта","Аляска"};
        String[] types = new String[]{"Абиссинская кошка", "Австралийский мист", "Американская жесткошерстная",
                "Американская короткошерстная", "Американский бобтейл", "Американский кёрл",
                "Балинезийская кошка", "Бенгальская кошка", "Бирманская кошка",
                "Бомбейская кошка", "Бразильская короткошёрстная", "Британская длинношерстная",
                "Британская короткошерстная", "Бурманская кошка", "Бурмилла кошка",
                "Гавана", "Гималайская кошка", "Девон-рекс", "Донской сфинкс",
                "Европейская короткошерстная", "Египетская мау", "Канадский сфинкс", "Кимрик",
                "Корат", "Корниш-рекс", "Курильский бобтейл", "Лаперм", "Манчкин",
                "Мейн-ку́н", "Меконгский бобтейл", "Мэнкс кошка", "Наполеон", "Немецкий рекс",
                "Нибелунг", "Норвежская лесная кошка", "Ориентальная кошка", "Оцикет",
                "Персидская кошка", "Петерболд", "Пиксибоб", "Рагамаффин", "Русская голубая кошка",
                "Рэгдолл", "Саванна", "Селкирк-рекс", "Сиамская кошка", "Сибирская кошка",
                "Сингапурская кошка", "Скоттиш-фолд", "Сноу-шу", "Сомалийская кошка", "Тайская кошка",
                "Тойгер", "Тонкинская кошка", "Турецкая ангорская кошка", "Турецкий ван", "Украинский левкой",
                "Чаузи", "Шартрез", "Экзотическая короткошерстная", "Японский бобтейл"};
        Random rand = new Random();
        for (int i = 0; i <= n; i++){
            insert_cat(names[rand.nextInt(names.length)], types[rand.nextInt(types.length)], rand.nextInt(20),rand.nextDouble(15.0), conn);
        }
    }
    public static void insert_cat(String name, String type, int age, Double weight, Connection conn) throws SQLException {
        Statement stat = conn.createStatement();
        ResultSet rs = get_type_id(type, conn);
        if (rs.getFetchSize() == 0) insert_type(type, conn);
        int id = get_type_id(type, conn).getInt("id");
        System.out.println(name + " " + id + " " + age + " " + weight);
        stat.execute(String.format(Locale.US, "INSERT INTO cats(name, type_id, age, weigth) VALUES('%s', %d, %d, %.2f);", name, id, age, weight));
        System.out.println("Успешно");
    }

    public static void insert_type(String type, Connection conn) throws SQLException {
        Statement stat = conn.createStatement();
        stat.execute(String.format("INSERT INTO types(type) VALUES('%s');", type));
        System.out.println("Тип успешно добавлен");
    }
    public static void insert_all_types(String[] mas, Connection conn) throws SQLException {
        for(String v: mas){
            insert_type(v,conn);
        }
        System.out.println("Успешно");
    }
    public static void delete_type(int type_id, Connection conn) throws SQLException {
        Statement stat = conn.createStatement();
        stat.execute(String.format("DELETE FROM types WHERE id = %d;", type_id));
        System.out.println("Успешно");
    }
    public static void update_type(int type_id, String new_type, Connection conn) throws SQLException {
        Statement stat = conn.createStatement();
        stat.execute(String.format("UPDATE types SET type = '%s' WHERE id = %d;", new_type,type_id));
        System.out.println("Успешно");
    }
    public  static ResultSet get_type_id(String type, Connection conn) throws SQLException {
        Statement stat = conn.createStatement();
        return stat.executeQuery(String.format("SELECT id FROM types WHERE type = '%s'", type));
    }
    public  static ResultSet get_type(int type_id, Connection conn) throws SQLException {
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(String.format("SELECT type FROM types WHERE id = %d", type_id));
        System.out.println(rs.getString("type"));
        return  rs;
    }
    public  static void get_type_where(String where, Connection conn) throws SQLException {
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(String.format("SELECT * FROM types WHERE %s;", where));
        while (rs.next()){
            System.out.println(rs.getString("type"));
        }
    }
    public  static void get_all_types(Connection conn) throws SQLException {
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("SELECT type FROM types;");
        while (rs.next()){
            System.out.println(rs.getString("type"));
        }
    }

}
