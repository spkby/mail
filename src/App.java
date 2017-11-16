public class App {


    public static void main(String[] args) {


        Sender sender = new Sender();

        sender.message_body = "test body";
        sender.message_subject = "test subj";

        sender.doSend();
    }
}
