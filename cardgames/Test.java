package cardgames;

public class Test {
	public static void main(String[] args) {
		CardDAO dao = new CardDAO();
		Card cardA = dao.findCardData("ドラゴン");
		System.out.println(cardA.name);
	}
}
