import java.util.ArrayList;
import java.util.List;

public class RBTree {
    Node root;

    public boolean addNode(int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.setColor(Color.BLACK);
            return result;
        } else {
            root = new Node(value);
            root.setColor(Color.BLACK);
            return true;
        }
        
    }

    public boolean addNode(Node node, int value) {
        if (node.getValue() == value) {
            return false;
        } else {
            if (node.getValue() > value) {
                if (node.getLeftChild() != null) {
                    boolean result = addNode(node.getLeftChild(), value);
                    node.setLeftChild(rebalance(node.getLeftChild()));
                    return result;
                } else {
                    node.setLeftChild(new Node(value));
                    node.leftChild.setColor(Color.RED);
                    return true;
                }
            } else {
                if (node.getRightChild() != null) {
                    boolean result = addNode(node.getRightChild(), value);
                    node.setRightChild(rebalance(node.getRightChild()));
                    return result;
                } else {
                    node.setRightChild(new Node(value));
                    node.rightChild.setColor(Color.RED);
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;

        do {
            needRebalance = false;
            if (result.getRightChild() != null && result.getRightChild().getColor() == Color.RED &&
                    (result.getLeftChild() == null || result.getLeftChild().getColor() == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.getLeftChild() != null && result.getLeftChild().getColor() == Color.RED
                    && result.getLeftChild().getLeftChild() != null &&
                    result.getLeftChild().getLeftChild().getColor() == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }

            if (result.getLeftChild() != null && result.getLeftChild().getColor() == Color.RED &&
                    result.getRightChild() != null && result.getRightChild().getColor() == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);
        return result;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.getLeftChild();
        Node betweenChild = leftChild.getRightChild();
        leftChild.setRightChild(node);
        node.setLeftChild(betweenChild);
        leftChild.setColor(node.getColor());
        node.setColor(Color.RED);
        return leftChild;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.getRightChild();
        Node betweenChild = rightChild.getLeftChild();
        rightChild.setLeftChild(node);
        node.setRightChild(betweenChild);
        rightChild.setColor(node.getColor());
        node.setColor(Color.RED);
        return rightChild;
    }

    private void colorSwap(Node node) {
        node.getLeftChild().setColor(Color.BLACK);
        node.getRightChild().setColor(Color.BLACK);
        node.setColor(Color.RED);
    }

    public void printTree() {
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                System.out.print(node);
                if (node.leftChild != null) {
                    nextLine.add(node.leftChild);
                }
                if (node.rightChild != null) {
                    nextLine.add(node.rightChild);
                }                
                
            }
            line = nextLine;
            System.out.println();
        }
    }

}