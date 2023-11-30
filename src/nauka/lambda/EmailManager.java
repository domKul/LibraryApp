package nauka.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class EmailManager {
    public static void main(String[] args) {
        List<Email> emailList = createEmailList();
        //tylko wysłane emaile
        System.out.println("Wysłane maile:");
        List<Email> emails1 = filerEmails(emailList, email -> email.isSent());
        System.out.println(emails1);
        System.out.println("Maile przefiltrowane na podstawie nadawcy lub odbiorcy");
        List<Email> emails = filerEmails(emailList, email -> email.getSender().equals("bart@example.com") || email.getRecipient().equals("bart@example.com"));
        System.out.println(emails);

    }


    private static List<Email> filerEmails(List<Email> list, Predicate<Email> predicate){
        List<Email>result = new ArrayList<>();
        for (Email t : list) {
            if (predicate.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    private static List<Email> createEmailList() {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email(
                "joe@example.com",
                "barbara@example.com",
                "Kup bułki",
                "Cześć!, Kup proszę bułki, gdy będziesz wracać z pracy.",
                false)
        );
        emails.add(new Email(
                "carl@example.com",
                "joe@example.com",
                "Nowa inwestycja",
                "Siema! Musimy omówić temat nowej inwestycji, pasuje Ci jutro?",
                true)
        );
        emails.add(new Email(
                "joe@example.com",
                "bart@example.com",
                "Wypad na miasto",
                "Cześć. Idziemy dzisiaj wieczorem z chłopakami na miasto. Dołączasz do nas?",
                true)
        );
        return emails;
    }
}