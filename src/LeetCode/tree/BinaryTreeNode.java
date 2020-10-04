package LeetCode.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rajkamal on 12/16/17.
 */
public class BinaryTreeNode<T extends Number & Comparable <T>> {
    TreeNode<T> root;

    public BinaryTreeNode() {
        root = null;
    }

    public TreeNode<T> insert_level_order(TreeNode<T> root, T data) {
        if (root == null) {
            root = new TreeNode<T>(data);
            return  root;
        }
        Queue< TreeNode<T> > q = new LinkedList<TreeNode<T>>();
        q.offer(root);
        TreeNode curr = null;
        while(!q.isEmpty()) {
            curr =  q.poll();

            if (curr.getLeft() !=  null) {
                q.offer(curr.getLeft());
            } else {
                curr.setLeft(new TreeNode(data));
                return root;
            }

            if (curr.getRight() != null) {
                q.offer(curr.getRight());
            } else {
                curr.setRight(new TreeNode(data));
                return root;
            }
        }
        return  root;
    }

    public TreeNode insert_recursive_BST(TreeNode<T> root,  T data) {
        if (root ==  null) {
            root = new TreeNode(data);
            return root;
        }
        if (root.getData().compareTo(data) > 0) {
            root.setLeft(insert_recursive_BST(root.getLeft(), data));
        } else {
            root.setRight(insert_recursive_BST(root.getRight(), data));
        }

        return root;
    }


    public void insert_BT(T data) {
        root = insert_level_order(this.root, data);
    }

    public void insert_BST(T data) {
        this.root = insert_recursive_BST(this.root, data);
    }

    public void preorder_recursive(TreeNode<T> root) {
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


    public void inorder_recurssive(TreeNode<T> root) {
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


    public void postorder_recurssive(TreeNode<T> root) {
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

    public void levelorder(TreeNode<T> root) {
        TreeNode temp;
        ArrayList<T> res = new ArrayList<T>();

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        if (root == null)
            return;

        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp != null) {
                res.add((T) temp.getData());

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
        Iterator<T> itr = res.iterator();

        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    public void level_order() {
        System.out.println("Level Order ");
        levelorder(this.root);
        System.out.println();
    }

    public TreeNode<T> search_level_order(TreeNode<T> root, T data) {
        TreeNode<T> temp = null;
        if (root == null)
            return null;

        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root);

        while (!Q.isEmpty()) {
            temp = Q.poll();

            if (temp.getData().compareTo(data) == 0) {
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

    public TreeNode<T> search_recursive(TreeNode<T> root, T data) {
        if (root == null)
            return  null;

        if (root.getData().compareTo(data) > 0) {
            return  (search_recursive(root.getLeft(), data));
        }
        else if (root.getData().compareTo(data) > 0) {
            return (search_recursive(root.getRight(), data));
        }
        else {
            return (root);
        }

    }

    public boolean search_BT(T data) {

        TreeNode<T> node = search_level_order(this.root, data);
        System.out.println("Level Order Search ");

        if (node == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean  search_BST(T data ) {
        TreeNode node;

        node = search_recursive(this.root, data);

        if (node == null) {
            return false;
        } else {
            return true;
        }
    }

    public T BT_minimum(TreeNode<T> root) {
        TreeNode<T> temp = root;

        if (temp == null) {
            return null;
        }

        T min = temp.getData();

        Queue<TreeNode<T>> Q = new LinkedList<TreeNode<T>>();
        Q.offer(root);

        while (!Q.isEmpty()) {
            temp = Q.poll();

            if (min.compareTo(temp.getData()) > 0)
                min = temp.getData();

            if (temp.getLeft() != null)
                Q.offer(temp.getLeft());

            if (temp.getRight() != null)
                Q.offer(temp.getRight());
        }

        return  min;
    }


    public T BST_minimum(TreeNode<T> node) {
        if (node == null) {
            return null;
        }

        TreeNode temp = node;
        while(node.getLeft() != null)
            node = node.getLeft();

        return node.getData();
    }

    public T BT_maximum(TreeNode<T> root) {
        TreeNode<T> temp = root;

        if (temp == null) {
            return null;
        }

        T max = temp.getData();

        Queue<TreeNode<T>> Q = new LinkedList<TreeNode<T>>();
        Q.offer(root);

        while (!Q.isEmpty()) {
            temp = Q.poll();

            if (max.compareTo(temp.getData()) < 0)
                max = temp.getData();

            if (temp.getLeft() != null)
                Q.offer(temp.getLeft());

            if (temp.getRight() != null)
                Q.offer(temp.getRight());
        }

        return  max;
    }


    public T BST_maximum(TreeNode<T> node) {
        if (node == null) {
            return null;
        }

        TreeNode temp = node;
        while(node.getRight() != null)
            node = node.getRight();

        return node.getData();
    }

    public int size(TreeNode<T> node ) {
        if (node == null )
            return  0;

        int leftsize;
        int rightsize;

        leftsize = (node.getLeft() == null) ? 0 : size(node.getLeft());
        rightsize = (node.getRight() == null) ? 0 : size(node.getRight());

        return (1 + (leftsize + rightsize));
    }

    public TreeNode BST_delete_internal(TreeNode<T> root, T data) {

        TreeNode<T> temp = root;
        T min;
        if (root == null)
            return null;

        if (root.getData().compareTo(data) > 0) {
            root.setLeft(BST_delete_internal(root.getLeft(), data));
        }else if (root.getData().compareTo(data) < 0){
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
        }

        return root;
    }

    public void BST_delete(T data) {
        this.root = BST_delete_internal(this.root, data);
    }


}
