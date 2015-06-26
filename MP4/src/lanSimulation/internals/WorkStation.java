package lanSimulation.internals;

public class WorkStation extends Node {

	public WorkStation(String _name) {
		super(_name);
	}

	public WorkStation(String _name, Node _nextNode) {
		super(_name, _nextNode);
	}

	@Override
	public void printHTMLOn(StringBuffer buf) {
		buf.append("\n\t<LI> ");
		buf.append("Workstation ");
		buf.append(name);
		buf.append(" [Workstation]");
		buf.append(" </LI>");
	}

	@Override
	public void printOn(StringBuffer buf) {
		buf.append("Workstation ");
		buf.append(name);
		buf.append(" [Workstation]");
		buf.append(" -> ");
	}

	@Override
	public void printXMLOn(StringBuffer buf) {
		buf.append("\n\t");
		buf.append("<workstation>");
		buf.append(name);
		buf.append("</workstation>");
	}

	@Override
	public boolean isWorkStation() {
		return true;
	}
}
