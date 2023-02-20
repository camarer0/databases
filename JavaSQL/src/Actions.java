import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Actions {
    public static void main(String[] args) throws SQLException {
        String[] types = new String[]{"Абиссинская кошка",
                "Австралийский мист",
                "Американская жесткошерстная",
                "Американская короткошерстная",
                "Американский бобтейл",
                "Американский кёрл",
                "Балинезийская кошка",
                "Бенгальская кошка",
                "Бирманская кошка",
                "Бомбейская кошка",
                "Бразильская короткошёрстная",
                "Британская длинношерстная",
                "Британская короткошерстная",
                "Бурманская кошка",
                "Бурмилла кошка",
                "Гавана",
                "Гималайская кошка",
                "Девон-рекс",
                "Донской сфинкс",
                "Европейская короткошерстная",
                "Египетская мау",
                "Канадский сфинкс",
                "Кимрик",
                "Корат",
                "Корниш-рекс",
                "Курильский бобтейл",
                "Лаперм",
                "Манчкин",
                "Мейн-ку́н",
                "Меконгский бобтейл",
                "Мэнкс кошка",
                "Наполеон",
                "Немецкий рекс",
                "Нибелунг",
                "Норвежская лесная кошка",
                "Ориентальная кошка",
                "Оцикет",
                "Персидская кошка",
                "Петерболд",
                "Пиксибоб",
                "Рагамаффин",
                "Русская голубая кошка",
                "Рэгдолл",
                "Саванна",
                "Селкирк-рекс",
                "Сиамская кошка",
                "Сибирская кошка",
                "Сингапурская кошка",
                "Скоттиш-фолд",
                "Сноу-шу",
                "Сомалийская кошка",
                "Тайская кошка",
                "Тойгер",
                "Тонкинская кошка",
                "Турецкая ангорская кошка",
                "Турецкий ван",
                "Украинский левкой",
                "Чаузи",
                "Шартрез",
                "Экзотическая короткошерстная",
                "Японский бобтейл"
        };
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
        insert_all_types(types, conn);
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
    public static void updat_type(int type_id, String new_type, Connection conn) throws SQLException {
        Statement stat = conn.createStatement();
        stat.execute(String.format("UPDATE types SET type = '%s' WHERE id = %d;", new_type,type_id));
        System.out.println("Успешно");

    }
    public  static void get_type(int type_id, Connection conn) throws SQLException {
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(String.format("SELECT type FROM types WHERE id = %d", type_id));
        System.out.println(rs.getString("type"));
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
