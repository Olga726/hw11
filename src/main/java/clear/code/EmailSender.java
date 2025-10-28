package clear.code;

class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Отправка email: " + message);
    }


    /*
    public void sendEmail(String message) {
        System.out.println("Отправка email: " + message);
    }
     */
}
