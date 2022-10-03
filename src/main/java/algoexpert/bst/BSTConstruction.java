package algoexpert.bst;

public final class BSTConstruction {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            BST currentNode = this;

            while(true) {
                if(value < currentNode.value){
                    if(currentNode.left == null) {
                        currentNode.left = new BST(value);
                        break;
                    } else
                        currentNode = currentNode.left;
                } else {
                    if(currentNode.right == null) {
                        currentNode.right = new BST(value);
                        break;
                    } else
                        currentNode = currentNode.right;
                }
            }
            return currentNode;
        }

        public BST insertRecursive(int value) {
            if(value < this.value){
                if(this.left == null) {
                    this.left = new BST(value);
                } else {
                    this.left.insertRecursive(value);
                }
            } else {
                if(this.right == null) {
                    this.right = new BST(value);
                } else {
                    this.right.insertRecursive(value);
                }
            }
            return this;
        }

        public boolean contains(int value) {
            BST currentNode = this;

            while(currentNode != null) {
                if(value < currentNode.value)
                    currentNode = currentNode.left;
                else if(value > currentNode.value)
                    currentNode = currentNode.right;
                else
                    return true;
            }
            return false;
        }

        public boolean containsRecursive(int value) {
            if(value < this.value) {
                if(this.left == null)
                    return false;
                else
                    return this.left.containsRecursive(value);
            } else if(value > this.value) {
                if(this.right == null)
                    return false;
                else
                    return this.right.containsRecursive(value);
            }
            return true;
        }

        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        private void remove(int value, BST parentNode) {
            BST currentNode = this;

            while (currentNode != null) {
                if(value < currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else if(value > currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    if(currentNode.left != null && currentNode.right != null) {
                        currentNode.value = currentNode.right.getMinValue();
                        currentNode.right.remove(currentNode.value, currentNode);
                    } else if(parentNode == null) {
                        if(currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        } else if(currentNode.right != null) {
                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        }
                    } else if(parentNode.left == currentNode) {
                        parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                    } else if(parentNode.right == currentNode) {
                        parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                    }
                    break;
                }
            }
        }

        private int getMinValue() {
            if(left == null)
                return value;
            else {
                return left.getMinValue();
            }
        }
    }
}
