import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
Необходимо создать класс ParseLog и реализовать метод parse().
Конструктор класса принимает входной и выходной файлы с логами в качестве параметров.
Метод parse() сравнивает строки в файле и выводит в выходной файл
уникальные строки и количество повторяющихся в исходном файле.
 */
public class ParseLog {

    public static void main(String a[]) {
        Map<String, Integer> map= new HashMap<String, Integer>();
        try{
            FileInputStream stream = new FileInputStream("test.log");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String strLine;

            /*читаем лог построчнчно и */
            while ((strLine = reader.readLine()) != null) {
                Integer count = map.get(strLine);
                map.put(strLine, (count == null) ? 1 : count + 1);
                PrintStream fileOut = new PrintStream("./out.txt");
                System.setOut(fileOut);
                System.out.println (map);
            }
            stream.close();
        }
        /*вывод ошибки*/
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}