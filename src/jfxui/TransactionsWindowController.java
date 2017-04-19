package jfxui;

import db.home.bank.Transactions;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Nicolas
 */
public class TransactionsWindowController extends ControllerBase{
    @FXML private TableView<Transactions> listTransactions;
    @FXML private ChoiceBox<Transactions> monthChooser;
    
    @Override
    public void initialize(Mediator mediator){
        EntityManager em = mediator.createEntityManager();
        //TypedQuery<Transactions> q = em.createQuery("SELECT t FROM Transactions t WHERE t.Account.Id =:acc", Transactions.class);
        //q.setParameter("acc", 2).getResultList();
        List<Transactions> transactions = em.createQuery("SELECT t FROM Transactions t", Transactions.class).getResultList();
        //List<Transactions> calendar = em.createQuery("SELECT ");
        // Remplissage du tableview avec transactions
        //this.monthChooser.setItems(FXCollections.observableList(calendar));
	this.listTransactions.setItems(FXCollections.observableList(transactions));
        //this.listTransactions.setItems(FXCollections.observableList(q));
    }
    
    private String formatDate(String date){
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
    }
    
    public String formatAmount(){
        return result;
    }

}