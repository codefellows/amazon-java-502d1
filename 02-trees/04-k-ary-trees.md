# K-ary Trees
K-ary trees are trees that have `K` number of child nodes per node. Trees we've
seen so far only have two child nodes per node. K-ary trees are useful for
repsenting anything that has more than once choice. They're especially useful
at representing HTML where each element in HTML can have multiple children.

The `-ary` in K-ary is like the suffix in "binary" or "ternary." As a whole
it's pronounces "kay-air-ee"

```html
<html>
  <head>
    <title></title>
    <script src="main.js"></script>
  </head>
  <body>
    <h1>Welcome!</h1>
    <p>Welcome to my homepage!</p>
    <p>Here's some of my favorite foods:</p>
    <ul>
      <li>cheese</li>
      <li>bread</li>
      <li>spaghetti</li>
    </ul>
  </body>
</html>
```

You can represent K-ary trees with a TreeNode class like this. The
`List<String>` stores multiple children.

```java
KaryNode {
  String data;
  List<String> children;
}
```

## Challenge
Use Java's `Scanner` to read an HTML file and create a tree representing the
HTML DOM.
