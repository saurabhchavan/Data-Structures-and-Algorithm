import javax.swing.*;
import javax.swing.border.*;
import org.jdesktop.swingx.prompt.PromptSupport;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class BinaryTreeArithmeticEvaluation extends JFrame {

	JLabel TreeExp,JError;
	JTextField txtExp;
	JPanel contentPane;
	String expr;
	char character;
	int ps = 0;
	Node root;

	public void bTree(String expr) {
		this.expr = expr;
		root = new Node();
		root = buildExpressionTree(root);
	}
	static class Node {
		Object element;
		Node lf, rt;
	}
	
	/* Logic for Expression Term Evaluator */

	public Node buildExpressionTree(Node n) {
		Node lfTree = new Node();
		lfTree = buildTermTree(lfTree);

		readcharacter();
		if (character == '+' || character == '-') {
			ps++;
			n.lf = lfTree;
			n.element = character;
			n.rt = buildExpressionTree(new Node());
		} 
		else {
			n = lfTree;
		}
		return n;
	}
	
	/* Logic for Factor Constant Evaluator*/
	
	public Node buildFactorTree(Node n) {
		readcharacter();
		if (character == '(') {
			ps++;
			n = buildExpressionTree(new Node());
			readcharacter();
			if (character == ')')
				ps++;
			else
				System.out.println("The ')' is missing");
		} else {
			n.element = getConstant();
		}
		return n;
	}
	
	/* Logic for Term Factor Evaluator */
	
	public Node buildTermTree(Node n) {
		Node lfTree = new Node();
		lfTree = buildFactorTree(lfTree);

		readcharacter();
		if (character == '*' || character == '/') {
			ps++;
			n.lf = lfTree;
			n.element = character;
			n.rt = buildTermTree(new Node());
		} else {
			n = lfTree;
		}
		return n;
	}

	
	public String getConstant() {
		StringBuilder sb = new StringBuilder();

		for (int i = ps; i < expr.length(); i++) {
			if (expr.substring(i, i + 1).matches("[0-9,.]")) {
				sb.append(expr.charAt(i));
				continue;
			}
			ps = i;
			return sb.toString();
		}
		ps = expr.length();
		return sb.toString();
	}

	
	public void readcharacter() {
		for (int i = ps; i < expr.length(); i++) {
			if (expr.substring(i, i + 1).matches("[0-9]"))
				continue;
			character = expr.charAt(i);
			return;
		}
		character = ' ';
	}


	public double treeEval() {
		return treeTraversal(root);
	}

	
	public double treeTraversal(Node n) {
		if (n != null) {
			if (n.lf != null && n.rt != null) {
				double rt = treeTraversal(n.rt);
				double lf = treeTraversal(n.lf);
				if (n.element.equals('+')) {
					return lf + rt;
				} else if (n.element.equals('-')) {
					return lf - rt;
				} else if (n.element.equals('*')) {
					return lf * rt;
				} else if (n.element.equals('/')) {
					return lf / rt;
				}
				System.out.println("Character not entered.");
				return 0.0d;
			}
			try {
				return Double.parseDouble((String) n.element);
			} catch (NumberFormatException ex) {
				System.out.println("Please enter a value");
				return 0.0d;
			}
		}
		System.out.println("Null node retured.");
		return 0.0d;
	}


	public String toString() {
		return getTreeExpression(root);
	}
	
	public String getTreeExpression(Node n) {
		StringBuilder sb = new StringBuilder();

		if (n != null) {
			if (n.lf != null) {
				sb.append("(");
				sb.append(getTreeExpression(n.lf));
			}
			sb.append(n.element);
			if (n.rt != null) {
				sb.append(getTreeExpression(n.rt));
				sb.append(")");
			}
		}
		return sb.toString();
		
	}

	public BinaryTreeArithmeticEvaluation() {
		
		contentPane = new JPanel();
		JLabel lblExpressionTreeApplication = new JLabel("");
		txtExp = new JTextField();
		JButton btnTxtEval = new JButton("Evaluate Expression");
		TreeExp = new JLabel("");
		JLabel JLOutput = new JLabel("Expression Output:");

		setTitle("Expression Tree Evaluator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 275);
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblExpressionTreeApplication.setBounds(10, 11, 398, 20);
		contentPane.add(lblExpressionTreeApplication);
		
        PromptSupport.setPrompt("Enter a valid expression", txtExp);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, txtExp);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIGHLIGHT_PROMPT, txtExp);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, txtExp);
        PromptSupport.setFontStyle(Font.BOLD, txtExp);
        PromptSupport.setFontStyle(Font.ITALIC, txtExp);
        PromptSupport.setFontStyle(Font.ITALIC | Font.BOLD, txtExp);
        
		txtExp.setBounds(20, 62, 187, 20);
		contentPane.add(txtExp);
		
		btnTxtEval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BinaryTreeArithmeticEvaluation tree = new BinaryTreeArithmeticEvaluation();
				tree.bTree(txtExp.getText());	
				TreeExp.setText("" + tree.treeEval());
			JError.setText("");
			}
		
		});
		btnTxtEval.setBounds(243, 62, 201, 23);
		contentPane.add(btnTxtEval);
		TreeExp.setOpaque(true);
		TreeExp.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		TreeExp.setHorizontalAlignment(SwingConstants.CENTER);
		TreeExp.setBounds(20, 136, 388, 26);
		contentPane.add(TreeExp);
		JLOutput.setBounds(30, 104, 153, 20);
		contentPane.add(JLOutput);
	
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BinaryTreeArithmeticEvaluation win = new BinaryTreeArithmeticEvaluation();
					win.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
