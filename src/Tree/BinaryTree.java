package Tree;

import java.util.*;

/**
 * Created by rajkamal on 12/10/16.
 */
public class BinaryTree {
    BinaryTreeNode root;


    public BinaryTree() {
        root = null;
    }

    public BinaryTreeNode insert_level_order(BinaryTreeNode root, int data) {
        if (root == null) {
            root = new BinaryTreeNode(data);
            return  root;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        BinaryTreeNode curr = null;
        while(!q.isEmpty()) {
            curr =  q.poll();

            if (curr.getLeft() !=  null) {
                q.offer(curr.getLeft());
            } else {
                curr.setLeft(new BinaryTreeNode(data));
                return root;
            }

            if (curr.getRight() != null) {
                q.offer(curr.getRight());
            } else {
                curr.setRight(new BinaryTreeNode(data));
                return root;
            }
        }
        return  root;
    }

/*
    public void insert_recursive_BST(BinaryTreeNode root,  int data) {
        if (root ==  null) {
            root = new BinaryTreeNode(data);
            return;
        } if (root.getData()>= data) {
            insert_recursive_BST(root.getLeft(), data);
        } else {
            insert_recursive_BST(root.getRight(), data);
        }
    }
*/

    public BinaryTreeNode insert_recursive_BST(BinaryTreeNode root,  int data) {
        if (root ==  null) {
            root = new BinaryTreeNode(data);
            return root;
        }
        if (root.getData() > data) {
            root.left = insert_recursive_BST(root.getLeft(), data);
        } else {
            root.right = insert_recursive_BST(root.getRight(), data);
        }

        return root;
    }

    public void insert_iterative_BST(BinaryTreeNode root, int data) {
        if (root == null) {
            root = new BinaryTreeNode(data);
            return;
        }

        BinaryTreeNode node = root;

        while (node != null) {
            if (node.getData() >= data) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }

        node = new BinaryTreeNode(data);
    }


    public void insert_BT(int data) {
        root = insert_level_order(this.root, data);
    }



    public void insert_BST(int data) {
        this.root = insert_recursive_BST(this.root, data);
    }

    public void preorder_recursive(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preorder_recursive(root.getLeft());
            preorder_recursive(root.getRight());
        }
    }

    public void preorder_iterative(BinaryTreeNode root) {
        if (root == null)
            return;
        ArrayList<Integer> arr = new ArrayList<Integer>();

        Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();

        BinaryTreeNode curr;
        stk.push(root);

        while (!stk.isEmpty()) {
            curr = stk.pop();
            arr.add(curr.getData());
            System.out.print(curr.getData() + " ");

            if (curr.getRight() != null) {
                stk.push(curr.getRight());
            }

            if (curr.getLeft() != null) {
                stk.push(curr.getLeft());
            }

        }

        System.out.println();

        System.out.println("Arrray List of Preorder ");
        Iterator<Integer> itr = arr.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
    }

    public void preorder() {
        System.out.println("Recursive Preorder ");
        preorder_recursive(this.root);
        System.out.println();
        System.out.println("Iterative Preorder ");
        preorder_iterative(this.root);
    }

    public void  inorder_iterative(BinaryTreeNode root) {
        if (root == null)
            return;
        ArrayList <Integer> arr = new ArrayList<Integer>();
        Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();

        BinaryTreeNode curr = root;
        BinaryTreeNode temp = null;
        while ((!stk.isEmpty()) || (curr != null)) {
            //for (int i = 0; i < 20; i++) {
            if (curr != null) {
                stk.push(curr);
                curr = curr.getLeft();
            } else {
                curr = stk.pop();
                System.out.print(curr.getData() + " ");
                arr.add(curr.getData());

                curr = curr.getRight();
                if (curr != null ) {
                    stk.push(curr);
                    curr = curr.getLeft();
                }

            }
        }

        System.out.println();
        System.out.println("Array List");
        Iterator <Integer> itr = arr.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
    }

    public void inorder_recurssive(BinaryTreeNode root) {
        if (root != null) {
            inorder_recurssive(root.getLeft());
            System.out.print(root.getData() + " ");
            inorder_recurssive(root.getRight());
        }
    }

    public void inorder() {
        System.out.println("Recursive Inorder ");
        inorder_recurssive(this.root);
        System.out.println();
        System.out.println("iterative Inorder ");
        inorder_iterative(this.root);
    }


    public void postorder_recurssive(BinaryTreeNode root) {
        if (root != null) {
            postorder_recurssive(root.getLeft());
            postorder_recurssive(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    public void  postorder_iteratively(BinaryTreeNode root) {
        if (root == null)
            return;
        ArrayList <Integer> arr = new ArrayList<Integer>();
        Stack<BinaryTreeNode>stk = new Stack<BinaryTreeNode>();
        BinaryTreeNode curr, prev, temp;
        curr = prev = root;
        boolean test = true;

        while ((curr != null) || (!stk.isEmpty())) {
            // for (int i = 0; i < 20; i++) {
            if ((curr != null) && (test == true)) {
                if ((curr != null )&&(curr.getLeft() != prev) && (curr.getRight() != prev)) {
                    stk.push(curr);
                    curr = curr.getLeft();
                }else if ((curr.getLeft() != prev)) {
                    curr = curr.getRight();
                }else {
                    test = false;
                }
            } else {
                temp = stk.pop();
                System.out.print(temp.getData() + " ");
                arr.add(temp.getData());
                prev = temp;
                curr = stk.peek();
                test = true;
            }
        }

        System.out.println();
        System.out.println("Array List");
        Iterator <Integer> itr = arr.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

    }

    public void postorder() {
        System.out.println("Recursive Postorder ");
        postorder_recurssive(this.root);
        System.out.println();
        //System.out.println("Iterative Postorder ");
        //postorder_iteratively(this.root);
    }


    public void levelorder(BinaryTreeNode root) {

        System.out.println("Level Order ");
        BinaryTreeNode temp;
        ArrayList<Integer> res = new ArrayList<Integer>();

        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();

        if (root == null)
            return;

        q.offer(root);
        q.offer(null);




        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp != null) {
                res.add(temp.getData());

                if (temp.getLeft() != null) {
                    q.offer(temp.getLeft());
                }

                if (temp.getRight() != null) {
                    q.offer(temp.getRight());
                }

            } else {
                if (!q.isEmpty())
                    q.offer(null);
            }
        }
        Iterator<Integer> itr = res.iterator();

        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

        System.out.println();

    }

    public void level_order() {
        levelorder(this.root);
    }



    public BinaryTreeNode search_level_order(BinaryTreeNode root, int data) {
        BinaryTreeNode temp = null;
        if (root == null)
            return null;

        Queue<BinaryTreeNode> Q = new LinkedList<BinaryTreeNode>();
        Q.offer(root);

        while (!Q.isEmpty()) {
            temp = Q.poll();

            if (temp.getData() == data) {
                return temp;
            } else {
                if (temp.getLeft() != null) {
                    Q.offer(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    Q.offer(temp.getRight());
                }

            }
        }

        return null;
    }

    public BinaryTreeNode search_recursive(BinaryTreeNode root, int data) {
        if (root == null)
            return  null;

        if (root.getData() > data) {
            return  (search_recursive(root.getLeft(), data));
        }
        else if (root.getData() < data) {
            return (search_recursive(root.getRight(), data));
        }
        else {
            return (root);
        }

    }

    public BinaryTreeNode search_iterative(BinaryTreeNode  root, int data ) {

        if (root == null)
            return  null;
        BinaryTreeNode temp = root;

        while (temp!= null) {
            if (temp.getData() > data) {
                temp = temp.getLeft();
            } else if (temp.getData() < data){
                temp = temp.getRight();
            } else {
                return temp;
            }
        }

        return  temp;
    }


    public boolean search_BT(int data) {

        BinaryTreeNode node = search_level_order(this.root, data);
        System.out.println("Level Order Search ");

        if (node == null)
            return false;
        else
            return false;
    }

    public void  search_BST(int data ) {
        BinaryTreeNode node = search_iterative(this.root, data);

        System.out.println("Iterative search  ");

        if (node == null)
            System.out.println(data + " is not present in BST ");
        else
            System.out.println(data + " is present in BST ");

        System.out.println("Recurrsive Search ");

        node = search_recursive(this.root, data);

        if (node == null)
            System.out.println(data + " is not present in BST ");
        else
            System.out.println(data + " is present in BST ");

        System.out.println("LEvel order Search ");
        node = search_level_order(this.root, data);
        if (node == null)
            System.out.println(data + " is not present in BST ");
        else
            System.out.println(data + " is present in BST ");


        System.out.println();


    }
    public int minimum_BT_reccursive(BinaryTreeNode root) {

        if (root == null)
            return Integer.MAX_VALUE;


        BinaryTreeNode node = root;
        int minValue = root.getData();

        if (root!= null) {
            int leftMin = minimum_BT_Iterative(root.getLeft());
            int rightMin = minimum_BT_Iterative(root.getRight());

            if (leftMin < minValue)
                minValue = leftMin;

            if (rightMin < minValue)
                minValue = rightMin;
        }

        return minValue;
    }


    public int minimum_BT_Iterative(BinaryTreeNode root) {
        BinaryTreeNode temp = root;
        int min = root.getData();
        if (temp == null)
            return Integer.MIN_VALUE;

        Queue<BinaryTreeNode> Q = new LinkedList<BinaryTreeNode>();
        Q.offer(root);

        while (!Q.isEmpty()) {
            temp = Q.poll();

            if (min > temp.getData())
                min = temp.getData();

            if (temp.getLeft() != null)
                Q.offer(temp.getLeft());

            if (temp.getRight() != null)
                Q.offer(temp.getRight());
        }

        return  min;

    }


    public int minimum_iterative_BST(BinaryTreeNode node) {
        if (node == null)
            return  Integer.MIN_VALUE;

        BinaryTreeNode temp = node;
        while(node.getLeft() != null)
            node = node.getLeft();

        return node.getData();
    }

    public int minimum_recurrisive_BST(BinaryTreeNode node) {
        if (node == null )
            return Integer.MIN_VALUE;

        if (node.getLeft() != null)
            return minimum_recurrisive_BST(node.getLeft());
        else
            return node.getData();
    }

    public void  minimum_BST() {
        System.out.println("Minimum Iterative ");
        int data = minimum_iterative_BST(this.root);
        System.out.println("Minimum is " + data);

        System.out.println("Minimum Recurrsive  ");
        data = minimum_recurrisive_BST(this.root);
        System.out.println("Minimum is " + data);

        System.out.println("Minimum Level Order Iterative ");
        data = minimum_BT_Iterative(this.root);
        System.out.println("Minimum is " + data);
        System.out.println("Minimum Level Order Recurrsive ");
        data = minimum_BT_reccursive(this.root);
        System.out.println("Minimum is " + data);
        System.out.println();

    }

    public void minimum_BT() {
        System.out.println("Minimum Level Order Iterative ");
        int data = minimum_BT_Iterative(this.root);
        System.out.println("Minimum is " + data);
        System.out.println("Minimum Level Order Recurrsive ");
        data = minimum_BT_reccursive(this.root);
        System.out.println("Minimum is " + data);
        System.out.println();

    }

    public int maximum_iterative_BST(BinaryTreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        BinaryTreeNode node = root;


        while (node.getRight() != null)
            node = node.getRight();

        return node.getData();

    }


    public int maximum_recurrisive_BST(BinaryTreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        if (root.getRight() != null )
            return (maximum_recurrisive_BST(root.getRight()));
        else
            return root.getData();
    }

    public int maximum_BT_Iterative(BinaryTreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;

        Queue<BinaryTreeNode> Q = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode node;
        int max = root.getData();

        Q.offer(root);

        while(!Q.isEmpty()) {
            node = Q.poll();

            if (max < node.getData()) {
                max = node.getData();
            }
            if (node.getLeft() != null) {
                Q.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                Q.offer(node.getRight());
            }
        }

        return max;
    }

    public int maximum_BT_reccursive(BinaryTreeNode node) {
        if (node == null)
            return  Integer.MIN_VALUE;

        int leftMax  = maximum_BT_reccursive(node.getLeft());
        int rightMax = maximum_BT_reccursive(node.getRight());

        int max = node.getData();

        if (max < leftMax )
            max = leftMax;

        if (max < rightMax)
            max = rightMax;


        return max;

    }

    public void  maximum_BST() {
        System.out.println("Maximum Iterative ");
        int data = maximum_iterative_BST(this.root);
        System.out.println("Maximum is " + data);

        System.out.println("Maximum Recurrsive  ");
        data = maximum_recurrisive_BST(this.root);
        System.out.println("Maximum is " + data);

        System.out.println("Maximum Level Order Iterative ");
        data = maximum_BT_Iterative(this.root);
        System.out.println("Maximum is " + data);

        System.out.println("MMaximum Level Order Recurrsive ");
        data = maximum_BT_reccursive(this.root);
        System.out.println("Maximum is " + data);
        System.out.println();

    }

    public void maximum_BT() {
        System.out.println("Maximum Level Order Iterative ");
        int data = maximum_BT_Iterative(this.root);
        System.out.println("Maximum is " + data);
        System.out.println("Maximum Level Order Recurrsive ");
        data = maximum_BT_reccursive(this.root);
        System.out.println("Maximum is " + data);
        System.out.println();

    }

    public int size(BinaryTreeNode node ) {
        if (node == null )
            return  0;

        int leftsize;
        int rightsize;

        leftsize = (node.getLeft() == null) ? 0 : size(node.getLeft());
        rightsize = (node.getRight() == null) ? 0 : size(node.getRight());

        return (1 + (leftsize + rightsize));
    }

    public BinaryTreeNode delete_node_BST(BinaryTreeNode root, int data) {

        BinaryTreeNode temp = root;
        int min;
        if (root == null)
            return null;

        if (root.getData() > data) {
            root.left = delete_node_BST(root.getLeft(), data);
        }else if (root.getData() < data){
            root.right = delete_node_BST(root.getRight(), data);
        }else {
            if (root.left == null)
                root = root.getRight();
            else if (root.right == null)
                root = root.getLeft();
            else {
                min = minimum_recurrisive_BST(root.getRight());
                root.data = min;
                root.right = delete_node_BST(root.getRight(), data);
            }
        }

        return root;
    }

    public void delete_BST(int data) {
        this.root = delete_node_BST(this.root, data);
    }


}
