package LeetCode.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rajkamal on 12/19/17.
 */
public class SimpleBinaryTreeNode {

    SimpleTreeNode root;

    public SimpleBinaryTreeNode() {
        root = null;
    }

    public SimpleTreeNode insert_level_order(SimpleTreeNode root, Integer data) {
        if (root == null) {
            root = new SimpleTreeNode(data);
            return  root;
        }

        Queue< SimpleTreeNode > q = new LinkedList<SimpleTreeNode>();
        q.offer(root);
        SimpleTreeNode curr = null;
        SimpleTreeNode node = null;
        if (data != null) {
            node = new SimpleTreeNode(data);
        }

        while(!q.isEmpty()) {
            curr =  q.poll();

            if (curr.getLeft() !=  null) {
                q.offer(curr.getLeft());
            } else {
                curr.setLeft(node);
                return root;
            }

            if (curr.getRight() != null) {
                q.offer(curr.getRight());
            } else {
                curr.setRight(node);
                return root;
            }
        }
        return  root;
    }

    public SimpleTreeNode insert_recursive_BST(SimpleTreeNode root,  int data) {
        if (root ==  null) {
            root = new SimpleTreeNode(data);
            return root;
        }
        if (root.getData() > data) {
            root.setLeft(insert_recursive_BST(root.getLeft(), data));
        } else {
            root.setRight(insert_recursive_BST(root.getRight(), data));
        }

        return root;
    }


    public void insert_BT(Integer data) {
        root = insert_level_order(this.root, data);
    }

    public void insert_BST(int data) {
        this.root = insert_recursive_BST(this.root, data);
    }

    public void preorder_recursive(SimpleTreeNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preorder_recursive(root.getLeft());
            preorder_recursive(root.getRight());
        }
    }

    public void preorder() {
        System.out.println("Preorder Traversal");
        preorder_recursive(this.root);
        System.out.println();
    }


    public void inorder_recurssive(SimpleTreeNode root) {
        if (root != null) {
            inorder_recurssive(root.getLeft());
            System.out.print(root.getData() + " ");
            inorder_recurssive(root.getRight());
        }
    }

    public void inorder() {
        System.out.println("Inorder Traversal ");
        inorder_recurssive(this.root);
        System.out.println();
    }


    public void postorder_recurssive(SimpleTreeNode root) {
        if (root != null) {
            postorder_recurssive(root.getLeft());
            postorder_recurssive(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    public void postorder() {
        System.out.println("PostOrder Traversal");
        postorder_recurssive(this.root);
        System.out.println();
    }

    public void levelorder(SimpleTreeNode root) {
        SimpleTreeNode temp;
        ArrayList<Integer> res = new ArrayList<Integer>();

        Queue<SimpleTreeNode> q = new LinkedList<SimpleTreeNode>();

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
    }

    public void level_order() {
        System.out.println("Level Order ");
        levelorder(this.root);
        System.out.println();
    }

    public SimpleTreeNode search_level_order(SimpleTreeNode root, int data) {
        SimpleTreeNode temp = null;
        if (root == null)
            return null;

        Queue<SimpleTreeNode> Q = new LinkedList<SimpleTreeNode>();
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

    public SimpleTreeNode search_recursive(SimpleTreeNode root, int data) {
        if (root == null)
            return  null;

        if (root.getData() > data) {
            return  (search_recursive(root.getLeft(), data));
        } else if (root.getData() < data) {
            return (search_recursive(root.getRight(), data));
        } else {
            return (root);
        }
    }

    public boolean search_BT(int data) {

        SimpleTreeNode node = search_level_order(this.root, data);
        System.out.println("Level Order Search ");

        if (node == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean  search_BST(int data ) {
        SimpleTreeNode node;

        node = search_recursive(this.root, data);

        if (node == null) {
            return false;
        } else {
            return true;
        }
    }

    public int BT_minimum(SimpleTreeNode root) {
        SimpleTreeNode temp = root;

        if (temp == null) {
            return Integer.MIN_VALUE;
        }

        int min = temp.getData();

        Queue<SimpleTreeNode> Q = new LinkedList<SimpleTreeNode>();
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


    public int BST_minimum(SimpleTreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        SimpleTreeNode temp = node;
        while(node.getLeft() != null)
            node = node.getLeft();

        return node.getData();
    }

    public int BT_maximum(SimpleTreeNode root) {
        SimpleTreeNode temp = root;

        if (temp == null) {
            return Integer.MIN_VALUE;
        }

        int max = temp.getData();

        Queue<SimpleTreeNode> Q = new LinkedList<SimpleTreeNode>();
        Q.offer(root);

        while (!Q.isEmpty()) {
            temp = Q.poll();

            if (max < temp.getData())
                max = temp.getData();

            if (temp.getLeft() != null)
                Q.offer(temp.getLeft());

            if (temp.getRight() != null)
                Q.offer(temp.getRight());
        }

        return  max;
    }


    public int  BST_maximum(SimpleTreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        SimpleTreeNode temp = node;
        while(node.getRight() != null)
            node = node.getRight();

        return node.getData();
    }

    public int size(SimpleTreeNode node ) {
        if (node == null )
            return  0;

        int leftsize;
        int rightsize;

        leftsize = (node.getLeft() == null) ? 0 : size(node.getLeft());
        rightsize = (node.getRight() == null) ? 0 : size(node.getRight());

        return (1 + (leftsize + rightsize));
    }

    public SimpleTreeNode BST_delete_internal(SimpleTreeNode root, int data) {

        SimpleTreeNode temp = root;
        int min;
        if (root == null)
            return null;

        if (root.getData() > data) {
            root.setLeft(BST_delete_internal(root.getLeft(), data));
        }else if (root.getData() < data){
            root.setRight(BST_delete_internal(root.getRight(), data));
        }else {
            if (root.getLeft() == null)
                root = root.getRight();
            else if (root.getRight() == null)
                root = root.getLeft();
            else {
                min = BST_minimum(root.getRight());
                root.setData(min);
                root.setRight(BST_delete_internal(root.getRight(), min));
            }
            temp = null;
        }

        return root;
    }

    public void BST_delete(int data) {
        this.root = BST_delete_internal(this.root, data);
    }

    public SimpleTreeNode BT_delete_internal(SimpleTreeNode node, int data) {
        if (node == null) {
            return  null;
        }

        if (node.getData() > data ) {
            node.setLeft(BT_delete_internal(node.getLeft(), data));
        } else if (node.getData() < data) {
            node.setRight(BT_delete_internal(node.getRight(), data));
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                node = null;
            } else if (node.getLeft() == null) {
                node =  node.getRight();
            } else if (root.getRight() == null) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return node;
    }

    public void BT_delete(int data) { this.root = BT_delete_internal(this.root, data); }


    public int maxDepth(SimpleTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_size =  maxDepth(root.getLeft());
        int right_size = maxDepth(root.getRight());
        return ( (left_size > right_size) ? (left_size + 1) : (right_size + 1));
    }
}
