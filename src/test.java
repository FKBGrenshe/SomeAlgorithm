import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        /*Solution_104_Hot100 solution104Hot100 = new Solution_104_Hot100();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        System.out.println(solution104Hot100.maxDepth(node3));*/

        /*Solution_102_Hot100 solution102Hot100 = new Solution_102_Hot100();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        System.out.println(solution102Hot100.levelOrder(node3));*/


        /*Solution_199_Hot100 solution199Hot100 = new Solution_199_Hot100();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        System.out.println(solution199Hot100.rightSideView(node3));*/

        /*Solution_101_Hot100 solution101Hot100 = new Solution_101_Hot100();
        TreeNode noderoot = new TreeNode(2);

        TreeNode second1 = new TreeNode(3);
        TreeNode second2 = new TreeNode(3);
        noderoot.left = second1;
        noderoot.right = second2;

        TreeNode third1 = new TreeNode(4);
        TreeNode third2 = new TreeNode(5);
        TreeNode third3 = new TreeNode(5);
        TreeNode third4 = new TreeNode(4);
        second1.left = third1;
        second1.right = third2;
        second2.left = third3;
        second2.right = third4;



        TreeNode four1 = new TreeNode(2);
        TreeNode four2 = new TreeNode(2);
        TreeNode four3 = new TreeNode(2);
        TreeNode four4 = new TreeNode(2);
        third2.left = four1;
        third2.right = four2;
        third4.left = four3;
        third4.right = four4;


        System.out.println(solution101Hot100.isSymmetric(noderoot));*/

        /*TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;

        Solution_98_Hot100 solution98Hot100 = new Solution_98_Hot100();
        System.out.println(solution98Hot100.isValidBST(node2));*/

        /*TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);

        n3.left = n1;
        n3.right = n4;
        n1.right = n2;
        Solution_230_Hot100 solution230Hot100 = new Solution_230_Hot100();
        System.out.println(solution230Hot100.kthSmallest(n3,1));*/


        /*Solution_105_Hot100 solution105Hot100 = new Solution_105_Hot100();
        int[] preOrder = new int[]{
                3,9,20,15,7
        };
        int[] midOrder = new int[]{
                9,3,15,20,7
        };

        solution105Hot100.buildTree(preOrder, midOrder);*/

        /*Solution_77 solution77 = new Solution_77();
        solution77.combine(4,2).stream().forEach(System.out::print);*/

        /*Solution_46_Hot100 solution46Hot100 = new Solution_46_Hot100();
        int[] nums = new int[]{
                1,2,3
        };
        solution46Hot100.permute(nums).stream().forEach(System.out::print);*/

        /*Solution_78_Hot100 solution78Hot100 = new Solution_78_Hot100();
        int[] nums = new int[]{
                1,2,3
        };
        solution78Hot100.subsets(nums).stream().forEach(System.out::println)*/;


        /*Solution_17_Hot100 solution17Hot100 = new Solution_17_Hot100();
        String digits = "234";
        solution17Hot100.letterCombinations(digits);*/

        /*List<Character> characters = new ArrayList<>();
        characters.add('x');
        characters.add('y');
        characters.add('z');
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : characters) {
            stringBuilder.append(character);
        }
        String substring = stringBuilder.toString();
        System.out.println(substring);*/

        /*int[] nums = new int[]{
//                2,3,6,7
                2,3,5
        };
        Solution_39_Hot100 solution39Hot100 = new Solution_39_Hot100();
        System.out.println(solution39Hot100.combinationSum(nums, 8));*/

        /*String s = "aab";

        Solution_131_Hot100 solution131Hot100 = new Solution_131_Hot100();
        System.out.println(solution131Hot100.partition(s));*/



        /*Solution_3_Hot100 solution3Hot100 = new Solution_3_Hot100();
        System.out.println(solution3Hot100.lengthOfLongestSubstring("dvdf"));*/

        /*Solution_121_Hot100 solution121Hot100 = new Solution_121_Hot100();
        System.out.println(solution121Hot100.maxProfit(new int[]{
                7,1,5,3,6,4
        }));*/

        /*Solution_55_Hot100  solution55Hot100 = new Solution_55_Hot100();
        System.out.println(solution55Hot100.canJump(new int[]{
//                3,2,1,0,4
                2,3,1,1,4
        }));*/

        /*Solution_509 solution509 = new Solution_509();
        System.out.println(solution509.fib(7));*/

        /*Solution_983 solution983 = new Solution_983();
        int[] days = new int[]{
                1,4,6,7,8,20
        };
        int[] costs = new int[]{
                2,7,15
        };
        System.out.println(solution983.mincostTickets(days, costs));*/


        Solution_22_Hot100 solution22Hot100 = new Solution_22_Hot100();
        System.out.println(solution22Hot100.generateParenthesis(2));

    }
}
