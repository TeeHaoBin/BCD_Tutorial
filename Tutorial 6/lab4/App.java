public class App {

	public static void main(String[] args) {
		//very-first block called genesis block
		Block genesis = new Block("0");
		System.out.println("\n ---------------------- \n");
		System.out.println(genesis );
		String tranx1 = "alice|bob|debit|rm|10";
		String tranx2 = "helen|bob|debit|rm|20";
		TransactionCollection tranxLst = new TransactionCollection();
		tranxLst.add(tranx1);
		tranxLst.add(tranx2);
		//block-1
		Block b1 = new Block(genesis.getHeader().getCurrentHash());
		b1.setTransactions(tranxLst);
		System.out.println("\n ---------------------- \n");
		System.out.println( b1 );
	}
	
}
