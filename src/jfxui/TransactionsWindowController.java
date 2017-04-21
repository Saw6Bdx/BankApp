package jfxui;

import db.home.bank.Transactions;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Nicolas
 */
public class TransactionsWindowController extends ControllerBase{
    @FXML private TableView<Transactions> listTransactions;
    @FXML private ChoiceBox<Transactions> monthChooser;
    
    private String flagAccountType;
    
    /**
     * 
     * @param flagAccountType Current or Savings
     */
    public void setFlagAccountType(String flagAccountType) {
        this.flagAccountType = flagAccountType;
    }
    
    @Override
    public void initialize(Mediator mediator){
        EntityManager em = mediator.createEntityManager();
        this.monthChooser.setItems(FXCollections.observableArrayList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "Novemeber", "December"));
        
        //TypedQuery<Transactions> q = em.createQuery("SELECT t FROM Transactions t WHERE t.idAccount.id =:acc", Transactions.class);
        //this.monthChooser.setItems(FXCollections.observableList(q.setParameter("acc",  1).getResultList()));
        
    }
    
    public void initTransactionsWindowController(Mediator mediator){
        if (flagAccountType.equals("Current")) {
            EntityManager em = mediator.createEntityManager();
            TypedQuery<Transactions> q = em.createQuery("SELECT t FROM Transactions t WHERE t.idAccount.id =:acc", Transactions.class);
            this.listTransactions.setItems(FXCollections.observableList(q.setParameter("acc",  1).getResultList()));
        }       
        
        else { // Savings
            EntityManager em2 = mediator.createEntityManager();
            TypedQuery<Transactions> q2 = em2.createQuery("SELECT t FROM Transactions t WHERE t.idAccount.id =:acc", Transactions.class);
            this.listTransactions.setItems(FXCollections.observableList(q2.setParameter("acc", 2).getResultList()));
        }
    }
    
    /*private String formatDate(String date){
        String[] parts = date.split(" ");
        String result = "";
        for (int i = parts.length - 1 ; i >= 0 ; i-- ) {
            result = result.concat(parts[i]);
            if (i != 0 ) {
                result = result.concat("-");
            }
        }
        System.out.println(result);
        return result;
    }*/
    
    /*public String formatAmount(String amount){
        String[] parts = amount.split(".");
        String result = "";
        for (int i = parts.length - 1 ; i >= 0 ; i-- ) {
            result = result.concat(parts[i]);
            if (i != 0 ) {
                result = result.concat(",");
            }
        }
        return result;
    }*/

}