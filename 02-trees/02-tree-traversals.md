# In-Order Traversal
Write a method that accepts a Tree and prints out the values of each
node in an in-order traversal.

* [Tree Traversal Reference](http://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/)

#### In-Order Traversal
An in-order traversal visits and prints nodes recursively in this order:

```
visit(this.left)
print(this.value)
visit(this.right)
```

#### Pre-Order Traversal
A pre-order traversal visits and prints nodes recursively in this order:

```
print(this.value)
visit(this.left)
visit(this.right)
```

#### Post-Order Traversal
A post-order traversal visits and prints nodes recursively in this order:

```
visit(this.left)
visit(this.right)
print(this.value)
```

# Tree Min/Sum
Write a function that accepts a Tree (not necessarily a binary tree where
left is smaller and right is larger) and returns the minimum value in the tree.

Write a function that accepts a Tree and returns the total sum of all the
elements in the tree.

# Tree Equality
Write a method `equals()` that accepts two trees, traverses them simultaneously
and returns true only if they contain identical values at identical spots.

# Contains Duplicates
Write a method that accepts a tree and returns true if there are
any duplicate elements anywhere in the tree.

# Breadth-First Traversal
Write a method that accepts a Tree and prints out the values of each
node in a breadth-first traversal.

The nodes should be printed out level-by-level, from left to right.
Use a queue as an auxiliary data structure to achieve this effect.

A breadth-first traversal visits nodes in this order:

1. Put the root node in a queue
2. Dequeue one node and visit/print it
3. Enqueue the current nodes left child
4. Enqueue the current nodes right child
5. Repeat steps 2-5 until the queue is empty.

```
    10
   /  \
  4   37
 / \
1   5
```

This tree should display as `10 4 37 1 5`.

# Height
Write a method that calculates the height of a tree. The height of a tree is
the maximum distance between the root and any leaf leaf node.

The height of this tree is 3:

```
    10
   /  \
  4   37
 / \
1   5
```

The height of this tree is 4:

```
    10
   /  \
  4   37
 / \
1   5
     \
      9
```


# Number of Leaves
Write a method that calculates the number of leaf nodes in a tree. A leaf node
is any node that has no left or right children.
