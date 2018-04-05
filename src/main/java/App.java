public class App {

    public static void main(String[] args) {

        String subj = Translit.toTranslit("Тема сообщения");
        String body = Translit.toTranslit("Тестовое сообщение");

        Sender sender = new Sender();
        sender.message_body = body;
        sender.message_subject = subj;
        sender.doSend();
    }
}
