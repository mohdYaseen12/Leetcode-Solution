class ProductOfNumbers {
    List<Integer> prefixProduct;
    int prevElement;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prevElement = 1;
        prefixProduct.add(prevElement);
        
    }
    
    public void add(int num) {
        if(num == 0){
            prefixProduct = new ArrayList<>();
            prevElement = 1;
            prefixProduct.add(prevElement);
        }
        else{
            prevElement = prevElement * num;
            prefixProduct.add(prevElement);
        }
    }
    
    public int getProduct(int k) {
        int n = prefixProduct.size();
        // if(prefixProduct.get(n-1-k) != 0)
         return (k < n) ? prevElement/prefixProduct.get(n-1-k) : 0;
        // else return -1;
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */