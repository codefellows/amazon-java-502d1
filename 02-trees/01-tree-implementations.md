# Implement a Binary Search Tree
Implement a binary search tree with an add() method that enforces smaller
values always go to the `left` node and larger values always go `right`.

Write methods `min()` and `max()` that return the smallest and largest values
in the tree.

Write a method `contains(val)` that returns true only if the Binary Tree
contains the value passed in.

# Implement Tree
Build your own Tree (of integers) out of two classes:

* A `TreeNode` class for the nodes
  * with an int `value`
  * with a `TreeNode` reference `left`
  * with a `TreeNode` reference `right`
* A `MyTree` class for the entire tree
  * with one `TreeNode` reference `this.root`
  
For reference, here's one possible Binary Tree:
  
```
    10
   /  \
  4   37
 / \    \
1   5    92
`
