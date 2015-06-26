/*   This file is part of lanSimulation.
 *
 *   lanSimulation is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *
 *   lanSimulation is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with lanSimulation; if not, write to the Free Software
 *   Foundation, Inc. 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 *   Copyright original Java version: 2004 Bart Du Bois, Serge Demeyer
 *   Copyright C++ version: 2006 Matthias Rieger, Bart Van Rompaey
 */
package lanSimulation.internals;

import java.io.IOException;
import java.io.Writer;

import lanSimulation.Network;

/**
 * A <em>Node</em> represents a single Node in a Local Area Network (LAN).
 * Several types of Nodes exist.
 */
public class Node {
	// enumeration constants specifying all legal node types
	/**
	 * A node with type NODE has only basic functionality.
	 */
	public static final byte NODE = 0;
	/**
	 * A node with type WORKSTATION may initiate requests on the LAN.
	 */
	public static final byte WORKSTATION = 1;
	/**
	 * A node with type PRINTER may accept packages to be printed.
	 */
	public static final byte PRINTER = 2;

	/**
	 * Holds the name of the Node.
	 */
	public String name;
	/**
	 * Holds the next Node in the token ring architecture.
	 * 
	 * @see lanSimulation.internals.Node
	 */
	public Node nextNode;

	/**
	 * Construct a <em>Node</em> with given #type and #name.
	 */
	public Node( String _name) {
		name = _name;
		nextNode = null;
	}

	/**
	 * Construct a <em>Node</em> with given #type and #name, and which is linked
	 * to #nextNode.
	 */
	public Node(String _name, Node _nextNode) {
		name = _name;
		nextNode = _nextNode;
	}

	public void packetMovementLogger(Writer report, Network network)
			throws IOException {
		report.write("\tNode '");
		report.write(name);
		report.write("' passes packet on.\n");
		report.flush();
	}

	public void printDocumentHeaderLogger(Writer report, String author, String title) throws IOException {
		report.write("\tAccounting -- author = '");
		report.write(author);
		report.write("' -- title = '");
		report.write(title);
		report.write("'\n");
	}
	
	public void printHTMLOn(StringBuffer buf) {
		buf.append("\n\t<LI> ");
		buf.append("Node ");
		buf.append(name);
		buf.append(" [Node]");
		buf.append(" </LI>");
	}

	public void printOn(StringBuffer buf) {
		buf.append("Node ");
		buf.append(name);
		buf.append(" [Node]");
		buf.append(" -> ");
	}

	public void printXMLOn(StringBuffer buf) {
		buf.append("\n\t");
		buf.append("<node>");
		buf.append(name);
		buf.append("</node>");
	}

	public boolean isWorkStation() {
		return false;
	}
	
	public boolean isPrinter() {
		return false;
	}
	
}