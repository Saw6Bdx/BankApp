package projetJava;

import db.home.bank.Agency;
import db.home.bank.Account;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.persistence.EntityManager;
import jfxui.Mediator;
import projetJava.RibIban;

/**
 *
 * @author Nicolas
 */
public class MainTest {
  public static void main(String[] args) throws ParseException {
    java.util.Date fecha = new java.util.Date("Mon Dec 15 00:00:00 CST 2014");
    /* Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String s = formatter.format(date); // où date est this.date de la classe Transactions
    */
    DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
    Date date;
    date = (Date)formatter.parse(fecha.toString());
    System.out.println(date);        

    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    String formatedDate = cal.get(Calendar.DATE) + "/" + 
            (cal.get(Calendar.MONTH) + 1) + 
            "/" +         cal.get(Calendar.YEAR);
    System.out.println("formatedDate : " + formatedDate);
}
        
        /*EntityManager em = Mediator.createEntityManager();
        Agency q = em.createQuery("SELECT a.agencyCode FROM Agency a WHERE a.id = 1", Agency.class).getSingleResult();
        Account q2 = em.createQuery("SELECT a.number FROM Account a WHERE a.id = 1", Account.class).getSingleResult();
        
        String rib = generateRib(q, q2);
        System.out.print(rib);*/
    
    }
