import java.util.ArrayList;
import java.util.List;

public class Leetcode131 {
    public List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s)
    {
        List<String> ll = new ArrayList<>();
        dfs(ll,s);
        return this.res;
    }
    public void dfs(List<String> L, String S_end)
    {
        if(S_end.equals(""))
        {
            res.add(L);
            return;
        }
        for(int i=0;i<S_end.length();i++)
        {
            String tmp = S_end.substring(0,i+1);
            if(isHWString(tmp))
            {
               List<String> LL = new ArrayList<>(L);
               LL.add(tmp);

                dfs(LL,S_end.substring(i+1));
            }
        }
    }
    public boolean isHWString(String s)
    {
        int i=0,j=s.length()-1;
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode131().partition("ababa"));
    }
}
