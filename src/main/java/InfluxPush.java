import java.lang.module.Configuration;
import java.util.concurrent.TimeUnit;
/*
Необходимо создать класс InfluxPush и реализовать статический метод push
(String operationName, long startTransactionTime, boolean status).
Метод push принимает на вход имя операции operationName, время начала операции
startTransactionTime и статус выполнения операции status.
Метод должен осуществлять запись в БД influx переданных значений.
 */
public class InfluxPush<DataWriter> {
    Configuration configuration = new Configuration("localhost", "8086", "root", "root", "mydb"); /* конектимся к инфлакс*/
    DataWriter writer = new DataWriter(configuration);
    class push {

        writer.setMeasurement("sampleMeasurement1");
        writer.setTimeUnit(TimeUnit.SECONDS);
        writer.setTime(System.currentTimeMillis() / 1000);
        String operationName;
        long startTransactionTime;
        boolean status;
        writer.addField("operationName", 12212);		// Integer value               /*добавляем и пишем значения*/
        writer.addField("startTransactionTime", 2244L);		// Long value
        writer.addField("status", true);	// Bool value
        writer.writeData();



    }
}
