package eg.edu.alexu.csd.datastructure.stack.cs73;

public class ExpressionEvaluator implements IExpressionEvaluator {
      // when i throw an exception i use the run time
    public String infixToPostfix(String expression) {

        char c=' ';
        char o=' ';
        stack hold = new stack();
        int b=0;
        char pre=' ';
        //this boolean is to see if the number is negative or not
        boolean negative = false;
        char x []=expression.toCharArray();
        //here we check if the expresstion is empty or if it starts with a * / and throws an error in that case
        if(x.length==0 || x[0]=='*'|| x[0]=='/'){
            throw new RuntimeException();
        }
        String ans=" ";
        //here we check if the first number is negative
        if (x[0]=='-'){
            negative= true;
            b++;
        }
        if (x[0]=='+'){
            b++;
        }


        for (int w=b ;w<x.length;w++) {
            c = x[w];
            // this is to make the program work if you put spaces between the operators or operand
            if (c != ' ') {
                // here we see if the char is an operand or an operator and act accordingly
                if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
                    // here we check if the the input is a letter or a number else we give an error
                    if((c>='a' && c<='z')||(c>='A' && c<='Z')||Character.isDigit(c)) {
                        if (negative) {
                            ans = ans.substring(0, ans.length() - 1);
                            ans = ans + '0' + ' ' + c + ' ' + '-';
                            negative = false;
                        } else if (pre != '+' && pre != '-' && pre != '*' && pre != '/' && pre != '(' && pre != ')') {
                            ans = ans.substring(0, ans.length() - 1);
                            ans = ans + c;

                        } else {
                            ans = ans + c;

                        }
                    }else{
                        throw new RuntimeException();
                    }
                } else if (c == '+' || c == '-') {
                    // here it checks if the - is a mines or a negative sign
                    if (c == '-' && (pre == '+' || pre == '*' || pre == '-' || pre == '/' || pre == '(' )) {
                        negative = true;
                    }else if (c == '+' && (pre == '+' || pre == '*' || pre == '-' || pre == '/' || pre == '(' )) {
                        negative=false;
                         // here we see if the stack is empty or does it have a higher rank operator or an operator from the same level
                        //and handel the case according to it
                    }else if (hold.isEmpty()) {
                        hold.push(c);
                        ans = ans.substring(0, ans.length() - 1);
                    } else if ((char) hold.peek() == '*' || (char) hold.peek() == '/') {
                        ans = ans + (char) hold.pop();
                        if (hold.isEmpty() || (char) hold.peek() == '(' || (char) hold.peek() == ')') {
                            hold.push(c);
                        } else {
                            ans = ans +' '+ (char) hold.pop();
                            hold.push(c);
                        }

                    } else if ((char) hold.peek() == '+' || (char) hold.peek() == '-') {
                        ans = ans + (char) hold.pop();
                        hold.push(c);
                    } else {
                        ans = ans.substring(0, ans.length() - 1);
                        hold.push(c);
                    }
                } else if (c == '*' || c == '/') {
                    //we check if the previous char is an operator and if so then the expression is wrong
                    if(pre!='+'&&pre!='*'&&pre!='-'&&pre!='/'&&pre!='(') {
                        if (hold.isEmpty()) {
                            hold.push(c);
                            ans = ans.substring(0, ans.length() - 1);
                        } else if ((char) hold.peek() == '+' || (char) hold.peek() == '-') {
                            hold.push(c);
                            ans = ans.substring(0, ans.length() - 1);
                        } else if ((char) hold.peek() == '*' || (char) hold.peek() == '/') {
                            ans = ans + (char) hold.pop();
                            hold.push(c);
                        } else {
                            hold.push(c);
                            ans = ans.substring(0, ans.length() - 1);
                        }
                    }else{
                        throw new RuntimeException();
                    }
                } else if (c == '(') {
                    hold.push(c);
                    ans = ans.substring(0, ans.length() - 1);
                } else if (c == ')') {
                    //here we check if the ) has a ( to correspond with it because if not then we have an error
                    try {
                        o = (char) hold.pop();
                        while (o != '(') {
                            ans = ans + o + ' ';
                            o = (char) hold.pop();
                        }
                        ans = ans.substring(0, ans.length() - 1);
                    }catch (NullPointerException e){
                        throw new RuntimeException();
                    }

                }
                // here we set the next pre
                pre = c;
                ans = ans + ' ';
            }
        }
        int n=hold.size();
        for (int i=0;i<n;i++){
            //here we see if there is a ( because if there is then we have an error
            if((char)hold.peek()=='('){
                 throw new RuntimeException();
            }else {
                ans = ans + (char) hold.pop() + ' ';
            }
        }
        ans=ans.substring(0,ans.length()-1);
        int e;
        char f[]=ans.toCharArray();
        ans="";
        // here we get rid of the space in the beginning if there is one
        if (f[0]==' '){
            e=1;
        }else{
            e=0;
        }
        for(int q=e;q<f.length;q++){
            ans=ans+f[q];;

        }

        return ans;
    }
   public int evaluate(String expression) {
        stack hold = new stack();
        char x[]=expression.toCharArray();
        int ans=0;
        String t=" ";
        char pre =' ';
        double y=0;
        double m=0;
        double z=0;
        double temb =0;
        double ans1=0;
        int i;
        char c=' ';
        for (i=0;i<x.length;i++){
            c=x[i];
            // here we check if the expression has letters and reject it if so
            if((c>='a' && c<='z')||(c>='A' && c<='Z')){
                throw new RuntimeException();
            }else{
                if (Character.isDigit(c)) {
                    // here we test we handle the case of number bigger than nine
                    if (Character.isDigit(pre)){
                        y=(double)hold.pop();
                        y=y*10;
                        t=String.valueOf(c);
                        y=y+Double.valueOf(t);
                        hold.push(y);
                    }else {
                        t=String.valueOf(c);
                        y=Double.valueOf(t);
                        hold.push(y);

                    }
                    // in the following we handel each operator by getting the last to numbers of the stack then preforming on them and then add them back

                }else if (c=='+'){
                    m=(double)hold.pop();
                    z=(double)hold.pop();
                    temb =z+m;
                    hold.push(temb);

                }else if (c=='-') {
                    m = (double) hold.pop();
                    z = (double) hold.pop();
                    temb = z - m;
                    hold.push(temb);
                }else if (c=='*') {
                    m = (double) hold.pop();
                    z = (double) hold.pop();
                    temb = z * m;
                    hold.push(temb);
                }else if (c=='/'){
                    m=(double)hold.pop();
                    // here we handel divison by 0 by throwing an error
                    if (m==0){
                        throw new RuntimeException();

                    }else {
                        z = (double) hold.pop();
                        temb = z / m;
                        hold.push(temb);
                    }
                }
                pre=c;
            }

        }
        /*
        * since we want the finale ans to be an int we first round it to a long
        * then turn the long to a string
        * and finale turn it to an int and return it
        * */
        ans1=(double)hold.pop();
        long h=Math.round(ans1);
        t=String.valueOf(h);
        ans =Integer.valueOf(t);
        return ans;
    }
    
}
