package exercise_1;

import java.util.ArrayList;
import java.util.List;

public class Author {

	private final String name;
	private final List<Paper> papers = new ArrayList<>();

	public Author(String name) {
		this.name = name;
	}

	public void addPaper(Paper p) {
		papers.add(p);
		papers.sort(new CitationComparator());
	}

	public void modifyCitation(Paper p, int number, boolean increase) {
		if (increase)
			p.increaseCitation(number);
		else
			p.decreaseCitation(number);
		
		papers.sort(new CitationComparator());
	}

	public int calcHIndex() {
		StringBuilder input = new StringBuilder();
		for (Paper p : papers) {
			input.append(p.getCitation()).append(",");
		}
		return HIndex.calcHIndex(input.toString());
	}

	@Override
	public String toString() {
		StringBuilder content = new StringBuilder("Author:\t" + this.name + "\n");
		for (Paper p : papers) {
			content.append(p.getTitle()).append(":\t").append(p.getCitation()).append("\n");
		}
		content.append("HIndex:\t").append(calcHIndex());

		return content.toString();  //
	}

	public static void main(String[] args) {
		Author a = new Author("Zhang San");
		Paper p1 = new Paper("What is Software?", 2019, "Journal of HIT", 10);
		Paper p2 = new Paper("A Novel Coronavirus", 2020, "Science", 100);
		Paper p3 = new Paper("Study in HIT", 2018, "Nature", 5);
		Paper p4 = new Paper("A Bad Spring Festival", 2020, "Journal of HIT", 0);

		a.addPaper(p1);
		a.addPaper(p2);
		a.addPaper(p3);
		a.addPaper(p4);

		System.out.println(a);

		a.modifyCitation(p3, 2, false);
		a.modifyCitation(p4, 1, true);

		System.out.println(a);
	}
}
