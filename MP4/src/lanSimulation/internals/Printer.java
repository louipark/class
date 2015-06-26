package lanSimulation.internals;

public class Printer extends Node {

	public Printer(String _name) {
		super(_name);
	}

	public Printer(String _name, Node _nextNode) {
		super(_name, _nextNode);
	}

	@Override
	public void printHTMLOn(StringBuffer buf) {
		buf.append("\n\t<LI> ");
		buf.append("Printer ");
		buf.append(name);
		buf.append(" [Printer]");
		buf.append(" </LI>");
	}

	@Override
	public void printOn(StringBuffer buf) {
		buf.append("Printer ");
		buf.append(name);
		buf.append(" [Printer]");
		buf.append(" -> ");
	}

	@Override
	public void printXMLOn(StringBuffer buf) {
		buf.append("\n\t");
		buf.append("<printer>");
		buf.append(name);
		buf.append("</printer>");
	}

	@Override
	public boolean isPrinter() {
		return true;
	}
}
