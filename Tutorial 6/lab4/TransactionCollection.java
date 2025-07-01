import java.io.Serializable;
import java.util.*;

public class TransactionCollection implements Serializable {

	private final int SIZE = 10;
	
	public String merkleRoot;
	
	public List<String> tranxLst;
	
	public TransactionCollection() {
		tranxLst = new ArrayList<>(SIZE);
	}
	
	public void add(String tranx) {	
		tranxLst.add(tranx);
	}
	
	public String getMerkleRoot() {
		return this.merkleRoot;
	}
	
	public List<String> getTransactionList(){
		return this.tranxLst;
	}

	@Override
	public String toString() {
		return "TransactionCollection [tranxLst=" + tranxLst + "]";
	}
}
