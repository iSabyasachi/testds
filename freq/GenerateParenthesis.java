package testds.freq;
import java.util.*;
public class GenerateParenthesis{
    List<String> allValues = new ArrayList<>();
    Stack<String> stack = new Stack<>();
    
    public List<String> generateParenthesis(int n){
        return backTrack(0, 0, n);
    }
    private List<String> backTrack(int open, int closed, int n){
        if(open == closed && open == n){
            StringBuilder strB = new StringBuilder();
            while(!stack.isEmpty()){
                strB.append(stack.pop());
            }
            allValues.add(strB.toString());
            return allValues;
        }

        if(open < n){
            stack.push("(");
            backTrack(open + 1, closed, n);

            if(!stack.isEmpty())
            stack.pop();
        }

        if(closed < open){
            stack.push(")");
            backTrack(open, closed + 1, n);
            if(!stack.isEmpty())
                stack.pop();
        }

        return null;
    }
    public static void main(String[] args){
        int n = 3;
        GenerateParenthesis obj = new GenerateParenthesis();
        List<String> results = obj.generateParenthesis(3);
        System.out.println(results);
    }
}