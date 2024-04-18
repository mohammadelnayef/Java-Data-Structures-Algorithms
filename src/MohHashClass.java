import java.util.LinkedList;

public class MohHashClass {

    private LinkedList<Entry>[] arrayOfLists = new LinkedList[5];

    protected class Entry {
        private int key;
        private String value;

        public Entry(int key, String value){
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public String getKeyValuePairString()
        {
            return "Key: " + key + " Value: " + value;
        }
    }

    public void put(int key, String value)
    {
        var entry = new Entry(key, value);
        var list = new LinkedList<Entry>();
        list.add(entry);
        var index = hash(key);

        if(indexIsOccupied(index)){
            handleCollision(index,key, value);
        }
        else {
        arrayOfLists[index] = list;
        }
    }

    public String get(int key)
    {
        // Throw Exception if get is called on an empty Hash Table
        if(arrayOfLists.length == 0){
            throw new IllegalStateException("Can not get value from an empty Hash Table");
        }

        // Traverse array of Linked List
        for(int i = 0; i < arrayOfLists.length; i++){
            // Check if node exists at current index
            if(indexIsOccupied(i)){
                // Extract Linked List from current index
                var list = arrayOfLists[i];
                // Check If Linked List contains multiple Nodes
                if(list.size() > 1){
                    for(var node : list){
                        // Check if Node key is the key we are looking for
                        // Return the value if key found
                        if(node.getKey() == key){
                            return node.getValue();
                        }
                    }
                }
                // Linked List contains only one Node
                else {
                    // Get Node from Linked List
                    var node = list.peek();
                    // Check if Node key is the key we are looking for
                    // Return the value if key found
                    if(node.getKey() == key){
                        return node.getValue();
                    }
                }
            }
        }

        throw new IllegalStateException("Key not found in the Hash Table");
    }

    public void remove(int key)
    {
        // Throw Exception if remove is called on an empty Hash Table
        if(arrayOfLists.length == 0){
            throw new IllegalStateException("Can not remove value from an empty Hash Table");
        }

        // Traverse array of Linked List
        for(int i = 0; i < arrayOfLists.length; i++){
            // Check if node exists at current index
            if(indexIsOccupied(i)){
                // Extract Linked List from current index
                var list = arrayOfLists[i];
                // Check If Linked List contains multiple Nodes
                if(list.size() > 1){
                    for(var node : list){
                        // Check if Node key is the key we are looking for
                        // Remove the node if key found
                        if(node.getKey() == key){
                            list.remove(node);
                            return;
                        }
                    }
                }
                // Linked List contains only one Node
                else {
                    // Get Node from Linked List
                    var node = list.peek();
                    // Check if Node key is the key we are looking for
                    // Remove the node if key found
                    if(node.getKey() == key){
                        list.remove(node);
                        return;
                    }
                }
            }
        }

        throw new IllegalStateException("Key not found in the Hash Table");
    }

    private boolean indexIsOccupied(int index)
    {
        return arrayOfLists[index] != null;
    }

    private void handleCollision(int index, int key, String value)
    {
        var list = arrayOfLists[index];
        var entry = new Entry(key,value);
        list.add(entry);
    }

    private int hash(int key)
    {
        return key % 5;
    }

    public void displayItems()
    {
        // Traverse the array of Linked Lists
        for(int i = 0; i < arrayOfLists.length; i++){
            // Extract the Linked List from the array at the current Index
            var list = arrayOfLists[i];

            // Check if the extracted Linked List contains multiple nodes.
            if(list.size() > 1){
                System.out.println("List at index " + i  + " contains multiple Nodes: ");
                // Iterate over each node
                for(var node : list){
                    // Print node Key value pair
                    System.out.println(node.getKeyValuePairString());
                }
            }
            else{
            // Extract the Entry object from the Linked List
            var entry = list.peek();
            // Print node Key value pair
            System.out.println("List at index " + i + " contains: " + entry.getKeyValuePairString());
            }

        }
    }

}
