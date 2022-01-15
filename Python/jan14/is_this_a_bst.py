# Solution using inorder traversal
''' This solution does nto submit on hackerrank '''


class Solution:
    def inorder(self, root,l):
        if(root==None):
            return
        self.inorder(root.left,l)
        l.append(root.val)
        self.inorder(root.right,l)
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        l=[]
        self.inorder(root,l)
        for i in range(len(l)-1):
            if(l[i]>=l[i+1]):
                return False
        else:
            return True
   

# Solution using property of BST
''' This solution submits of hackerrank '''

def isBST(root, min_v, max_v):
    if(root == None):
        return True
    if(root.data < min_v or root.data > max_v):
        return False
    return (isBST(root.left, min_v, root.data-1) and isBST(root.right, root.data+1, max_v))

def check_binary_search_tree_(root):
    INT_MIN = float('-inf')
    INT_MAX = float('inf')
    return isBST(root, INT_MIN, INT_MAX)