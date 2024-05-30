package org.example;
import ru.pflb.mq.dummy.implementation.ConnectionImpl;
import ru.pflb.mq.dummy.interfaces.Destination;
import ru.pflb.mq.dummy.interfaces.Producer;
import ru.pflb.mq.dummy.interfaces.Session;
import ru.pflb.mq.dummy.exception.DummyException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws DummyException, InterruptedException {
        // Создаю список сообщений который надо вывести согласно ТЗ
        List<String> messages = new ArrayList<>();
        messages.add("Четыре");
        messages.add("Пять");
        messages.add("Шесть");
        // Создаю соединение
        ConnectionImpl connection = new ConnectionImpl();
        /*Запускаю соединение(На самом деле имитириую, что запускаем). Не знаю надо ли это в коде оставлять.
        Согласно примеру результата из ДЗ нет. Но я решил оставить*/
        connection.start();
        // Создаю сессию. Использую true для автоматического подтверждения
        Session session = connection.createSession(true);
        // Создаю назначение(название) очереди
        Destination destination = session.createDestination("myQueue");
        // Создаю объект  для отправки сообщений в очередь
        Producer producer = session.createProducer(destination);
        // Прохожу по массиву messages сообщений и отправляем каждое
        for (String message : messages) {
            // Указываю время в миллисекундах
            Thread.sleep(2000);
            producer.send(message);
        }
        // Закрываю сессию и соединение
        session.close();
        connection.close();
    }
}