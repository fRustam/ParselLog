/*
Необходимо создать классы Client и ClientGenerator. В классе Client должны присутствовать поля:
идентификатор, имя, фамилия, отчество, номера телефонов (может быть произвольное количество),
электронные адреса (может быть произвольное количество), адрес.
В классе ClientGenerator должен быть реализован метод randomGenerate(),
который должен возвращать клиента с заполненными полями
(должно быть как минимум два телефона, два электронных адреса).
 */
import java.util.ArrayList;
/*Создаём класс Client*/
public class Client {
    public static void main(String[] args) {
    }
    static class ClientParam {  /*Задаём параметры*/
        Integer id;
        String name;
        String secondName;
        String middleName;
        String address;
        ArrayList<String> celNum; /*номер телефона и имейлы в масштабируемом массиве*/
        ArrayList<String> email;

        /*Конструктор класса*/
        ClientParam(Integer id, String name, String secondName, String middleName, String address, ArrayList<String> celNum, ArrayList<String> email) {
            this.id=id;
            this.name=name;
            this.secondName=secondName;
            this.middleName=middleName;
            this.address=address;
            this.celNum=celNum;
            this.email=email;
        }
    }
    static class ClientGenerator {
        public static void randomGenerate() {
            Integer id = rndNum(1, 1000);         /*Могут совпадать, на данный момент не принципиально*/
            String name = "name" + String.valueOf(id);
            String secondName = "Second Name: " + String.valueOf(id);
            String middleName = "Middle Name: " + String.valueOf(id);
            String address = "Address is: "+ String.valueOf(id);
            Integer numCel = rndNum(2, 5);
            ArrayList<String> celNum = new ArrayList<String>(numCel);
            for (int i = 0; i < numCel; i++) {
                celNum.add(i, "8 (495)" + String.valueOf(rndNum(10000, 99999))); /*Генерируем номер телефона*/
            }
            ArrayList<String> email = new ArrayList<String>(numCel);
            for (int i = 0; i < numCel; i++) {
                email.add(i, String.valueOf(id)+ "-" + rndNum(1000, 9999)+"@gmail.com"); /*Генерируем маил*/
            }
            ClientParam client = new ClientParam(id, name, secondName, middleName, address, celNum, email);
            System.out.println("id is: " + client.id);
            System.out.println("Name: " + client.name);
            System.out.println("Second Name: " + client.secondName);
            System.out.println("Middle Name: " + client.middleName);
            System.out.println("Address: " + client.address);
            int i;
            System.out.println("Cellphone Number is :");
            for(i = 0; i < celNum.size(); ++i) {
                System.out.println(client.celNum.get(i));
            }
            System.out.println("Email is :");
            for(i = 0; i < email.size(); ++i) {
                System.out.println(client.email.get(i));
            }
        }
        static int rndNum(int min, int max)
        {
            max -= min;
            Double r=Math.random() * ++max;
            return r.intValue()+min;
        }
    }
}