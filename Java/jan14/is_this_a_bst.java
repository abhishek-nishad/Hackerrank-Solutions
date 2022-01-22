package Java.jan14;

import java.util.*;
class Solution
{   // Using inorder traversal
    public static void inorder(Node root, LinkedList<Integer> list)
    {
        if(root==null)
            return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    boolean checkBST(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        Tree.inorder(root, list);
        for(int i=0; i<list.size()-1; i++)
        {
            if(list.get(i)>=list.get(i+1))
                return false;
        }
        return true;
    }
    //Inorder solution end


    //Using property of BST
    public boolean checkBST(Node root, int min, int max)
    {
        if(root==null)
            return true;
        if(root.data < min || root.data > max)
            return false;
        return (checkBST(root.left, min, root.data-1) && checkBST(root.right, root.data+1, max));

    }

    public boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    //BST Property solution end.
}


