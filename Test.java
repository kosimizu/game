package cardgames;

public class Test {
	public static void main(String[] args) {
		CardDAO dao = new CardDAO();
		String[] cardA = dao.findCardData("ドラゴン");
		for(int i = 0;i < cardA.length;i++){
			System.out.println(cardA[i]);
		}
	}
}
