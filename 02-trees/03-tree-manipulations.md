# Mirror Tree
Write a function that accepts a reference to a `TreeNode` and "mirrors" the
tree so all the nodes that used to be attached at a right branch are now
attached at a left branch, and vice-versa.

This tree should end up looking like this:

```
    10
   /  \
  4   37
 / \
1   5
```

```
    10
   /  \
  37   4
 / \
5   1
```

The trick to this problem is setting nodes equal to the result of a recusive
function and returning a reference to a node from each recursive call.

Consider this pseudo-code:

```
recurse(node):
  newLeft = recurse(node.right)
  node.right = recurse(node.left)
  node.left = newLeft
  return node
```

# Common Ancestor
Write a function that returns the first common ancestor of two nodes in a tree.

The first common ancestor of `4` and `5` is the root node `10`. The first
common ancestor of `5` and `1` is `37`.

```
    10
   /  \
  37   4
 / \
5   1
```
