class Node:
      
    # constructor to create node of 
    # binary tree
    def __init__(self, data):
        self.data = data
        self.left = self.right = None
  
# utility class to pass height object
class Height:
    def __init__(self):
        self.height = 0
  
# helper function to check if binary
# tree is height balanced
def isBalanced(root):
      
    # lh and rh to store height of 
    # left and right subtree
    lh = Height()
    rh = Height()
  
    # Base condition when tree is 
    # empty return true
    if root is None:
        return True
  
    # l and r are used to check if left
    # and right subtree are balanced
    l = isBalanced(root.left)
    r = isBalanced(root.right)
  
    # height of tree is maximum of 
    # left subtree height and
    # right subtree height plus 1
  
    if abs(lh.height - rh.height) <= 1:
        return l and r
  
    # if we reach here then the tree 
    # is not balanced
    return False
  
# Driver function to test the above function
"""
Constructed binary tree is 
            1
        / \
        2     3
    / \ /
    4 5 6 / 7 
"""
# to store the height of tree during traversal
  
root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
root.right.left = Node(6)
root.left.left.left = Node(7)
  
if isBalanced(root):
    print('Tree is balanced')
else:
    print('Tree is not balanced')
  
# This code is contributed by Shweta Singh