class Solution {
    public String simplifyPath(String path) {
        StringBuilder str= new StringBuilder();
        Stack<String> sc= new Stack<>();
        String p[]=path.split("/");
        for(int i=0;i<p.length;i++){
            if(!sc.isEmpty() && p[i].equals("..")) sc.pop();
            else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals("..")){
                sc.push(p[i]);
            }
        }
        if(sc.isEmpty()) return "/";
        while(!sc.isEmpty()){
            str.insert(0,sc.pop()).insert(0,"/");
        }
        
        return str.toString();
    }
}